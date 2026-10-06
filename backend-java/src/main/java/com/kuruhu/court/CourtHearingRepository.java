package com.kuruhu.court;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourtHearingRepository extends JpaRepository<CourtHearing, Long> {
    List<CourtHearing> findAll();
}
