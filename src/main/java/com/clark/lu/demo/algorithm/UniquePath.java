package com.clark.lu.demo.algorithm;

/**
 * created by LuChang
 * 2019/8/5 19:45
 */
public class UniquePath {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }

    public static int uniquePaths(int m,int n){
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }

}
