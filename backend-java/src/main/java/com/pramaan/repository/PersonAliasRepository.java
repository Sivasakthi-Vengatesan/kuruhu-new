package com.pramaan.repository;

import com.pramaan.entity.PersonAlias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonAliasRepository extends JpaRepository<PersonAlias, Long> {
    List<PersonAlias> findByPersonId(Long personId);
}