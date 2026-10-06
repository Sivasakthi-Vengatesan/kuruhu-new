package com.kuruhu.surveillance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CctvStreamRepository extends JpaRepository<CctvStreamFeed, Long> {
    List<CctvStreamFeed> findAll();
}
