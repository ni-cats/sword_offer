package com.minjie.offer.practice;

import java.util.HashMap;
import java.util.Map;


/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题31：最近最少使用缓存
 * @Version: 1.0
 */

public class interview_question_31 {
    public static void main(String[] args) {

        interview_question_31 testObject = new interview_question_31();
        System.out.println("江敏婕！");
    }
}

class ListedNode {
    public int key;
    public int value;
    public ListedNode prev;
    public ListedNode next;

    public ListedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private ListedNode head;
    private ListedNode tail;
    private Map<Integer, ListedNode> map;
    public int capacity;

    public LRUCache(int capacity) {
        head = new ListedNode(-1, -1);
        tail = new ListedNode(-1, -1);
        map = new HashMap<>();
        this.capacity = capacity;
    }

    //TODO 查询节点
    public int get(int key) {
        ListedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToTail(node, node.value);
        return node.value;
    }

    // TODO 修改 添加节点
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            moveToTail(map.get(key), value);
        } else {
            //容量达到上限
            if (map.size() == capacity) {
                ListedNode toBeDeleted = head.next;
                deleteNode(toBeDeleted);
                map.remove(toBeDeleted.key);
            }

            ListedNode node = new ListedNode(key, value);
            insertToTail(node);
            map.put(key, node);
        }
    }

    private void insertToTail(ListedNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private void deleteNode(ListedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //TODO 移动节点到最后
    private void moveToTail(ListedNode node, int newValue) {
        deleteNode(node);
        node.value = newValue;
        insertToTail(node);

    }
}