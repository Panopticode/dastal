package com.panopticode.problems.leetcode;

import com.panopticode.datastructures.ListNode;

/**
 * You are given the heads of two sorted linked lists, list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            if (list1 == null) {
                return list2;
            }
            else {
                return list1;
            }
        }

        var head = new ListNode(Math.min(list1.val, list2.val));
        var iter = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                iter.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                iter.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            iter = iter.next;
        }

        while (list1 != null) {
            var node = new ListNode(list1.val);
            iter.next = node;
            iter = node;
            list1 = list1.next;
        }

        while (list2 != null) {
            var node = new ListNode(list2.val);
            iter.next = node;
            iter = node;
            list2 = list2.next;
        }

        return head.next;
    }
}