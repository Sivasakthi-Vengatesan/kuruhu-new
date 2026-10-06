package com.pramaan.repository;

import com.pramaan.entity.Fir;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FirRepository extends JpaRepository<Fir, Long>, JpaSpecificationExecutor<Fir> {

    Optional<Fir> findByFirNumber(String firNumber);

    List<Fir> findByStatusNotIgnoreCase(String status);

    List<Fir> findByStatusIgnoreCase(String status);

    List<Fir> findByDistrictIgnoreCase(String district);

    List<Fir> findByStationNameIgnoreCase(String stationName);

    long countByStatus(String status);

    long countByStatusNot(String status);

    long countByPriorityInAndStatusNot(List<String> priorities, String status);

    @Query("SELECT f FROM Fir f WHERE " +
           "LOWER(f.firNumber) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(f.title) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(f.summary) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(f.stationName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(f.district) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(f.investigatingOfficer) LIKE LOWER(CONCAT('%', :query, '%'))")
    Page<Fir> searchFirs(@Param("query") String query, Pageable pageable);

    @Query("SELECT f FROM Fir f WHERE " +
           "(:query IS NULL OR :query = '' OR " +
           " LOWER(f.firNumber) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(f.title) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(f.summary) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(f.stationName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(f.investigatingOfficer) LIKE LOWER(CONCAT('%', :query, '%'))) AND " +
           "(:status IS NULL OR :status = 'all' OR LOWER(f.status) = LOWER(:status)) AND " +
           "(:priority IS NULL OR :priority = 'all' OR LOWER(f.priority) = LOWER(:priority)) AND " +
           "(:station IS NULL OR :station = 'all' OR LOWER(f.stationName) = LOWER(:station))")
    List<Fir> filterFirs(@Param("query") String query,
                         @Param("status") String status,
                         @Param("priority") String priority,
                         @Param("station") String station);
}