package com.kuruhu.repository;

import com.kuruhu.entity.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliceStationRepository extends JpaRepository<PoliceStation, Long>, JpaSpecificationExecutor<PoliceStation> {
}
