package com.kuruhu.forensics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ForensicRepository extends JpaRepository<ForensicReport, Long> {
    List<ForensicReport> findAll();
}
