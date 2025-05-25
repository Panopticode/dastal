package com.panopticode.problems.leetcode;

import com.panopticode.datastructures.TreeNode;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PathSum3Test {
    @Test
    public void testPathSum3_1() {
        PathSum3 solution = new PathSum3();
        TreeNode root = TreeNode.of(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);

        assertEquals(solution.pathSum(root, 8), 3);
        assertEquals(solution.pathSum2(root, 8), 3);
    }

    @Test
    public void testPathSum3_2() {
        PathSum3 solution = new PathSum3();
        TreeNode root = TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);

        assertEquals(solution.pathSum(root, 22), 3);
        assertEquals(solution.pathSum2(root, 22), 3);
    }

    @Test
    public void testPathSum3_3() {
        PathSum3 solution = new PathSum3();
        TreeNode root = TreeNode.of(1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null, 1000000000);

        assertEquals(solution.pathSum(root, 0), 0);
        assertEquals(solution.pathSum2(root, 0), 0);
    }
}