package com.upane.plearn.algorithm;

/**
 * Description:反转字符串中的单词 III
 *
 * @Author:pan
 * @Date:2022/5/20
 */
public class ReverseWords {

    public static void main(String[] args) {
        String words = new Solution().reverseWords("abc zxc qwe");
        System.out.println(words);

    }

    static class Solution {
        public String reverseWords(String s) {
            // StringBuffer 比 StringBuilder 内存占用 好很多哦哦哦
            StringBuffer res = new StringBuffer();
            int right = 0;
            while (right < s.length()) {
                int left = right;
                while (right < s.length() && s.charAt(right) != ' ') {
                    right++;
                }
                for (int i = left; i < right; i++) {
                    res.append(s.charAt(left + right - i - 1));
                }
                while (right < s.length() && s.charAt(right) == ' ') {
                    right++;
                    res.append(' ');
                }
            }
            return res.toString();
        }
    }
}
