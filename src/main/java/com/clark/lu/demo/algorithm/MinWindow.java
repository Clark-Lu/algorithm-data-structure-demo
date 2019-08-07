package com.clark.lu.demo.algorithm;

import java.util.*;

/**
 * created by LuChang
 * 2019/8/6 16:35
 */
public class MinWindow {

    public static void main(String[] args) {
        System.out.println(minWindow("abca","ac"));
    }

    public static String minWindow(String s,String t){
        int left=0,right=0,distance=s.length();
        List<Character> ts = new LinkedList<>();
        Set<Character>  set = new HashSet<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            ts.add(t.charAt(i));
            set.add(t.charAt(i));
        }
        List<Character> copy = new LinkedList<>(ts);
        String result = "";
        while (right < s.length()){
            copy.remove((Character) s.charAt(right));
            if (copy.size() == 0){
                right++;
                if (distance >= right - left){
                    distance = right - left - 1;
                    result = s.substring(left,right);
                }
                while (left < right - t.length()){
                    if (!set.contains(s.charAt(left))){
                        left++;
                        if (distance >= right - left) {
                            distance = distance - 1;
                            result = s.substring(left, right);
                        }
                    }else {
                        left++;
                        right=left;
                    }
                }
                copy = new LinkedList<>(ts);
            }else {
                right++;
            }
        }
        return result;
    }

}
