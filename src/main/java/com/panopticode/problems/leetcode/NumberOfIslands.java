package com.panopticode.problems.leetcode;

import com.panopticode.datastructures.DisjointSet;

/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume water surrounds all four edges of the grid.
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    private int m;

    public int numIslandsWithDisjointSets(char[][] grid)
    {
        m = grid[0].length;
        var n = grid.length;

        var uf = new DisjointSet(m * n);

        for (var i = 0; i < n; ++i)
        {
            for (var j = 0; j < m; ++j)
            {
                if (grid[i][j] == '1')
                {
                    uf.add(toIndex(i, j));
                    if (i + 1 < n && grid[i + 1][j] == '1')
                    {
                        uf.add(toIndex(i + 1, j));
                        uf.union(toIndex(i, j), toIndex(i + 1, j));
                    }
                    if (j + 1 < m && grid[i][j + 1] == '1')
                    {
                        uf.add(toIndex(i, j + 1));
                        uf.union(toIndex(i, j), toIndex(i, j + 1));
                    }
                }
            }
        }

        return uf.components();
    }

    private int toIndex(int x, int y)
    {
        return x * m + y;
    }

    public int numIslandsWithRecursiveDfs(char[][] grid)
    {
        var islands = 0;

        for (var i = 0; i < grid.length; ++i)
        {
            for (var j = 0; j < grid[0].length; ++j)
            {
                if (grid[i][j] == '1')
                {
                    islands++;
                    dfs(grid, i, j, Direction.W);
                }
            }
        }
        return islands;
    }

    private static void dfs(char[][] grid, int i, int j, Direction from) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // mark visited
        grid[i][j] = '0';
        // recursive visits, but don't re-visit where you're coming from
        if (from != Direction.W) {
            dfs(grid, i - 1, j, Direction.E);
        }
        if (from != Direction.E) {
            dfs(grid, i + 1, j, Direction.W);
        }
        if (from != Direction.N) {
            dfs(grid, i, j - 1, Direction.S);
        }
        if (from != Direction.S) {
            dfs(grid, i, j + 1, Direction.N);
        }
    }
}

enum Direction {
    N,
    S,
    E,
    W
}
