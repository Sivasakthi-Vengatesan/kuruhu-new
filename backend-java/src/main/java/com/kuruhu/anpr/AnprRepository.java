package com.kuruhu.anpr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnprRepository extends JpaRepository<AnprCapture, Long> {
    List<AnprCapture> findAll();
}
