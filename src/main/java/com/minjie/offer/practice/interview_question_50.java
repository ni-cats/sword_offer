package com.minjie.offer.practice;


import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题50：向下的路径节点之和
 * @Version: 1.0
 */

public class interview_question_50 {
    public static void main(String[] args) {

        interview_question_50 testObject = new interview_question_50();
        TreeNode root = new TreeNode(0);
        System.out.println(testObject.pathSum(root, 8));

    }

    private int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        return dfs(root, sum, map, 0);
    }

    private int dfs(TreeNode root, int sum, Map<Integer, Integer> map, int path) {

        if (root == null) {
            return 0;
        }
        path += root.val;
        int count = map.getOrDefault(path - sum, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);

        count += dfs(root.left, sum, map, path);
        count += dfs(root.right, sum, map, path);

        map.put(path, map.get(path) - 1);
        return count;
    }


}

class Solution50 {
    //回溯 + 前缀和
    HashMap<Long, Integer> map = new HashMap<>();
    long sum = 0L;
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        preOrder(root, targetSum);
        return ans;
    }

    public void preOrder(TreeNode root, int targetSum) {
        if(root == null) {
            return;
        }
        ans += map.getOrDefault(sum + root.val - targetSum, 0);
        sum += root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        preOrder(root.left, targetSum);
        preOrder(root.right, targetSum);
        map.put(sum, map.get(sum) - 1);
        sum -= root.val;
    }
}




