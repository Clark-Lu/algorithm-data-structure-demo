package com.clark.lu.demo.algorithm;

/**
 * created by LuChang
 * 2019/8/2 17:59
 */
public class SmallestPositiveNumber {

    public static void main(String[] args) {
        System.out.println(smallestPositiveNumber(new int[]{2,1}));
    }

    public static int smallestPositiveNumber(int[] nums) {
        int result = nums.length+1;
        boolean isOne = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                isOne = false;
            } else if (nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        if (isOne){
            return 1;
        }
        if (nums.length == 1){
            return 2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return i+1;
            }
        }
        return result;
    }

}
