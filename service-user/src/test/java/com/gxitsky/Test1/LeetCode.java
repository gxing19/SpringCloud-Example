package com.gxitsky.Test1;

import org.junit.Test;

/**
 * @name: LeetCode
 * @desc: TODO
 * @author: gxing
 * @date: 2019-04-17 18:31
 **/
public class LeetCode {

    @Test
    public void getNumsIndex(){
        int target = 9;
        int[] nums = {2,7,11,15};
        int length = nums.length;
        int[] newNums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int length1 = newNums.length;
            if (num <= target){
                newNums[length1 + 1] = num;
            }
        }

        System.out.println(newNums);

    }
}