package com.minjie.offer.practice;


import javafx.scene.transform.Rotate;
import jdk.internal.util.xml.impl.ReaderUTF8;

import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题62：实现前缀树
 * @Version: 1.0
 */

public class interview_question_62 {
    public static void main(String[] args) {

        interview_question_62 testObject = new interview_question_62();

    }

}

//class Trie1 {
//    static class TrieNode {
//        TrieNode[] children;
//        boolean isWord;
//
//        public TrieNode() {
//            children = new TrieNode[26];
//        }
//    }
//
//    private TrieNode root;
//
//    public Trie1() {
//        root = new TrieNode();
//    }
//
//    public void insert(String word) {
//        TrieNode node = root;
//        for (char ch : word.toCharArray()) {
//            if (node.children[ch - 'a'] == null) {
//                node.children[ch - 'a'] = new TrieNode();
//            }
//            node = node.children[ch - 'a'];
//        }
//        node.isWord = true;
//    }
//
//    public boolean search(String word) {
//        TrieNode node = root;
//        for (char ch : word.toCharArray()) {
//            if (node.children[ch - 'a'] == null) {
//                return false;
//            }
//            node = node.children[ch - 'a'];
//        }
//        return node.isWord;
//    }
//
//    public boolean startWith(String word) {
//        TrieNode node = root;
//        for (char ch : word.toCharArray()) {
//            if (node.children[ch - 'a'] == null) {
//                return false;
//            }
//            node = node.children[ch - 'a'];
//        }
//        return true;
//    }
//}
