package com.minjie.offer.practice;


import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;

import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题46：二叉树的右侧视图
 * @Version: 1.0
 */

public class interview_question_46 {
    public static void main(String[] args) {

        interview_question_46 testObject = new interview_question_46();
        int[] testData = new int[]{0, 1, 0};
        ListNode head1 = new ListNode(520);
        ListNode head2 = new ListNode(520);
        String s1 = "anagram";
        String s2 = "nagaram";
        String[] strs1 = {"jiangminjie", "zhenghaiqing", "fengminjiongjun"};
        String[] strs = {"4", "13", "5", "/", "+"};
        int[] testInt = {3, 2, 5, 4, 6, 1, 4, 2};
        char[][] charsTest = new char[1][];
        List<String> stringList = new ArrayList<>(Arrays.asList("00:00", "23:50"));
        TreeNode root = new TreeNode(0);
        System.out.println(testObject.rightSideView(root));

    }

    private List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> view = new LinkedList<>();
        if (root == null) {
            return view;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()) {
                view.offer(node.val);
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return view;
    }


}
