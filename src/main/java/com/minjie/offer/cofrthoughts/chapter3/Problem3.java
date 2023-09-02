package com.minjie.offer.cofrthoughts.chapter3;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.cofrthoughts.chapter3.piece2
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-08-31  15:46
 * @Description: TODO 移除元素
 * @Version: 1.0
 */

public class Problem3 {
    public static void main(String[] args) {

        Problem3 testObject = new Problem3();
        int[] testData = new int[]{3,2,2,2,3};
        System.out.println(testObject.removeElement2(testData, 3));

    }

    //TODO 双指针
    private int removeElement(int[] nums, int val) {
        int right = nums.length-1;
        int count = nums.length;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == val ){
                while (nums[right] == val && right > i){
                    right--;
                    count--;
                }
                nums[i] = nums[right--];
                count--;
            }
        }
        return right;
    }
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        int i = 0;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }


}
