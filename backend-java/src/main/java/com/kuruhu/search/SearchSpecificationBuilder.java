package com.kuruhu.search;

import org.springframework.stereotype.Component;

@Component
public class SearchSpecificationBuilder {
    public String buildSqlLike(String term) { return "%" + (term != null ? term.trim() : "") + "%"; }
}
