package com.minjie.offer.practice;


import com.sun.org.apache.xpath.internal.axes.OneStepIterator;

import javax.sql.rowset.BaseRowSet;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 108: 单词演变
 * @Version: 1.0
 */

public class interview_question_108 {
    public static void main(String[] args) {

        interview_question_108 testObject = new interview_question_108();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        testObject.ladderLength("jiangminjie", "zhenghaiqing", new LinkedList<String>());

    }

    //TODO 单向广度优先搜索
    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> notVisited = new HashSet<>(wordList);

        int length = 1;
        queue1.add(beginWord);
        while (!queue1.isEmpty()) {
            String word = queue1.remove();
            if (word.equals(endWord)) {
                return length;
            }
            List<String> neighbors = getNeighbors(word);
            for (String neighbor : neighbors) {
                if (notVisited.contains(neighbor)) {
                    queue2.add(neighbor);
                    notVisited.remove(neighbor);
                }
            }
            if (queue1.isEmpty()) {
                length++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }

        }
        return length;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (old != ch) {
                    chars[i] = ch;
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }


    //TODO 双向广度优先搜索
    private int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> notVisited = new HashSet<>(wordList);
        if (!notVisited.isEmpty()) {
            return 0;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int length = 2;
        set1.add(beginWord);
        set2.add(endWord);
        notVisited.remove(endWord);

        while (!set1.isEmpty() && !set2.isEmpty()) {
            if (set2.size() > set1.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }

            Set<String> set3 = new HashSet<>();
            for (String word : set1) {
                List<String> neighbors = getNeighbors(word);
                for (String neighbor : neighbors) {
                    if (set2.contains(neighbor)) {
                        return length;
                    }
                    if (notVisited.contains(neighbor)) {
                        set3.add(neighbor);
                        notVisited.remove(neighbor);
                    }
                }
            }
            length++;
            set1 = set3;
        }
        return 0;
    }

}

