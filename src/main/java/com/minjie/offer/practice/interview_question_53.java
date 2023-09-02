package com.minjie.offer.practice;


import com.sun.xml.internal.bind.v2.TODO;

import javax.lang.model.util.ElementScanner6;
import java.util.Stack;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题53：二叉搜索树的下一个节点
 * @Version: 1.0
 */

public class interview_question_53 {
    public static void main(String[] args) {

        interview_question_53 testObject = new interview_question_53();
        TreeNode root = new TreeNode(0);
        System.out.println(testObject.inorderSuccessor(root, new TreeNode(8)));

    }

    //TODO 时间复杂度：o(n)
    private TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        boolean found = false;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            //
            if (found) {
                break;
            } else if (cur == p) {
                found = true;
            }
            cur = cur.right;
        }
        return cur;
    }

    //TODO 时间复杂度：o(h)
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode result = null;
        while (cur != null){
            if (cur.val <= p.val){
                cur= cur.right;
            }else {
                result = cur;
                cur = cur.left;
            }
        }
        return result;
    }

}
