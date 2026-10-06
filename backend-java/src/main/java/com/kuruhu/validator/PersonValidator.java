package com.kuruhu.validator;

import com.kuruhu.dto.PersonDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonValidator {
    public boolean validate(PersonDTO person) {
        return person != null && person.getName() != null && !person.getName().isBlank();
    }
}
