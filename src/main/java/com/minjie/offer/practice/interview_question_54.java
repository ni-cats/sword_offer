package com.minjie.offer.practice;


import com.oracle.net.Sdp;

import java.util.Stack;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题54：所有大于或等于节点的值之和
 * @Version: 1.0
 */

public class interview_question_54 {
    public static void main(String[] args) {

        interview_question_54 testObject = new interview_question_54();
        TreeNode root = new TreeNode(0);
        System.out.println(testObject.convertBST(root));

    }

    private TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }

            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }


}
