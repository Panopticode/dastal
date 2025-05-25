package com.panopticode.problems.leetcode;

import com.panopticode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSum3 {
/**
 * Given the 'root' of a binary tree and an integer 'targetSum', return the number of paths where the sum of the values along the path equals 'targetSum'.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., travelling only from parent nodes to child nodes).
 *
 * Example 1:
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */
    public int pathSum(TreeNode root, int targetSum) {
        return dfs(root, new ArrayList<>(), targetSum);
    }

    private int dfs(TreeNode node, List<Long> partialSum, int target) {
        if (node == null) {
            return 0;
        }

        // visit node
        var count = 0;
        if (partialSum.isEmpty()) {
            partialSum.add((long) node.val());
        }
        else {
            partialSum.add(partialSum.getLast() + node.val());
        }

        var last = partialSum.getLast();
        if (last == target) {
            ++count;
        }
        for (var i = 0; i < partialSum.size() - 1; ++i) {
            if (last - partialSum.get(i) == target) {
                ++count;
            }
        }

        var total =  count +
                dfs(node.left(), partialSum, target) +
                dfs(node.right(), partialSum, target);

        partialSum.removeLast();
        return total;
    }

    public int pathSum2(TreeNode root, int targetSum) {
        var partialSum = new HashMap<Long, Integer>();
        partialSum.put(0L, 1);

        return dfs2(root, partialSum, targetSum, 0L);
    }

    private int dfs2(TreeNode node, Map<Long, Integer> partialSum, int target, long currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum += node.val();
        var count = partialSum.getOrDefault(currentSum - target, 0);

        partialSum.put(currentSum, partialSum.getOrDefault(currentSum, 0) + 1);
        var total = count +
                dfs2(node.left(), partialSum, target, currentSum) +
                dfs2(node.right(), partialSum, target, currentSum);
        partialSum.put(currentSum, partialSum.get(currentSum) - 1);
        return total;
    }
}