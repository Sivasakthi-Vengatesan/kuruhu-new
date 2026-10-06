package com.pramaan.repository;

import com.pramaan.entity.FirTimeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirTimelineRepository extends JpaRepository<FirTimeline, Long> {
    List<FirTimeline> findByFirIdOrderByEventTimeAsc(Long firId);
}