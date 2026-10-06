package com.kuruhu.util;

public class JsonUtils {
    public static boolean isValidJson(String json) {
        return json != null && json.startsWith("{") && json.endsWith("}");
    }
}
