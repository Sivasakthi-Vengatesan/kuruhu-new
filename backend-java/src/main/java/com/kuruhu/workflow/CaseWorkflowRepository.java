package com.kuruhu.workflow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CaseWorkflowRepository extends JpaRepository<CaseWorkflowInstance, Long> {
    List<CaseWorkflowInstance> findAll();
}
