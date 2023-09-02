package com.minjie.offer.practice;


import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题49：从根节点到叶节点的路径数字之和
 * @Version: 1.0
 */

public class interview_question_49 {
    public static void main(String[] args) {

        interview_question_49 testObject = new interview_question_49();
        TreeNode root = new TreeNode(0);
        System.out.println(testObject.sumNumbers(root));

    }

    private int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }
        path = path * 10 + root.val;
        if (root.left == null && root.right == null) {
            return path;
        }
        return dfs(root.left, path) + dfs(root.right, path);
    }


}
