package com.pramaan.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramaan.dto.TtsRequest;
import com.pramaan.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class TtsService {

    private static final Logger log = LoggerFactory.getLogger(TtsService.class);

    @Value("${ai.tts.catalyst.client-id:}")
    private String clientId;

    @Value("${ai.tts.catalyst.client-secret:}")
    private String clientSecret;

    @Value("${ai.tts.catalyst.refresh-token:}")
    private String refreshToken;

    @Value("${ai.tts.catalyst.org-id:60078981735}")
    private String orgId;

    @Value("${ai.tts.catalyst.redirect-uri:http://www.zoho.com/catalyst}")
    private String redirectUri;

    private final ObjectMapper objectMapper;

    public TtsService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private final RestTemplate restTemplate = new RestTemplate();

    private String cachedToken = null;
    private long tokenExpiresAt = 0;

    public byte[] synthesizeAudio(TtsRequest request) {
        if (!StringUtils.hasText(request.getText())) {
            throw new BadRequestException("Text is required for TTS synthesis");
        }

        if (!StringUtils.hasText(clientId) || !StringUtils.hasText(clientSecret) || !StringUtils.hasText(refreshToken)) {
            throw new BadRequestException("TTS provider is not configured on server (missing Catalyst credentials). Browser Web Speech fallback should be used.");
        }

        try {
            String accessToken = getAccessToken();
            String ttsEndpoint = "https://api.catalyst.zoho.in/quickml/api/v1/models/zia/tts/synthesize";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("CATALYST-ORG", orgId);
            headers.set("Authorization", "Zoho-oauthtoken " + accessToken);

            String speaker = StringUtils.hasText(request.getSpeaker()) ? request.getSpeaker() :
                    ("kn".equalsIgnoreCase(request.getLanguage()) ? "Anu" : "Mary");

            Map<String, Object> body = Map.of(
                    "text", request.getText(),
                    "language", request.getLanguage() != null ? request.getLanguage() : "en",
                    "speaker", speaker,
                    "speed", request.getSpeed() != null ? request.getSpeed() : "moderate",
                    "pitch", request.getPitch() != null ? request.getPitch() : "moderate",
                    "emotion", request.getEmotion() != null ? request.getEmotion() : "neutral"
            );

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
            ResponseEntity<byte[]> response = restTemplate.exchange(ttsEndpoint, HttpMethod.POST, entity, byte[].class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody();
            } else {
                throw new BadRequestException("TTS synthesis service returned status: " + response.getStatusCode());
            }
        } catch (Exception e) {
            log.error("TTS synthesis failure: {}", e.getMessage());
            throw new BadRequestException("TTS provider error: " + e.getMessage());
        }
    }

    private synchronized String getAccessToken() {
        if (cachedToken != null && System.currentTimeMillis() < tokenExpiresAt - 60000) {
            return cachedToken;
        }

        String tokenUrl = "https://accounts.zoho.in/oauth/v2/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "refresh_token");
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("refresh_token", refreshToken);
        map.add("redirect_uri", redirectUri);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(tokenUrl, request, String.class);

        try {
            Map<?, ?> json = objectMapper.readValue(response.getBody(), Map.class);
            String token = (String) json.get("access_token");
            if (token == null) {
                throw new BadRequestException("Zoho token refresh returned no access_token: " + response.getBody());
            }
            Object expObj = json.get("expires_in");
            long expSeconds = (expObj instanceof Number) ? ((Number) expObj).longValue() : 3600L;
            this.cachedToken = token;
            this.tokenExpiresAt = System.currentTimeMillis() + (expSeconds * 1000);
            return token;
        } catch (Exception e) {
            throw new BadRequestException("Failed to parse token response: " + e.getMessage());
        }
    }
}