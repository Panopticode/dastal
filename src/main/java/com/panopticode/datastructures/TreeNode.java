package com.panopticode.datastructures;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int val() {
        return val;
    }

    public TreeNode left() {
        return left;
    }

    public TreeNode right() {
        return right;
    }

    @Override
    public String toString() {
        if (this.val == 0 && this.left == null && this.right == null) {
            return "";
        }

        var result = new StringBuilder();
        var queue = new LinkedList<TreeNode>();
        queue.add(this);

        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (node == null) {
                result.append("null");
            }
            else {
                result.append(node.val);
                if (node.left != null || node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (!queue.isEmpty()) {
                result.append(", ");
            }
        }

        return result.toString();
    }

    /**
     * e.g. [10,5,-3,3,2,null,11,3,-2,null,1]
     */
    public static TreeNode of(final Integer ... bfs) {
        if (bfs == null || bfs.length == 0) {
            return null;
        }

        var root = new TreeNode(bfs[0]);
        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        for (int i = 1; i < bfs.length; ++i) {
            var node = queue.poll();

            if (node == null) {
                continue;
            }

            if (bfs[i] != null) {
                node.left = new TreeNode(bfs[i]);
                queue.add(node.left);
            }
            ++i;
            if (i < bfs.length && bfs[i] != null) {
                node.right = new TreeNode(bfs[i]);
                queue.add(node.right);
            }
        }

        return root;
    }
}
