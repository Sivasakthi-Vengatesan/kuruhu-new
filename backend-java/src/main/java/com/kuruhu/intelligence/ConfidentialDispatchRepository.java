package com.kuruhu.intelligence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConfidentialDispatchRepository extends JpaRepository<ConfidentialDispatch, Long> {
    List<ConfidentialDispatch> findAll();
}
