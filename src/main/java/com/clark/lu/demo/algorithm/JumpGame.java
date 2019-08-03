package com.clark.lu.demo.algorithm;

/**
 * created by LuChang
 * 2019/8/3 11:17
 */
public class JumpGame {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    public static int jump(int[] nums) {
        int result = 0, position = 0;
        if (nums.length == 1){
            return 0;
        }
        while (true) {
            result++;
            int temp = 0,nextPosition = 0;
            int n = nums[position] + position;
            if (n >= nums.length - 1) {
                break;
            }
            for (int i = position + 1; i <= n; i++) {
                int step = i - position + nums[i];
                if (step > temp) {
                    temp = step;
                    nextPosition = i;
                }
            }
            position = nextPosition;
        }
        return result;
    }

}
