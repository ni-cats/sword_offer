package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题21：删除链表倒数第k个节点
 * @Version: 1.0
 */

public class interview_question_21 {
    public static void main(String[] args) {

        interview_question_21 testObject = new interview_question_21();
        int[] testData = new int[]{0, 1, 0};
        ListNode node = new ListNode(520);
        System.out.println(testObject.removeNthFromEnd(node, 2));

    }

    private ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = head, back = dummy;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        while (front !=null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }

}