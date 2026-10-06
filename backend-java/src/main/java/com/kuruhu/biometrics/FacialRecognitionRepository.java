package com.kuruhu.biometrics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FacialRecognitionRepository extends JpaRepository<FacialRecognitionRecord, Long> {
    List<FacialRecognitionRecord> findAll();
}
