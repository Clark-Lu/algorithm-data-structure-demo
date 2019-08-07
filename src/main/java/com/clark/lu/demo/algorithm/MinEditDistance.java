package com.clark.lu.demo.algorithm;

/**
 * created by LuChang
 * 2019/8/6 16:17
 */
public class MinEditDistance {

    public static void main(String[] args) {
        System.out.println(minDistance("hello","hi"));
    }

    public static int minDistance(String word1,String word2){
        int[][] f = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < f.length; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i < f[0].length; i++) {
            f[0][i] = i;
        }
        for (int i = 1; i < f.length; i++) {
            for (int j = 1; j < f[i].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    f[i][j] = f[i-1][j-1];
                }else {
                    f[i][j] = 1 + Math.min(Math.min(f[i-1][j],f[i][j-1]),f[i-1][j-1]);
                }
            }
        }
        return f[word1.length()][word2.length()];
    }

}
