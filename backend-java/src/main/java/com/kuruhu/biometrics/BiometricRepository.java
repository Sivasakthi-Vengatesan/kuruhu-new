package com.kuruhu.biometrics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BiometricRepository extends JpaRepository<BiometricProfile, Long> {
    List<BiometricProfile> findAll();
}
