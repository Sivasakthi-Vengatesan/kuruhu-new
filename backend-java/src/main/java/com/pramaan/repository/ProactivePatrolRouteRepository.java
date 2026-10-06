package com.pramaan.repository;

import com.pramaan.entity.ProactivePatrolRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProactivePatrolRouteRepository extends JpaRepository<ProactivePatrolRoute, Long> {
    List<ProactivePatrolRoute> findByStatusIgnoreCase(String status);
}