package com.upane.plearn.algorithm;

import java.util.Arrays;

/**
 * Description:
 *
 * @Author:pan
 * @Date:2022/5/18
 */
public class KmpStrTwo {

        public static void main(String[] args) {
            long totalMilliSeconds1 = System.currentTimeMillis();
            String str1 = "BBC ABCDAB ABCDABCDABDE";
            String str2 = "C A";
//            String str3 = "aabaaac";

            int[] next = kmpNext(str2);
            System.out.println("str2子字符串的部分匹配值表为" + Arrays.toString(next));

            int index = kmpSearch(str1, str2, next);
            System.out.println("str2匹配成功的第一个下标是" + index);
            long totalMilliSeconds2 = System.currentTimeMillis();
            System.out.println(totalMilliSeconds2 - totalMilliSeconds1 + "ms");
            System.out.println();

//            System.out.println("str3子字符串的部分匹配值表为" + Arrays.toString(kmpNext(str3)));
//            System.out.println("str3匹配成功的第一个下标是" + kmpSearch(str1, str3, kmpNext(str3)));

        }

        /**
         * KMP搜索算法
         *
         * @param str1    源字符串
         * @param str2    子字符串
         * @param kmpNext 部分匹配表，子字符串对应的部分匹配表
         * @return 如果是-1就是没有匹配到，否则返回匹配成功的第一个下标的位置
         */
        public static int kmpSearch(String str1, String str2, int[] kmpNext) {
            int j = 0;
            for (int i = 0; i < str1.length(); i++) {
                while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                    j = kmpNext[i - 1];
                }

            }

            return 1;
        }

        // next表构造
        public static int[] kmpNext(String str2) {
            int[] nextKmp = new int[str2.length()];

            //记录状态位置
            int j = 0;
            // nextKmp[0]=0 所以i=1
            for (int i = 1; i < str2.length(); i++) {
                if (str2.charAt(i) == str2.charAt(j)) {
                    ++j;
                    nextKmp[i] = nextKmp[i - 1] + 1;
                } else {
                    //这步 即判断 当 aabaaaaaaaac 后面的几个a都应状态为2，而不是0
                    if (str2.charAt(i) == str2.charAt(i - 1)) {
                        nextKmp[i] = nextKmp[i - 1];
                    } else {
                        j = 0;
                    }
                }
            }
            return nextKmp;
        }


}
