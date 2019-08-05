package com.clark.lu.demo.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by LuChang
 * 2019/8/5 18:20
 */
public class KPermutation {

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 1));
    }

    public static String getPermutation(int n, int k) {
        int[] numOrder = new int[n + 1];
        numOrder[0] = 0;
        Map<Integer, Integer> fMap = new HashMap<>();
        fMap.put(0, 1);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            fMap.put(i, fMap.get(i - 1) * i);
            list.add(i);
        }
        for (int i = 1; i <= n; i++) {
            numOrder[i] = ((int) Math.ceil(k / 1.0 / fMap.get(n - i))) % (n - i + 1);
            if (numOrder[i] == 0) {
                numOrder[i] = n - i + 1;
            }
        }
        StringBuffer s = new StringBuffer();
        for (int i = 1; i < n; i++) {
            s.append(list.get(numOrder[i] - 1));
            list.remove(numOrder[i] - 1);
        }
        s.append(list.get(0));
        return s.toString();
    }

}
