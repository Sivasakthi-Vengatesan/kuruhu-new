package com.pramaan.repository;

import com.pramaan.entity.AuditLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findAllByOrderByTimestampDesc();

    @Query("SELECT a FROM AuditLog a WHERE " +
           "(:query IS NULL OR :query = '' OR :query = 'all' OR " +
           " LOWER(a.actorName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(a.actorRole) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(a.action) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(a.targetDescription) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(a.detail) LIKE LOWER(CONCAT('%', :query, '%'))) AND " +
           "(:targetType IS NULL OR :targetType = '' OR :targetType = 'all' OR LOWER(a.targetType) = LOWER(:targetType)) " +
           "ORDER BY a.timestamp DESC")
    List<AuditLog> searchAuditLogs(@Param("query") String query, @Param("targetType") String targetType);

    Page<AuditLog> findAllByOrderByTimestampDesc(Pageable pageable);
}