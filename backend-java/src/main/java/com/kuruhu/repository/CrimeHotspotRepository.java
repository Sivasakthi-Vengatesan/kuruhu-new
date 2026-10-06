package com.kuruhu.repository;

import com.kuruhu.entity.CrimeHotspot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CrimeHotspotRepository extends JpaRepository<CrimeHotspot, Long>, JpaSpecificationExecutor<CrimeHotspot> {
}
