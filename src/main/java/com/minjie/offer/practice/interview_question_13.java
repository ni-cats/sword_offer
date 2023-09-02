package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题12：二维子矩阵的数字之和
 * @Version: 1.0
 */

public class interview_question_13 {
    public static void main(String[] args) {

        interview_question_13 testObject = new interview_question_13();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9, 10}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));

    }


}

class NumMatrix {
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {

                rowSum += matrix[i][j];
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row1 + 1][col1 + 1] - sums[row1][col1 + 1] - sums[row1 + 1][col1] + sums[row1][col1];
    }
}
