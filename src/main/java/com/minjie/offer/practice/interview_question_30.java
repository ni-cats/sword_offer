package com.minjie.offer.practice;

import sun.util.resources.cldr.es.LocaleNames_es_CL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题30：插入、删除和随机访问都是O(1)的容器
 * @Version: 1.0
 */

public class interview_question_30 {
    public static void main(String[] args) {

        interview_question_30 testObject = new interview_question_30();

    }

}

class RandomizedSet {
    HashMap<Integer, Integer> numToLocation;
    ArrayList<Integer> nums;

    public RandomizedSet() {
        numToLocation = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (numToLocation.containsKey(val)) {
            return false;
        }
        numToLocation.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!numToLocation.containsKey(val)) {
            return false;
        }
        int location = numToLocation.get(val);
        numToLocation.put(nums.get(nums.size()-1),location);
        numToLocation.remove(val);
        nums.set(location,nums.get(nums.size()-1));
        nums.remove(nums.get(nums.size()-1));
        return true;
    }

    public int getRandom(){
        Random random = new Random();
        return nums.get(random.nextInt(nums.size()));
    }
}


