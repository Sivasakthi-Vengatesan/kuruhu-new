package com.kuruhu.repository;

import com.kuruhu.entity.DocumentEmbedding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentEmbeddingRepository extends JpaRepository<DocumentEmbedding, Long>, JpaSpecificationExecutor<DocumentEmbedding> {
}
