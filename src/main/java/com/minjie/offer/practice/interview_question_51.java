package com.minjie.offer.practice;


import com.sun.org.glassfish.external.amx.AMX;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题51：节点值之和最大路径
 * @Version: 1.0
 */

public class interview_question_51 {
    public static void main(String[] args) {

        interview_question_51 testObject = new interview_question_51();
        TreeNode root = new TreeNode(0);
        System.out.println(testObject.maxPathSum(root));

    }

    private int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }

    private int dfs(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int[] maxSumLeft = {Integer.MIN_VALUE};
        int left = dfs(root.left, maxSumLeft);
        int[] maxSumRight = {Integer.MIN_VALUE};
        int right = dfs(root.right, maxSumRight);

        maxSum[0] = Math.max(maxSumLeft[0], maxSumRight[0]);
        maxSum[0] = Math.max(maxSum[0], root.val + left + right);

        return root.val + Math.max(right, left);


    }

}
