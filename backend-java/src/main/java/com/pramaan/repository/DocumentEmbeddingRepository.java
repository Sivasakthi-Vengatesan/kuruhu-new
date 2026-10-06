package com.pramaan.repository;

import com.pramaan.entity.DocumentEmbedding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentEmbeddingRepository extends JpaRepository<DocumentEmbedding, Long> {

    List<DocumentEmbedding> findByDocumentType(String documentType);

    @Query(value = "SELECT * FROM document_embeddings ORDER BY embedding <=> CAST(:vector AS vector) LIMIT :limit", nativeQuery = true)
    List<DocumentEmbedding> findSimilarByVector(@Param("vector") String vector, @Param("limit") int limit);

    @Query("SELECT d FROM DocumentEmbedding d WHERE " +
           "LOWER(d.title) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(d.content) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<DocumentEmbedding> searchByTextFallback(@Param("query") String query);
}