package com.kuruhu.forensics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BallisticsRepository extends JpaRepository<BallisticsAnalysis, Long> {
    List<BallisticsAnalysis> findAll();
}
