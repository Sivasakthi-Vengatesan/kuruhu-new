package com.kuruhu.model;

import java.io.Serializable;

public class QueryMetadata implements Serializable {
    private String queryId;
    private String source;
    private long executionTimeMs;
    private int recordsScanned;

    public QueryMetadata() {}

    public QueryMetadata(String queryId, String source, long executionTimeMs, int recordsScanned) {
        this.queryId = queryId;
        this.source = source;
        this.executionTimeMs = executionTimeMs;
        this.recordsScanned = recordsScanned;
    }

    public String getQueryId() { return queryId; }
    public void setQueryId(String queryId) { this.queryId = queryId; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public long getExecutionTimeMs() { return executionTimeMs; }
    public void setExecutionTimeMs(long executionTimeMs) { this.executionTimeMs = executionTimeMs; }

    public int getRecordsScanned() { return recordsScanned; }
    public void setRecordsScanned(int recordsScanned) { this.recordsScanned = recordsScanned; }
}
