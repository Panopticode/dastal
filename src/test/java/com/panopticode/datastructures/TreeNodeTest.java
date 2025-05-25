package com.panopticode.datastructures;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TreeNodeTest {

    @Test
    public void testOf() {
        var tree = TreeNode.of(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);

        assertEquals(tree.toString(), "10, 5, -3, 3, 2, null, 11, 3, -2, null, 1");
    }
}