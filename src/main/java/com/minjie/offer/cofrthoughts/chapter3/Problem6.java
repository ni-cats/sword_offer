package com.minjie.offer.cofrthoughts.chapter3;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.cofrthoughts.chapter3.piece2
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-08-31  15:46
 * @Description: TODO 螺旋矩阵 二
 * @Version: 1.0
 */

public class Problem6 {
    public static void main(String[] args) {

        Problem6 testObject = new Problem6();
        int[] testData = new int[]{3, 2, 2, 2, 3};
        System.out.println(testObject.generateMatrix(9));

    }

    //TODO
    public int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j;

        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}
