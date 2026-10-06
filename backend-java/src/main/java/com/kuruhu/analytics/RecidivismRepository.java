package com.kuruhu.analytics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecidivismRepository extends JpaRepository<RecidivismPrediction, Long> {
    List<RecidivismPrediction> findAll();
}
