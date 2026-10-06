package com.pramaan.service;

import com.pramaan.dto.ActivityEventDto;
import com.pramaan.dto.CreateAuditLogRequest;
import com.pramaan.entity.AuditLog;
import com.pramaan.entity.User;
import com.pramaan.repository.AuditLogRepository;
import com.pramaan.security.SecurityUtils;
import com.pramaan.security.UserPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private final AuditLogRepository auditLogRepository;

    public ActivityService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }


    @Transactional(readOnly = true)
    public List<ActivityEventDto> getActivities(String query, String type) {
        List<AuditLog> logs = auditLogRepository.searchAuditLogs(query, type);
        return logs.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Transactional
    public void logActivity(User user, String action, String targetDescription, String targetType, String detail) {
        String actorName = "System";
        String actorRole = "System";

        if (user != null) {
            actorName = user.getFullName();
            actorRole = user.getRoles().stream().findFirst().map(r -> r.getName().replace("ROLE_", "")).orElse("Officer");
        } else {
            UserPrincipal principal = SecurityUtils.getCurrentUserPrincipal();
            if (principal != null) {
                actorName = principal.getFullName();
                actorRole = principal.getAuthorities().stream().findFirst().map(a -> a.getAuthority().replace("ROLE_", "")).orElse("Officer");
            }
        }

        AuditLog log = AuditLog.builder()
                .user(user)
                .actorName(actorName)
                .actorRole(actorRole)
                .action(action)
                .targetDescription(targetDescription)
                .targetType(StringUtils.hasText(targetType) ? targetType.toLowerCase() : "system")
                .detail(detail)
                .timestamp(OffsetDateTime.now())
                .build();

        auditLogRepository.save(log);
    }

    @Transactional
    public ActivityEventDto createActivity(CreateAuditLogRequest request) {
        AuditLog log = AuditLog.builder()
                .actorName(SecurityUtils.getCurrentUsername())
                .actorRole("Officer")
                .action(request.getAction())
                .targetDescription(request.getTargetDescription())
                .targetType(request.getTargetType().toLowerCase())
                .detail(request.getDetail())
                .timestamp(OffsetDateTime.now())
                .build();

        log = auditLogRepository.save(log);
        return mapToDto(log);
    }

    public ActivityEventDto mapToDto(AuditLog log) {
        return ActivityEventDto.builder()
                .id(String.valueOf(log.getId()))
                .time(log.getTimestamp() != null ? log.getTimestamp().toString() : OffsetDateTime.now().toString())
                .actor(log.getActorName())
                .role(log.getActorRole())
                .action(log.getAction())
                .target(log.getTargetDescription())
                .targetType(log.getTargetType() != null ? log.getTargetType().toLowerCase() : "system")
                .detail(log.getDetail())
                .build();
    }
}