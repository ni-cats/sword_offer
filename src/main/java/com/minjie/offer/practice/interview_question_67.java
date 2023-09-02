package com.minjie.offer.practice;


import com.sun.xml.internal.ws.message.RootElementSniffer;

import javax.swing.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题67：最大的异或
 * @Version: 1.0
 */

public class interview_question_67 {
    public static void main(String[] args) {

        interview_question_67 testObject = new interview_question_67();
        String[] strs = {"time", "me", "bell"};
    }

    static class TrieNode {
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }
    }

    public TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        TrieNode node = root;
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        return root;
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        int max = 0;
        for (int num : nums) {
            TrieNode node = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    node = node.children[1 - bit];
                } else {
                    xor = xor << 1;
                    node = node.children[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }

}

