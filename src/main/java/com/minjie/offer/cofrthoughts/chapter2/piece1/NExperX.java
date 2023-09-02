package com.minjie.offer.cofrthoughts.chapter2.piece1;


import static jdk.nashorn.internal.objects.NativeFunction.function;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.cofrthoughts.chapter2.piece1
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-09-01  09:45
 * @Description: TODO 求X的n次方
 * @Version: 1.0
 */

public class NExperX {
    public static void main(String[] args) {

        NExperX nExperX = new NExperX();
        System.out.println(nExperX.function1(2, 16));
    }

    // TODO 暴力解
    private int function1(int x, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = x * result;
        }
        return result;
    }

    // TODO 递归 --o(n)
    private int function2(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        return function2(x, n - 1) * x;
    }

    // TODO 递归 --o(n)
    private int function3(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 1) {
            return function3(x, n / 2) + function3(x, n / 2) * x;
        }
        return function3(x, n / 2) + function3(x, n / 2);
    }

    // TODO 递归 --o(n)
    private int function4(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        int t = function4(x, n / 2);
        if (n % 2 == 1) {
            return t * t * x;
        }
        return t * t;
    }
}
