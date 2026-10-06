package com.kuruhu.court;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourtWarrantRepository extends JpaRepository<CourtWarrant, Long> {
    List<CourtWarrant> findAll();
}
