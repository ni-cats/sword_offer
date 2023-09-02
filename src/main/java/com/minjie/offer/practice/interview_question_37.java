package com.minjie.offer.practice;


import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题37：小行星碰撞
 * @Version: 1.0
 */

public class interview_question_37 {
    public static void main(String[] args) {

        interview_question_37 testObject = new interview_question_37();
        int[] testData = new int[]{0, 1, 0};
        ListNode head1 = new ListNode(520);
        ListNode head2 = new ListNode(520);
        String s1 = "anagram";
        String s2 = "nagaram";
        String[] strs1 = {"jiangminjie", "zhenghaiqing", "fengminjiongjun"};
        String[] strs = {"4", "13", "5", "/", "+"};
        int[] testInt = {-2,-1,1,2};
        List<String> stringList = new ArrayList<>(Arrays.asList("00:00", "23:50"));
        System.out.println(testObject.asteroidCollision(testInt));

    }

    private int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
       for (int as : asteroids) {
            while (!stack.empty() && stack.peek() > 0 && stack.peek() < -as) {
                stack.pop();
            }
            if (!stack.empty() && as < 0 && stack.peek() == -as) {
                stack.pop();
            } else if (as > 0 || stack.empty() || stack.peek() < 0) {
                stack.push(as);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int aster : asteroids) {
                boolean alive = true;
                while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                    alive = stack.peek() < -aster; // aster是否存在
                    if (stack.peek() <= -aster) {  // 栈顶小行星爆炸
                        stack.pop();
                    }
                }
                if (alive) {
                    stack.push(aster);
                }
            }
            int size = stack.size();
            int[] ans = new int[size];
            for (int i = size - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/XagZNi/solutions/1663443/xiao-xing-xing-peng-zhuang-by-leetcode-s-tfn2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}


