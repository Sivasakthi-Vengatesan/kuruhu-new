package com.kuruhu.telematics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleGpsRepository extends JpaRepository<VehicleGpsPing, Long> {
    List<VehicleGpsPing> findAll();
}
