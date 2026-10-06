package com.kuruhu.patrol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatrolBeatRepository extends JpaRepository<PatrolBeat, Long> {
    List<PatrolBeat> findAll();
}
