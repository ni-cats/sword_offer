package com.minjie.offer.practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题48：序列化和返序列化二叉树
 * @Version: 1.0
 */

public class interview_question_48 {
    public static void main(String[] args) {

        interview_question_48 testObject = new interview_question_48();
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
        System.out.println(testObject.serialize(root));

    }

    //TODO 序列化
    private String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        return String.valueOf(root.val) + "," + leftStr + "," + rightStr;
    }

    //TODO 反序列化
    private TreeNode deserialize(String data) {
        String[] nodeStrs = data.split(",");
        int[] i = {0};
        return dfs(nodeStrs,i);
    }

    private TreeNode dfs(String[] nodeStrs, int[] i) {
        String str = nodeStrs[i[0]];
        i[0]++;
        if (str.equals("#")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = dfs(nodeStrs,i);
        node.right = dfs(nodeStrs,i);
        return node;

    }


}
