package com.panopticode.utils;

import org.testng.annotations.Test;

public class PrinterTest {
    @Test
    public void printTableObjects() {
        var table = generateRandomStringTable(5, 3);

        Printer.printTable(table, false);
    }

    @Test
    public void printTableBooleanTypes() {
        var table = generateRandomBooleanTable(5, 3);

        Printer.printTable(table, false);
    }

    @Test
    public void printTableBooleanTypesWithHeaders() {
        var table = generateRandomBooleanTable(5, 3);
        var headers = new String[]{
                "A", "B", "C"
        };
        var rowHeaders = new String[]{
                "1", "2", "3", "4", "5"
        };

        Printer.printTable(table, false, headers, rowHeaders);
    }

    @Test
    public void printTableIntTypes() {
        var table = generateRandomIntTable(5, 3);

        Printer.printTable(table, false);
    }

    @Test
    public void printTableIntTypesWithHeaders() {
        var table = generateRandomIntTable(5, 3);
        var headers = new String[]{
                "A", "B", "C"
        };
        var rowHeaders = new String[]{
                "1", "2", "3", "4", "5"
        };

        Printer.printTable(table, false, headers, rowHeaders);
    }

    @Test
    public void printTableWithHeaders() {
        var table = generateRandomStringTable(5, 3);
        var headers = new String[]{
                "A", "B", "C"
        };
        var rowHeaders = new String[]{
                "1", "2", "3", "4", "5"
        };

        Printer.printTable(table, false, headers, rowHeaders);
    }

    @Test
    public void printTableWithHeadersVariableLengths() {
        var table = new String[][]{
                {generateRandomString(3), generateRandomString(2), generateRandomString(1)},
                {generateRandomString(4), generateRandomString(2), generateRandomString(6)},
                {generateRandomString(5), generateRandomString(3), generateRandomString(8)},
                {generateRandomString(1), generateRandomString(2), generateRandomString(5)},
                {generateRandomString(2), generateRandomString(3), generateRandomString(4)},
        };
        var headers = new String[]{
                "A", "B", "C"
        };
        var rowHeaders = new String[]{
                "1", "2", "3", "4", "5"
        };

        Printer.printTable(table, false, headers, rowHeaders);
    }

    private static String[][] generateRandomStringTable(int rows, int cols) {
        String[][] table = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                table[i][j] = generateRandomString(5);
            }
        }
        return table;
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomChar = (int) (Math.random() * 26) + 'a';
            sb.append((char) randomChar);
        }
        return sb.toString();
    }

    private static boolean[][] generateRandomBooleanTable(int rows, int cols) {
        boolean[][] table = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                table[i][j] = Math.random() < 0.5;
            }
        }
        return table;
    }

    private static int[][] generateRandomIntTable(int rows, int cols) {
        int[][] table = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                table[i][j] = (int) (Math.random() * 100);
            }
        }

        return table;
    }
}
