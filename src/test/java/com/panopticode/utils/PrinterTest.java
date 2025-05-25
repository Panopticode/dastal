package com.panopticode.utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

public class PrinterTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeMethod
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterMethod
    public void tearDown() {
        System.setOut(standardOut);
        outputStreamCaptor.reset();
    }

    @Test
    public void printTableObjects() {
        var table = generateLoremStringTable(5, 3);

        Printer.printTable(table, false);

        assertEquals(outputStreamCaptor.toString().trim(), Result.STR_SMELGT_TBL);
    }

    @Test
    public void printTableBooleanTypes() {
        var table = generateRandomBooleanTable();

        Printer.printTable(table, false);

        assertEquals(outputStreamCaptor.toString().trim(), Result.BOL_TBL);
    }

    @Test
    public void printTableBooleanTypesWithHeaders() {
        var table = generateRandomBooleanTable();
        var headers = new String[]{
                "A", "B", "C"
        };
        var rowHeaders = new String[]{
                "1", "2", "3", "4", "5"
        };

        Printer.printTable(table, false, headers, rowHeaders);

        assertEquals(outputStreamCaptor.toString().trim(), Result.BOL_HDR_TBL);
    }

    @Test
    public void printTableIntTypes() {
        var table = generateIntTable();

        Printer.printTable(table, false);

        assertEquals(outputStreamCaptor.toString().trim(), Result.INT_TBL);
    }

    @Test
    public void printTableIntTypesWithHeaders() {
        var table = generateIntTable();
        var headers = new String[]{
                "A", "B", "C"
        };
        var rowHeaders = new String[]{
                "1", "2", "3", "4", "5"
        };

        Printer.printTable(table, false, headers, rowHeaders);

        assertEquals(outputStreamCaptor.toString().trim(), Result.INT_HDR_TBL);
    }

    @Test
    public void printTableWithHeaders() {
        var table = generateLoremStringTable(6, 4);
        var headers = new String[]{
                "A", "B", "C", "D"
        };
        var rowHeaders = new String[]{
                "1", "2", "3", "4", "5", "6"
        };

        Printer.printTable(table, false, headers, rowHeaders);

        assertEquals(outputStreamCaptor.toString().trim(), Result.STR_HDR_TBL);
    }

    @Test
    public void printTableWithHeadersVariableLengths() {
        var table = new String[][]{
                {generateLoremString(3), generateLoremString(2), generateLoremString(1)},
                {generateLoremString(4), generateLoremString(2), generateLoremString(6)},
                {generateLoremString(5), generateLoremString(3), generateLoremString(8)},
                {generateLoremString(1), generateLoremString(2), generateLoremString(5)},
                {generateLoremString(2), generateLoremString(3), generateLoremString(4)},
        };
        var headers = new String[]{
                "A", "B", "C"
        };
        var rowHeaders = new String[]{
                "1", "2", "3", "4", "5"
        };

        Printer.printTable(table, false, headers, rowHeaders);

        assertEquals(outputStreamCaptor.toString().trim(), Result.STR_VARLGT_TBL);
    }

    private static String[][] generateLoremStringTable(int rows, int cols) {
        String[][] table = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                table[i][j] = generateLoremString(5);
            }
        }
        return table;
    }

    private static String generateLoremString(int length) {
        return "LoremIpsumDolorSitAmet".substring(0, length);
    }

    private static boolean[][] generateRandomBooleanTable() {
        return new boolean[][]{
                {true,  true,  true},
                {false, true,  false},
                {false, true,  true},
                {true,  false, true},
                {true,  true,  false},
        };
    }

    private static int[][] generateIntTable() {
        return new int[][]{
            {27, 31, 66},
            {44, 2,  25},
            {55, 38, 90},
            {7,  25, 3},
            {4,  35, 61}
        };
    }

    private static class Result {
        public static final String STR_VARLGT_TBL =
                """
                        +---+-------+-----+----------+
                        |   | A     | B   | C        |
                        +---+-------+-----+----------+
                        | 1 | Lor   | Lo  | L        |
                        +---+-------+-----+----------+
                        | 2 | Lore  | Lo  | LoremI   |
                        +---+-------+-----+----------+
                        | 3 | Lorem | Lor | LoremIps |
                        +---+-------+-----+----------+
                        | 4 | L     | Lo  | Lorem    |
                        +---+-------+-----+----------+
                        | 5 | Lo    | Lor | Lore     |
                        +---+-------+-----+----------+""";
        public static final String STR_SMELGT_TBL =
                """
                        +-------+-------+-------+
                        | Lorem | Lorem | Lorem |
                        +-------+-------+-------+
                        | Lorem | Lorem | Lorem |
                        +-------+-------+-------+
                        | Lorem | Lorem | Lorem |
                        +-------+-------+-------+
                        | Lorem | Lorem | Lorem |
                        +-------+-------+-------+
                        | Lorem | Lorem | Lorem |
                        +-------+-------+-------+""";
        public static final String STR_HDR_TBL =
                """
                        +---+-------+-------+-------+-------+
                        |   | A     | B     | C     | D     |
                        +---+-------+-------+-------+-------+
                        | 1 | Lorem | Lorem | Lorem | Lorem |
                        +---+-------+-------+-------+-------+
                        | 2 | Lorem | Lorem | Lorem | Lorem |
                        +---+-------+-------+-------+-------+
                        | 3 | Lorem | Lorem | Lorem | Lorem |
                        +---+-------+-------+-------+-------+
                        | 4 | Lorem | Lorem | Lorem | Lorem |
                        +---+-------+-------+-------+-------+
                        | 5 | Lorem | Lorem | Lorem | Lorem |
                        +---+-------+-------+-------+-------+
                        | 6 | Lorem | Lorem | Lorem | Lorem |
                        +---+-------+-------+-------+-------+""";
        public static final String INT_TBL =
                """
                        +----+----+----+
                        | 27 | 31 | 66 |
                        +----+----+----+
                        | 44 | 2  | 25 |
                        +----+----+----+
                        | 55 | 38 | 90 |
                        +----+----+----+
                        | 7  | 25 | 3  |
                        +----+----+----+
                        | 4  | 35 | 61 |
                        +----+----+----+""";
        public static final String INT_HDR_TBL =
                """
                        +---+----+----+----+
                        |   | A  | B  | C  |
                        +---+----+----+----+
                        | 1 | 27 | 31 | 66 |
                        +---+----+----+----+
                        | 2 | 44 | 2  | 25 |
                        +---+----+----+----+
                        | 3 | 55 | 38 | 90 |
                        +---+----+----+----+
                        | 4 | 7  | 25 | 3  |
                        +---+----+----+----+
                        | 5 | 4  | 35 | 61 |
                        +---+----+----+----+""";
        public static final String BOL_TBL =
                """
                        +---+---+---+
                        | 1 | 1 | 1 |
                        +---+---+---+
                        | 0 | 1 | 0 |
                        +---+---+---+
                        | 0 | 1 | 1 |
                        +---+---+---+
                        | 1 | 0 | 1 |
                        +---+---+---+
                        | 1 | 1 | 0 |
                        +---+---+---+""";
        public static final String BOL_HDR_TBL =
                """
                        +---+---+---+---+
                        |   | A | B | C |
                        +---+---+---+---+
                        | 1 | 1 | 1 | 1 |
                        +---+---+---+---+
                        | 2 | 0 | 1 | 0 |
                        +---+---+---+---+
                        | 3 | 0 | 1 | 1 |
                        +---+---+---+---+
                        | 4 | 1 | 0 | 1 |
                        +---+---+---+---+
                        | 5 | 1 | 1 | 0 |
                        +---+---+---+---+""";
    }
}
