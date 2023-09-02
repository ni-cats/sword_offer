package com.minjie.offer.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.practice
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-08-06  21:24
 * @Description: TODO
 * @Version: 1.0
 */

public class TreeNode {

    public TreeNode parents;
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode parents) {
        this.parents = parents;
    }

    // TODO 广度优先搜索
    public List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    // TODO 深度优先搜索 --- 中序遍历 -- 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        inDfs(root, nodes);
        return nodes;
    }

    private void inDfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            inDfs(root.left, nodes);
            nodes.add(root.val);
            inDfs(root.right, nodes);
        }
    }

    // TODO 深度优先搜索 --- 中序遍历 -- 非递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            nodes.add(cur.val);
            cur = cur.right;
        }
        return nodes;
    }

    // TODO 深度优先搜索 --- 前序遍历 -- 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        preDfs(root, nodes);
        return nodes;
    }

    private void preDfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            nodes.add(root.val);
            preDfs(root.left, nodes);
            preDfs(root.right, nodes);
        }
    }

    // TODO 深度优先搜索 --- 前序遍历 -- 非递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                nodes.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return nodes;
    }

    // TODO 深度优先搜索 --- 后序遍历 -- 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        postDfs(root, nodes);
        return nodes;
    }

    private void postDfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            postDfs(root.left, nodes);
            postDfs(root.right, nodes);
            nodes.add(root.val);
        }
    }

    // TODO 深度优先搜索 --- 后序遍历 -- 非递归
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != prev) {
                cur = cur.right;
            } else {
                stack.pop();
                nodes.add(cur.val);
                prev = cur;
                cur = null;
            }
        }
        return nodes;
    }

    //TODO 根据节点值查找二叉搜索树
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            }
            if (cur.val >= val) {
                cur = cur.left;
            }
            if (cur.val <= val) {
                cur = cur.right;
            }
        }

        return cur;
    }

}
