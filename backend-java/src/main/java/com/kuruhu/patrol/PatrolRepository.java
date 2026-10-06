package com.kuruhu.patrol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatrolRepository extends JpaRepository<PatrolBeat, Long> {
    List<PatrolBeat> findByStationCode(String stationCode);
}
