package com.kuruhu.model;

import java.io.Serializable;

public class FilterPredicate implements Serializable {
    private String field;
    private String operator;
    private Object value;

    public FilterPredicate() {}

    public FilterPredicate(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    public String getField() { return field; }
    public void setField(String field) { this.field = field; }

    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }

    public Object getValue() { return value; }
    public void setValue(Object value) { this.value = value; }
}
