package com.clark.lu.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PairGenerate {

    static class Pair {
        int a;
        int b;
        int originPosition;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }

        public boolean compatible(Pair p) {
            return this.a != p.a && this.b != p.b && this.a != p.b && this.b != p.a;
        }
    }

    public static void main(String[] args) {
        List<List<Pair>> lists = generatePair(10);
        lists.forEach(list -> {
            list.forEach(pair -> System.out.println(pair));
            System.out.println("=========================");
        });
    }

    public static List<List<Pair>> generatePair(int n) {
        List<List<Pair>> result = new ArrayList<>();
        if (n % 2 != 0) {
            n = n + 1;
        }
        int pairNum = n / 2;
        List<Pair> origin = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                Pair pair = new Pair(i, j);
                origin.add(pair);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            List<Pair> list = generatePair(origin, pairNum);
            result.add(list);
            removeUsedPairs(origin,list);
        }
        return result;
    }

    public static List<Pair> generatePair(List<Pair> origin, int pairNum) {
        List<Pair> list = new ArrayList<>(pairNum);
        int position = 0;
        while (true) {
            for (int i = position; i < origin.size(); i++) {
                Pair pair = origin.get(i);
                if (isCompatible(list, pair)) {
                    pair.originPosition = i;
                    list.add(pair);
                }
            }
            if (list.size() < pairNum) {
                Pair remove = list.remove(list.size() - 1);
                position = remove.originPosition + 1;
            } else {
                return list;
            }
        }
    }

    private static boolean isCompatible(List<Pair> list, Pair pair) {
        for (Pair p : list) {
            if (!p.compatible(pair)) {
                return false;
            }
        }
        return true;
    }

    private static void removeUsedPairs(List<Pair> origin, List<Pair> list){
        for (Pair pair : list){
            for (int i = origin.size() - 1; i >=0 ; i--) {
                if (origin.get(i) == pair){
                    origin.remove(i);
                }
            }
        }
    }
}
