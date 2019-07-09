package com.clark.lu.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * created by LuChang
 * 2019/6/12 17:09
 */
public class LongestUniqueString {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("algorithm"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> positionMap = new HashMap<>();
        int result = 0, n = s.length();
        for (int i = 0, j = 0; i < n; i++) {
            char c = s.charAt(i);
            if (positionMap.containsKey(c)) {
                if (positionMap.get(c) >= j) {
                    j = positionMap.get(c) + 1;
                }
            }
            int temp = i - j + 1;
            if (result < temp) {
                result = temp;
            }
            positionMap.put(c, i);
        }
        return result;
    }

}
