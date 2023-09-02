package com.minjie.offer.practice;


import com.sun.javaws.jnl.MatcherReturnCode;

import java.nio.channels.NonReadableChannelException;
import java.util.HashSet;
import java.util.Stack;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题56：二叉搜索树中两个节点的值之和
 * @Version: 1.0
 */

public class interview_question_56 {
    public static void main(String[] args) {

        interview_question_56 testObject = new interview_question_56();
        TreeNode root = new TreeNode(0);
        System.out.println(testObject.findTarget(root, 520));

    }
    //TODO 通用方法

    private boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (set.contains(k - cur.val)) {
                return true;
            }
            set.add(cur.val);
            cur = cur.right;
        }
        return false;
    }


    //TODO 二叉搜索树特殊方法 --- 双指针

    private boolean findTarget1(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        BSTIterator iterNext = new BSTIterator(root);
        BSTIteratorReversed iterPrev = new BSTIteratorReversed(root);
        int next = iterNext.next();
        int prev = iterPrev.prev();
        while (next != prev) {
            if (prev + next == k) {
                return true;
            }
            if (prev + next < k) {
                next = iterNext.next();
            } else {
                prev = iterPrev.prev();
            }
        }
        return false;
    }
}

class BSTIteratorReversed {
    TreeNode cur;
    Stack<TreeNode> stack;

    public BSTIteratorReversed(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public boolean hasPrev() {
        return (cur != null || !stack.isEmpty());
    }

    public int prev() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.right;
        }

        cur = stack.pop();
        cur = cur.left;
        return cur.val;
    }
}
