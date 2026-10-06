package com.pramaan.repository;

import com.pramaan.entity.LocationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRecordRepository extends JpaRepository<LocationRecord, Long> {
    Optional<LocationRecord> findByLocationCode(String locationCode);
    List<LocationRecord> findByDistrictIgnoreCase(String district);

    @Query("SELECT l FROM LocationRecord l WHERE " +
           "LOWER(l.name) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(l.area) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(l.district) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<LocationRecord> searchLocations(@Param("query") String query);
}