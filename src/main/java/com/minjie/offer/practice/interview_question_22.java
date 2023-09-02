package com.minjie.offer.practice;

import java.awt.image.LookupOp;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题22：链表中环的入口节点
 * @Version: 1.0
 */

public class interview_question_22 {
    public static void main(String[] args) {

        interview_question_22 testObject = new interview_question_22();
        int[] testData = new int[]{0, 1, 0};
        ListNode node = new ListNode(520);
        System.out.println(testObject.detectCycle(node));

    }

    public ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }
        int loopCount = 1;
        for (ListNode n = inLoop; n.next != inLoop; n = n.next) {
            loopCount++;
        }
        ListNode fast = head;
        for (int i = 0; i < loopCount; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    //TODO 优化
    public ListNode detectCycle1(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }
       ListNode node = head;
        while (node != inLoop) {
            node=node.next;
            inLoop=inLoop.next;
        }
        return node;
    }


    private ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;

    }


}