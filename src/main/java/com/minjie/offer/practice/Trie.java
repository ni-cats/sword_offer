package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.practice
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-08-11  16:20
 * @Description: TODO 前缀树
 * @Version: 1.0
 */

public class Trie {
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
}
