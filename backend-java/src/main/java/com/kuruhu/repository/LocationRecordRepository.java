package com.kuruhu.repository;

import com.kuruhu.entity.LocationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRecordRepository extends JpaRepository<LocationRecord, Long>, JpaSpecificationExecutor<LocationRecord> {
}
