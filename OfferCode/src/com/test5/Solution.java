package com.test5;

import java.util.Arrays;

/**
 * @author YangJyang
 * @date 2018/7/21
 * All rights reserved.
 * <p>
 * 面试题5：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 * 则输出“We%20are%20happy.”。
 */
public class Solution {
    /**
     * 替换空格(剑指offer c++源码改)
     *
     * @param str    初始字符串字符串
     * @param length 字符数组str的总容量，大于或等于字符串str的实际长度
     * @return 返回转换后的字符数组
     */
    public char[] replaceBlank(char[] str, int length) {
        if (str == null && length <= 0) {
            return str;
        }
        // originalLength 为字符串str的实际长度(去掉空格)
        int originalLength = 0;
        // 字符串中空格的个数
        int numberOfBlank = 0;
        int i = 0;
        while (str[i] != '\0') {
            ++originalLength;
            if (str[i] == ' ') {
                ++numberOfBlank;
            }
            ++i;
        }
        // newLength 为把空格替换成'%20'之后的长度
        int newLength = originalLength + numberOfBlank * 2;
        if (newLength > length) {
            return null;
        }
        str = Arrays.copyOf(str, newLength);
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if (str[indexOfOriginal] == ' ') {
                str[indexOfNew--] = '0';
                str[indexOfNew--] = '2';
                str[indexOfNew--] = '%';
            } else {
                str[indexOfNew--] = str[indexOfOriginal];
            }
            --indexOfOriginal;
        }
        return str;
    }

    /**
     * 替换空格(剑指offer 牛客网)
     *
     * @param str 待转换字符串
     * @return 替换空格后的字符串
     */
    public String replaceBlank(StringBuffer str) {
        if (str == null) {
            return null;
        } else if( str.length() <= 0){
            return str.toString();
        }
        // 字符串原长度
        int originalLength = str.length();
        // 字符串中空格的个数
        int numberOfBlank = 0;
        int i = 0;
        while (i < originalLength) {
            if(str.charAt(i) == ' '){
                ++numberOfBlank;
            }
            ++i;
        }
        int newLength = originalLength + numberOfBlank * 2;
        //扩容
        str.setLength(newLength);
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if(str.charAt(indexOfOriginal) == ' '){
                str.setCharAt(indexOfNew--,'0');
                str.setCharAt(indexOfNew--,'2');
                str.setCharAt(indexOfNew--,'%');
            } else {
                str.setCharAt(indexOfNew--,str.charAt(indexOfOriginal));
            }
            indexOfOriginal--;
        }
        return str.toString();
    }
}


