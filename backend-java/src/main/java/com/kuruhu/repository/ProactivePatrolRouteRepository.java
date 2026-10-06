package com.kuruhu.repository;

import com.kuruhu.entity.ProactivePatrolRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProactivePatrolRouteRepository extends JpaRepository<ProactivePatrolRoute, Long>, JpaSpecificationExecutor<ProactivePatrolRoute> {
}
