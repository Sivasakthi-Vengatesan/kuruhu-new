package com.kuruhu.validator;

import com.kuruhu.dto.FIRDTO;
import org.springframework.stereotype.Component;

@Component
public class FirValidator {
    public boolean validate(FIRDTO fir) {
        return fir != null && fir.getNumber() != null && !fir.getNumber().isBlank();
    }
}
