package com.minjie.offer.practice;


import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.PriorityQueue;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 78: 合并排序链表
 * @Version: 1.0
 */

public class interview_question_78 {
    public static void main(String[] args) {

        interview_question_78 testObject = new interview_question_78();
        int[] nums = {1, 3, 6, 8};
        ListNode[] root = {new ListNode(0)};
        testObject.mergeKLists(root);

    }

    //TODO 基于最小堆的实现
    private ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((q1, q2) -> (q1.val - q2.val));
        for (ListNode list : lists) {
            minHeap.offer(list);
        }
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return dummy.next;
    }

    //TODO 基于归并排序思路的实现
    private ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start + 1 == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode head1 = mergeLists(lists, start, mid);
        ListNode head2 = mergeLists(lists, mid, end);
        return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }


}

