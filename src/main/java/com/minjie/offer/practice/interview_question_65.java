package com.minjie.offer.practice;


/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题65：最短的单词编码
 * @Version: 1.0
 */

public class interview_question_65 {
    public static void main(String[] args) {

        interview_question_65 testObject = new interview_question_65();
        String[] strs = {"time", "me", "bell"};
    }


    static class TrieNode {
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);
        int[] total = {0};
        dfs(root, 1, total);
        return total[0];
    }

    // TODO 翻转字符串，反向建树
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (node.children[word.charAt(i) - 'a'] == null) {
                    node.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                node = node.children[word.charAt(i) - 'a'];
            }
        }
        return root;
    }

    //TODO 递归求路径总和
    public void dfs(TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length + 1, total);
            }
        }
        if (isLeaf) {
            total[0] += length;
        }
    }
}

