package com.clark.lu.demo.algorithm;

import java.util.*;

/**
 * created by LuChang
 * 2019/7/5 18:01
 */
public class AllPosibleString {

    public static void main(String[] args) {
        for (String result : getAllPossibleString("234")) {
            System.out.println(result);
        }
    }

    private static final Map<String,List<String>> map = new HashMap<>();

    static {
        map.put("2", Arrays.asList("a","b","c"));
        map.put("3",Arrays.asList("d","e","f"));
        map.put("4",Arrays.asList("g","h","i"));
        map.put("5",Arrays.asList("j","k","l"));
        map.put("6",Arrays.asList("m","n","o"));
        map.put("7",Arrays.asList("p","q","r","s"));
        map.put("8",Arrays.asList("t","u","v"));
        map.put("9",Arrays.asList("w","x","y","z"));
    }

    public static List<String> getAllPossibleString(String digits){
        String[] numbers = digits.split("");
        if (numbers.length == 0){
            return new ArrayList<>();
        }
        List<String> list = map.get(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            list = assembleList(list,map.get(numbers[i]));
        }
        return list;
    }

    private static List<String> assembleList(List<String> source,List<String> character){
        List<String> result = new ArrayList<>(source.size()*character.size());
        for (String s : source){
            for (String c : character){
                result.add(s + c);
            }
        }
        return result;
    }

}
