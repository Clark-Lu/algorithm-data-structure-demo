package com.clark.lu.demo.algorithm;

/**
 * created by LuChang
 * 2019/6/12 15:46
 */
public class UniqueNumber {

    public static void main(String[] args) {
        int[] numbers = new int[]{2,2,1,3,3};
        System.out.println(getUniqueNumber(numbers));
    }

    public static int getUniqueNumber(int[] numbers){
        int a = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            a = a ^ numbers[i];
        }
        return a;
    }

}
