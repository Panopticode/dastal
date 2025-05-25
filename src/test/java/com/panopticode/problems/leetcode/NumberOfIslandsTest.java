package com.panopticode.problems.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class NumberOfIslandsTest
{
    @Test
    public void islandsReturnsZeroWhenGridIsAllWater() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'0', '0'},
            {'0', '0'}
        };
        assertEquals(solution.numIslandsWithDisjointSets(grid), 0);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 0);
    }

    @Test
    public void islandsReturnsOneForSingleIsland() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'1', '1'},
            {'1', '1'}
        };
        assertEquals(solution.numIslandsWithDisjointSets(grid), 1);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 1);
    }

    @Test
    public void islandsReturnsCorrectCountForMultipleIslands() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(solution.numIslandsWithDisjointSets(grid), 3);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 3);
    }

    @Test
    public void islandsHandlesSingleCellGridLand() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'1'}
        };
        assertEquals(solution.numIslandsWithDisjointSets(grid), 1);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 1);
    }

    @Test
    public void islandsHandlesSingleCellGridWater() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
            {'0'}
        };
        assertEquals(solution.numIslandsWithDisjointSets(grid), 0);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 0);
    }

    @Test
    public void islandsHandlesOneRowGridWithMultipleIslands() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
                {'1', '0', '1', '0', '1'}
        };
        assertEquals(solution.numIslandsWithDisjointSets(grid), 3);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 3);
    }

    @Test
    public void islandsHandlesOneColumnGridWithMultipleIslands() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
                {'1'},
                {'0'},
                {'1'},
                {'0'},
                {'1'}
        };
        assertEquals(solution.numIslandsWithDisjointSets(grid), 3);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 3);
    }

    @Test
    public void islandsDoesNotConnectDiagonalLands() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
                {'1', '0'},
                {'0', '1'}
        };
        assertEquals(solution.numIslandsWithDisjointSets(grid), 2);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 2);
    }

    @Test
    public void islandsHandlesLargeGridWithSingleIsland() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = new char[100][100];
        for (int i = 0; i < 100; i++) {
            Arrays.fill(grid[i], '1');
        }
        assertEquals(solution.numIslandsWithDisjointSets(grid), 1);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 1);
    }

    @Test
    public void islandsHandlesLargeGridWithNoIslands() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = new char[100][100];
        for (int i = 0; i < 100; i++) {
            Arrays.fill(grid[i], '0');
        }
        assertEquals(solution.numIslandsWithDisjointSets(grid), 0);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 0);
    }

    @Test
    public void islandsHandlesLargeGridWithMultipleIslands() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                grid[i][j] = (i % 2 == 0 && j % 2 == 0) ? '1' : '0';
            }
        }
        assertEquals(solution.numIslandsWithDisjointSets(grid), 2500);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 2500);
    }

    @Test
    public void islandWithBridge() {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        assertEquals(solution.numIslandsWithDisjointSets(grid), 1);
        assertEquals(solution.numIslandsWithRecursiveDfs(grid), 1);
    }
}
