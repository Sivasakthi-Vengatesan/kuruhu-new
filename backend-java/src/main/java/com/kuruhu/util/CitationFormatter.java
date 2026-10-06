package com.kuruhu.util;

public class CitationFormatter {
    public static String formatCitation(String type, String id, String title) {
        return "[" + type + " " + id + "] " + title;
    }
}
