package com.clark.lu.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * created by LuChang
 * 2019/8/3 13:40
 */
public class FullPermutation {

    public static void main(String[] args) {

        List<List<Integer>> permute = permute(new int[]{1,2,3});
        for (List<Integer> list : permute) {
            for (Integer i : list) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : nums){
            list.add(i);
        }
        int size = 1;
        for (int i = 2; i <= list.size(); i++) {
            size = size * i;
        }
        List<List<Integer>> result = new ArrayList<>(size);
        result.add(list);
        for (int i = 0; i < list.size(); i++) {
            List<List<Integer>> tempResult = new ArrayList<>();
            for (int j = i + 1; j < list.size(); j++) {
                for (List<Integer> tempList : result) {
                    tempResult.add(swap(tempList, i, j));
                }
            }
            result.addAll(tempResult);
        }
        return result;
    }

    private static List<Integer> swap(List<Integer> list, int i, int j) {
        List<Integer> result = new ArrayList<>(list);
        int temp = list.get(i);
        result.set(i, list.get(j));
        result.set(j, temp);
        return result;
    }

}
