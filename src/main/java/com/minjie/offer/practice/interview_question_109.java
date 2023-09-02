package com.minjie.offer.practice;


import javafx.scene.shape.Circle;

import javax.swing.*;
import java.io.StringReader;
import java.rmi.Remote;
import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 109: 开密码锁
 * @Version: 1.0
 */

public class interview_question_109 {
    public static void main(String[] args) {

        interview_question_109 testObject = new interview_question_109();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        String[] strs = {"jiangminjie", "zhenghaiqing"};
        testObject.openLock(strs, "fengminjiongjun");

    }

    //TODO 单向广度优先搜索
    private int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String init = "0000";
        if (dead.contains(init) || dead.contains(target)) {
            return -1;
        }

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        int steps = 0;
        queue1.add(init);
        visited.add(init);
        while (!queue1.isEmpty()) {
            String cur = queue1.remove();
            if (cur.equals(target)) {
                return steps;
            }

            List<String> nexts = getNeighbors(cur);
            for (String next : nexts) {
                if (!dead.contains(next) && visited.contains(next)) {
                    queue2.add(next);
                    visited.add(next);
                }
            }
            if (queue1.isEmpty()) {
                steps++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return -1;
    }

    private List<String> getNeighbors(String cur) {
        List<String> nexts = new LinkedList<>();
        for (int i = 0; i < cur.length(); i++) {
            char ch = cur.charAt(i);

            StringBuilder builder = new StringBuilder(cur);
            char newCh = ch == '0' ? '9' : (char) (ch - 1);
            builder.setCharAt(i, newCh);
            nexts.add(builder.toString());

            newCh = ch == '9' ? '0' : (char) (ch + 1);
            builder.setCharAt(i, newCh);
            nexts.add(builder.toString());
        }
        return nexts;
    }


}

