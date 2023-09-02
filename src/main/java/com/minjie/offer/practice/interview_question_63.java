package com.minjie.offer.practice;


import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题63：替换单词
 * @Version: 1.0
 */

public class interview_question_63 {
    public static void main(String[] args) {

        interview_question_63 testObject = new interview_question_63();
        TreeNode root = new TreeNode(0);
        int[] nums1 = {1, 2, 4, 5, 6,};
        int[] nums2 = {1, 3, 4, 6};
        System.out.println(testObject.replaceWords(new ArrayList<>(), "jiangminjie"));

    }

    private String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildTrie(dict);
        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = findPrefix(root, words[i]);
            if (!prefix.isEmpty()){
                words[i] = prefix;
            }
        }
        return String.join("",words);
    }


    private String findPrefix(TrieNode root, String word) {
        TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (node.isWord || node.children[ch - 'a'] == null) {
                break;
            }
            builder.append(ch);
            node = node.children[ch - 'a'];
        }
        return node.isWord ? builder.toString() : "";
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }

}
