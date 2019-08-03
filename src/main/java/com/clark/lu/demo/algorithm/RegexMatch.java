package com.clark.lu.demo.algorithm;

/**
 * created by LuChang
 * 2019/8/3 10:46
 */
public class RegexMatch {

    public static void main(String[] args) {
        System.out.println(isMatch("abc","a?*"));
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            f[0][i] = f[0][i-1] && p.charAt(i-1) == '*';
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '?'){
                    f[i][j] = f[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                    f[i][j] = f[i-1][j] || f[i][j-1];
                }else {
                    f[i][j] = f[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
                }
            }
        }
        return f[m][n];
    }

}
