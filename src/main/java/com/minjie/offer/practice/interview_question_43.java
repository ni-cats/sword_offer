package com.minjie.offer.practice;


import java.sql.PseudoColumnUsage;
import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题43：在完全二叉树中添加节点
 * @Version: 1.0
 */

public class interview_question_43 {
    public static void main(String[] args) {

        interview_question_43 testObject = new interview_question_43();
        int[] testData = new int[]{0, 1, 0};
        ListNode head1 = new ListNode(520);
        ListNode head2 = new ListNode(520);
        String s1 = "anagram";
        String s2 = "nagaram";
        String[] strs1 = {"jiangminjie", "zhenghaiqing", "fengminjiongjun"};
        String[] strs = {"4", "13", "5", "/", "+"};
        int[] testInt = {3, 2, 5, 4, 6, 1, 4, 2};
        List<String> stringList = new ArrayList<>(Arrays.asList("00:00", "23:50"));

    }
}

class CBTInserter {
    private Queue<TreeNode> queue;
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty() && queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode parents = queue.peek();
        TreeNode node = new TreeNode(v);

        if (parents.left == null) {
            parents.left = node;
        } else {
            parents.right = node;
            queue.poll();
            queue.offer(parents.left);
            queue.offer(parents.right);
        }
        return parents.val;
    }

    public TreeNode get_root(){
        return root;
    }
}
