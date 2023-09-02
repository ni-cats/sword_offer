package com.minjie.offer.practice;


import java.nio.channels.ClosedSelectorException;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题66：单词之和
 * @Version: 1.0
 */

public class interview_question_66 {
    public static void main(String[] args) {

        interview_question_66 testObject = new interview_question_66();
        String[] strs = {"time", "me", "bell"};
    }

}

class MapSum {
    static class TrieNode {
        public TrieNode[] children;
        public int value;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
        }
        node.value = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return getSum(node);
    }

    private int getSum(TrieNode node) {
        if (node == null) {
            return 0;
        }
        int result = node.value;
        for (TrieNode child : node.children) {
            result += getSum(child);
        }
        return result;
    }
}

