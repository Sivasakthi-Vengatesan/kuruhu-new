package com.kuruhu.court;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChargeSheetRepository extends JpaRepository<ChargeSheet, Long> {
    List<ChargeSheet> findAll();
}
