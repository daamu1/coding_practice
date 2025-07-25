package com.damu.pattern;

public class DateFormatChecker {
    private static boolean isDateOnlyFormat(String formatString) {
        return formatString.matches("^\\d{2}[-/.]\\d{2}[-/.]\\d{4}$") // dd-MM-yyyy or dd/MM/yyyy
                || formatString.matches("^\\d{4}[-/.]\\d{2}[-/.]\\d{2}$"); // yyyy-MM-dd
    }

    public static void main(String[] args) {
        long maxAdOffsetMillis = Math.min(5 * 60 * 1000L, 300000 - 1);
        System.out.println(maxAdOffsetMillis);
    }
}
