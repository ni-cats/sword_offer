package com.minjie.offer.practice;

import javax.xml.soap.Detail;
import javax.xml.soap.Node;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题23：两个链表的第一个重合节点
 * @Version: 1.0
 */

public class interview_question_23 {
    public static void main(String[] args) {

        interview_question_23 testObject = new interview_question_23();
        int[] testData = new int[]{0, 1, 0};
        ListNode head1 = new ListNode(520);
        ListNode head2 = new ListNode(520);
        System.out.println(testObject.getIntersectionNode(head1, head2));

    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int count1 = countList(headA);
        int count2 = countList(headB);
        int delta = Math.abs(count2 - count1);
        ListNode longer = count1 > count2 ? headA : headB;
        ListNode shorter = count1 > count2 ? headB : headA;
        ListNode node = longer;
        for (int i = 0; i < delta; i++) {
            node = node.next;
        }
        while (node != shorter){
            node= node.next;
            shorter = shorter.next;
        }
        return node;
    }

    private int countList(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }


}