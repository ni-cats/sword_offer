package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.practice
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-31  10:49
 * @Description: TODO 单向链表基础功能测试
 * @Version: 1.0
 */


// TODO 链表节点定义
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int value) {
        this.val = val;
    }

    // TODO 插入操作
    public ListNode append(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            return newNode;
        }
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return head;
    }

    // TODO 用哨兵节点简化插入操作
    public ListNode append1(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newNode = new ListNode(value);
        ListNode node = dummy;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return dummy.next;
    }

    //TODO 链表删除操作
    public ListNode delete(ListNode head, int value) {
        if (head == null){
            return head;
        }
        if (head.val == value){
            return head.next;
        }
        ListNode node = head;
        while (node.next != null){
            if(node.next.val==value){
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }
    //TODO 利用头结点简化链表删除操作
    public ListNode delete1(ListNode head,int value){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null){
            if (node.next.val == value){
                node.next= node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }


}

