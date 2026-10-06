package com.kuruhu.threat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrganizedCrimeRepository extends JpaRepository<OrganizedCrimeGroup, Long> {
    List<OrganizedCrimeGroup> findAll();
}
