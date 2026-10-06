package com.pramaan.repository;

import com.pramaan.entity.CrimeHotspot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrimeHotspotRepository extends JpaRepository<CrimeHotspot, Long> {
    List<CrimeHotspot> findByDistrictIgnoreCase(String district);
    List<CrimeHotspot> findAllByOrderByCrimeCountDesc();
}