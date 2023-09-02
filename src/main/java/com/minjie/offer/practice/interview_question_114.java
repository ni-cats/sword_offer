package com.minjie.offer.practice;


import java.beans.beancontext.BeanContext;
import java.lang.reflect.Member;
import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 114: 外星文字典
 * @Version: 1.0
 */

public class interview_question_114 {
    public static void main(String[] args) {
        interview_question_114 testObject = new interview_question_114();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        String[] strs = {"jiangminjie", "zhenghaiqing"};
        testObject.alienOrder(strs);

    }

    //TODO 深度优先搜索 --- 拓扑排序
    private String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                inDegrees.putIfAbsent(ch, 0);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            if (word1.startsWith(word2) && !word1.equals(word2)) {
                return "";
            }

            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2) {
                    if (!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        inDegrees.put(ch2, inDegrees.get(ch2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char ch : inDegrees.keySet()) {
            if (inDegrees.get(ch) == 0) {
                queue.add(ch);
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            char ch = queue.remove();
            sb.append(ch);
            for (char next : graph.get(ch)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }


}


