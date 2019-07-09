package com.clark.lu.demo.algorithm;

/**
 * created by LuChang
 * 2019/6/14 10:39
 */
public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        int[] numbers1 = {1};
        int[] numbers2 = {2};
        System.out.println(getMedian(numbers1, numbers2));
    }


    public static double getMedian(int[] numbers1, int[] numbers2) {
        int n1 = numbers1.length;
        int n2 = numbers2.length;
        int n = n1 + n2;
        int position = n / 2;
        boolean needTwo = n % 2 == 0;
        int i = 0, j = 0, numbs = 0;
        int[] result = new int[position + 1];
       do {
            numbs = i + j;
            if (i == n1) {
                result[numbs] = numbers2[j];
                j++;
                continue;
            } else if (j == n2) {
                result[numbs] = numbers1[i];
                i++;
                continue;
            } else if (numbers1[i] < numbers2[j]) {
                result[numbs] = numbers1[i];
                i++;
            } else {
                result[numbs] = numbers2[j];
                j++;
            }
        } while (numbs < position);
        if (needTwo) {
            return (result[position] + result[position - 1]) / 2.0;
        }
        return result[position];
    }

}
