package com.minjie.offer.practice;


import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题44：二叉树中每层的最大值
 * @Version: 1.0
 */

public class interview_question_44 {
    public static void main(String[] args) {

        interview_question_44 testObject = new interview_question_44();
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
        System.out.println(testObject.largestValues(root));

    }

    //TODO 方法一：用一个队列实现
    private List<Integer> largestValues(TreeNode root) {
        int current = 0;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            current = 1;
        }
        //保存结果
        LinkedList<Integer> result = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            if (node.left != null) {
                queue.offer(node.left);
                max = Math.max(max, node.val);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }

            if (current == 0) {
                result.offer(max);
                max = Integer.MIN_VALUE;
                current = next;
                next = 0;
            }
        }
        return result;
    }

    //TODO 方法二：用二个队列实现
    private List<Integer> largestValues2(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root != null) {
            queue1.offer(root);
        }
        List<Integer> results = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            max = Math.max(max, node.val);

            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()) {
                results.add(max);
                queue1 = queue2;
                max = Integer.MIN_VALUE;
                queue2 = new LinkedList<>();
            }
        }
        return results;
    }

}
