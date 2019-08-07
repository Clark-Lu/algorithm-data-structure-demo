package com.clark.lu.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * created by LuChang
 * 2019/8/7 15:12
 */
public class BackTrack {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

   public static List<List<Integer>> permute(int[] nums){
       List<List<Integer>> list = new ArrayList<>();
       List<Integer> tempList = new ArrayList<>();
       backTrack(list,tempList,nums);
       return list;
   }

   public static void backTrack(List<List<Integer>> list,List<Integer> tempList,int[] nums){
       System.out.println(tempList);
       if (tempList.size() == nums.length){
           list.add(new ArrayList<>(tempList));
       }else {
           for (int i = 0; i < nums.length; i++) {
               if (!tempList.contains(nums[i])){
                   tempList.add(nums[i]);
                   backTrack(list,tempList,nums);
                   System.out.println(tempList);
                   System.out.println("remove " + tempList.get(tempList.size() - 1));
                   tempList.remove(tempList.size()-1);
                   System.out.println(tempList);
               }
           }
       }
   }

}
