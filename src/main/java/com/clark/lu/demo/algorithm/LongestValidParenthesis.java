package com.clark.lu.demo.algorithm;

/**
 * created by LuChang
 * 2019/8/2 15:36
 */
public class LongestValidParenthesis {

    public static void main(String[] args) {
        System.out.println(longestValidParenthesis("(()()(((()"));
    }

    public static int longestValidParenthesis(String s) {
        int result = 0, left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, 2 * left);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >=0 ; i--) {
            if (s.charAt(i) == ')'){
                right++;
            }else {
                left++;
            }
            if (right == left){
                result = Math.max(result,2*left);
            }else if (left > right){
                left = right = 0;
            }
        }
        return result;
    }

}
