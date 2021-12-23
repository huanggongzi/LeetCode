package com.company.操作系统;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/23/0:44
 * @Description:
 */
public class TestVolatile {
    public static volatile int counter = 2;

    public static void main(String[] args) {
        counter = 2;
        System.out.println(counter);
    }
}
