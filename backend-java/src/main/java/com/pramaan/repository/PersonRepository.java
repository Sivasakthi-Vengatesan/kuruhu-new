package com.pramaan.repository;

import com.pramaan.entity.Person;
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
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

    Optional<Person> findByPersonCode(String personCode);

    List<Person> findByPrimaryRoleIgnoreCase(String primaryRole);

    List<Person> findByRiskLevelIgnoreCase(String riskLevel);

    @Query("SELECT p FROM Person p LEFT JOIN p.aliases a WHERE " +
           "(:query IS NULL OR :query = '' OR " +
           " LOWER(p.canonicalName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(p.phone) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(p.identifierRef) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(p.address) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           " LOWER(a.aliasName) LIKE LOWER(CONCAT('%', :query, '%'))) AND " +
           "(:role IS NULL OR :role = 'all' OR LOWER(p.primaryRole) = LOWER(:role))")
    List<Person> searchAndFilterPersons(@Param("query") String query, @Param("role") String role);

    @Query("SELECT DISTINCT p FROM Person p LEFT JOIN p.aliases a WHERE " +
           "LOWER(p.canonicalName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(p.phone) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(p.identifierRef) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(a.aliasName) LIKE LOWER(CONCAT('%', :query, '%'))")
    Page<Person> searchPersons(@Param("query") String query, Pageable pageable);
}