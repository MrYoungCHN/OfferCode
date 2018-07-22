package com.test5;

import java.util.Arrays;

/**
 * @author YangJinyang
 * @date 2018/7/20
 *
 * 面试题5-测试类
 */
public class Test {
    // ====================测试代码====================

    /**
     * 测试代码
     * 将转换后的字符数组和期待转换结果比较。
     * 如果相同，则输出"passed."。
     * 否则，输出"failed."。
     * @param testName 测试方法名
     * @param str      待转换字符数组
     * @param length   字符串长度
     * @param expected 转换后字符数组(目标)
     */
    private static void test(String testName, char[] str, int length, char[] expected) {
        if (testName != null) {
            System.out.println(testName + " begins: ");
        }
        Solution solution = new Solution();
        str = solution.replaceBlank(str, length);
        if (expected == null && str == null) {
            System.out.println("passed.");
        } else if (expected == null && str != null) {
            System.out.println("failed.");
        } else if (Arrays.equals(str, expected)) {
            System.out.println("passed:" + Arrays.toString(str));
        } else {
            System.out.println("failed.");
        }
    }

    /**
     * 空格在句子中间
     */
    private static void test1() {
        int length = 100;
        String s = "Hello World";
        char[] str = new char[length];
        System.arraycopy(s.toCharArray(),0,str,0,s.length());
        test("test1", str, length, "Hello%20World".toCharArray());
    }

    /**
     * 空格在句子开头
     */
    private static void test2() {
        int length = 100;
        String s = " HelloWorld";
        char[] str = new char[length];
        System.arraycopy(s.toCharArray(),0,str,0,s.length());
        test("test2", str, length, "%20HelloWorld".toCharArray());
    }

    /**
     * 空格在句子末尾
     */
    private static void test3() {
        int length = 100;
        String s = "HelloWorld ";
        char[] str = new char[length];
        System.arraycopy(s.toCharArray(),0,str,0,s.length());
        test("test3", str, length, "HelloWorld%20".toCharArray());
    }

    /**
     * 连续有两个空格
     */
    private static void test4() {
        int length = 100;
        String s = "Hello  World ";
        char[] str = new char[length];
        System.arraycopy(s.toCharArray(),0,str,0,s.length());
        test("test4", str, length, "Hello%20%20World".toCharArray());
    }

    /**
     * 传入null
     */
    private static void test5() {
        test("test5", null, 0, null);
    }

    /**
     * 传入内容为空的字符串
     */
    private static void test6() {
        int length = 100;
        String s = "";
        char[] str = new char[length];
        System.arraycopy(s.toCharArray(),0,str,0,s.length());
        test("test6", str, length, "".toCharArray());
    }

    /**
     * 传入内容为一个空格的字符串
     */
    private static void test7() {
        int length = 100;
        String s = " ";
        char[] str = new char[length];
        System.arraycopy(s.toCharArray(),0,str,0,s.length());
        test("test7", str, length, "%20".toCharArray());
    }

    /**
     * 传入的字符串没有空格
     */
    private static void test8() {
        int length = 100;
        String s = "HelloWorld";
        char[] str = new char[length];
        System.arraycopy(s.toCharArray(),0,str,0,s.length());
        test("test8", str, length, "HelloWorld".toCharArray());
    }

    /**
     * 传入的字符串全是空格
     */
    private static void test9() {
        int length = 100;
        String s = "   ";
        char[] str = new char[length];
        System.arraycopy(s.toCharArray(),0,str,0,s.length());
        test("test9", str, length, "%20%20%20".toCharArray());
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
    }
}
