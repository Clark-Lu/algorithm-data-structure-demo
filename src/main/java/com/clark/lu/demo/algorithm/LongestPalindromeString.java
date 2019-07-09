package com.clark.lu.demo.algorithm;

/**
 * created by LuChang
 * 2019/6/14 15:23
 */
public class LongestPalindromeString {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("adabccbad"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s);
        String rs = stringBuffer.reverse().toString();
        if (s.equals(rs)) {
            return s;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            int left1 = 0;
            int right1 = 0;
            int left2 = 0;
            int right2 = 0;
            boolean b1 = true;
            boolean b2 = true;
            for (int j = 1; j <= i + 1; j++) {
                int left1Temp = i - j;
                int right1Temp = i + j;
                int left2Temp = i -j + 1;
                int right2Temp = i + j;
                if (left1Temp >= 0 && right1Temp < s.length() && b1) {
                    if (s.charAt(left1Temp) == s.charAt(right1Temp)) {
                        left1 = left1Temp;
                        right1 = right1Temp;
                    } else {
                        b1 = false;
                    }
                } else {
                    b1 = false;
                }
                if (left2Temp >= 0 && right2Temp < s.length() && b2) {
                    if (s.charAt(left2Temp) == s.charAt(right2Temp)) {
                        left2 = left2Temp;
                        right2 = right2Temp;
                    }else {
                        b2 = false;
                    }
                }else {
                    b2 = false;
                }
            }
            int delta1 = right1 - left1;
            int delta2 = right2 - left2;
            int delta = right - left;
            if (delta1 < delta2) {
                if (delta < delta2) {
                    left = left2;
                    right = right2;
                }
            } else {
                if (delta < delta1) {
                    left = left1;
                    right = right1;
                }
            }
        }
        return s.substring(left, right + 1);
    }


}
