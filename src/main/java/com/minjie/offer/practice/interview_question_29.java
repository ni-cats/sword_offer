package com.minjie.offer.practice;

import java.beans.beancontext.BeanContext;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题29：排序的循环链表
 * @Version: 1.0
 */

public class interview_question_29 {
    public static void main(String[] args) {

        interview_question_29 testObject = new interview_question_29();
        int[] testData = new int[]{0, 1, 0};
        ListNode head1 = new ListNode(520);
        ListNode head2 = new ListNode(520);
        testObject.insert(head1, 20);

    }


    public ListNode insert(ListNode head, int insertVal) {
        ListNode node = new ListNode(insertVal);
        if (head == null) {
            head = node;
            head.next=head;
        } else if (head.next == head) {
            head.next = node;
            node.next = head;
        } else {
            insertCore(head, node);
        }
        return head;

    }

    private void insertCore(ListNode head, ListNode node) {
        ListNode cur = head;
        ListNode next = head.next;
        ListNode biggestNode = head;
        while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
            cur = next;
            next = next.next;
            if (cur.val >= biggestNode.val) {
                biggestNode = cur;
            }
        }
        if (cur.val <= node.val && next.val >= node.val) {
            node.next = cur.next;
            cur.next = node;
        } else {
            node.next = biggestNode.next;
            biggestNode.next = node;
        }
    }
}


