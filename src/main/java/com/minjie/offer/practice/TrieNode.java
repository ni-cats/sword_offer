package com.minjie.offer.practice;


/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.practice
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-08-11  17:48
 * @Description: TODO
 * @Version: 1.0
 */

public class TrieNode {
    TrieNode[] children;
    boolean isWord;
    private TrieNode root;

    public TrieNode() {
        children = new TrieNode[26];
        root = new TrieNode();
    }

    public boolean search(String word){
        return dfs(root,word,0,0);
    }

    private boolean dfs(TrieNode root, String word, int i, int edit) {
        if (root == null){
            return false;
        }
        if (root.isWord && i == word.length() && edit ==1){
            return true;
        }
        if (i < word.length() && edit <=1){
            boolean found = false;
            for (int j = 0; j < 26 && !found; j++) {
                int next = j == word.charAt(i) - 'a' ? edit :edit+1;
                dfs(root.children[j], word,i+1,next);
            }
            return found;
        }
        return false;
    }
}
