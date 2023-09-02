package com.minjie.offer.practice;


import java.util.Stack;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题52：展平二叉搜索树
 * @Version: 1.0
 */

public class interview_question_52 {
    public static void main(String[] args) {

        interview_question_52 testObject = new interview_question_52();
        TreeNode root = new TreeNode(0);
        System.out.println(testObject.increasingBST(root));

    }

    private TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }

            cur = stack.pop();
            if (prev != null) {
                prev.right = cur;
            } else {
                first = cur;
            }
            prev = cur;
            cur.left = null;
            cur = cur.right;
        }
        return first;
    }


}
