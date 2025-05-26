package com.panopticode.problems.leetcode;

import com.panopticode.datastructures.ListNode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;

public class MergeTwoSortedListsTest {
    private MergeTwoSortedLists solution;

    @BeforeMethod
    public void setUp() {
        solution = new MergeTwoSortedLists();
    }

    @Test
    public void testMergeEmptyLists() {
        assertNull(solution.mergeTwoLists(null, null));
    }

    @Test
    public void testMergeWithEmptyList() {
        ListNode list1 = new ListNode(1);
        assertSame(solution.mergeTwoLists(list1, null), list1);
        assertSame(solution.mergeTwoLists(null, list1), list1);
    }

    @Test
    public void testMergeEqualLengthLists() {
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode result = solution.mergeTwoLists(list1, list2);
        int[] expected = {1, 2, 3, 4, 5, 6};
        for (int value : expected) {
            assertEquals(result.val, value);
            result = result.next;
        }
        assertNull(result);
    }

    @Test
    public void testMergeDifferentLengthLists() {
        ListNode list1 = new ListNode(1, new ListNode(3));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode result = solution.mergeTwoLists(list1, list2);
        int[] expected = {1, 2, 3, 4, 6};
        for (int value : expected) {
            assertEquals(result.val, value);
            result = result.next;
        }
        assertNull(result);
    }

    @Test
    public void testMergeWithDuplicates() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = solution.mergeTwoLists(list1, list2);
        int[] expected = {1, 1, 2, 3, 4, 4};
        for (int value : expected) {
            assertEquals(result.val, value);
            result = result.next;
        }
        assertNull(result);
    }
}