package com.panopticode.utils;

public final class Printer {
    private Printer() {
        throw new UnsupportedOperationException("Cannot instantiate utility class");
    }

    public static void printTable(boolean[][] table, boolean justifyRight) {
        printTable(table, justifyRight, null, null);
    }

    public static void printTable(boolean[][] table, boolean justifyRight, String[] headers, String[] rowHeaders) {
        var objTable = new String[table.length][table[0].length];

        for (var row = 0; row < table.length; ++row) {
            boolean[] r = table[row];
            for (var col = 0; col < r.length; ++col) {
                objTable[row][col] = r[col] ? "1" : "0";
            }
        }

        printTable(objTable, justifyRight, headers, rowHeaders);
    }

    public static void printTable(int[][] table, boolean justifyRight) {
        printTable(table, justifyRight, null, null);
    }

    public static void printTable(int[][] table, boolean justifyRight, String[] headers, String[] rowHeaders) {
        var objTable = new String[table.length][table[0].length];

        for (var row = 0; row < table.length; ++row) {
            int[] r = table[row];
            for (var col = 0; col < r.length; ++col) {
                objTable[row][col] = String.format("%d", r[col]);
            }
        }

        printTable(objTable, justifyRight, headers, rowHeaders);
    }

    public static <T> void printTable(T[][] table, boolean justifyRight) {
        printTable(table, justifyRight, null, null);
    }

    public static <T> void printTable(T[][] table, boolean justifyRight, String[] headers, String[] rowHeaders) {
        if (table.length == 0 || table[0].length == 0) {
            System.out.println("<Empty table>");
            return;
        }

        int[] columnWidths = new int[table[0].length];
        for (var i = 0; i < table[0].length; ++i) {
            for (Object[] row : table) {
                if (row[i] != null) {
                    columnWidths[i] = Math.max(columnWidths[i], row[i].toString().length());
                }
            }
        }

        if (headers != null) {
            for (var i = 0; i < headers.length; ++i) {
                columnWidths[i] = Math.max(columnWidths[i], headers[i].length());
            }
        }

        int rowHeaderWidth = 0;
        if (rowHeaders != null) {
            for (var rowHeader : rowHeaders) {
                if (rowHeader != null) {
                    rowHeaderWidth = Math.max(rowHeaderWidth, rowHeader.length());
                }
            }
        }

        var horizontalLine = new StringBuilder("+");
        if (rowHeaders != null) {
            horizontalLine.append("-".repeat(rowHeaderWidth + 2)).append("+");
        }
        for (int width : columnWidths) {
            horizontalLine.append("-".repeat(width + 2)).append("+");
        }

        if (headers != null) {
            System.out.println(horizontalLine);
            if (rowHeaders != null) {
                System.out.printf("| %" + rowHeaderWidth + "s |", "");
            }
            for (var i = 0; i < headers.length; ++i) {
                if (justifyRight) {
                    System.out.printf(" %" + columnWidths[i] + "s |", headers[i]);
                } else {
                    System.out.printf(" %-"+ columnWidths[i] + "s |", headers[i]);
                }
            }
            System.out.println();
        }

        for (var row = 0; row < table.length; ++row) {
            System.out.println(horizontalLine);
            if (rowHeaders != null) {
                String rowHeader = rowHeaders[row] != null ? rowHeaders[row] : "<null>";
                System.out.printf("| %" + rowHeaderWidth + "s |", rowHeader);
            }
            else {
                System.out.print("|");
            }
            var r = table[row];
            for (var col = 0; col < r.length; ++col) {
                var value = r[col] != null ? r[col].toString() : "<null>";
                if (justifyRight) {
                    System.out.printf(" %" + columnWidths[col] + "s |", value);
                } else {
                    System.out.printf(" %-"+ columnWidths[col] + "s |", value);
                }
            }
            System.out.println();
        }
        System.out.println(horizontalLine);
    }
}
