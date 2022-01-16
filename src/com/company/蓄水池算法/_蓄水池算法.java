package com.company.蓄水池算法;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/16/16:02
 * @Description:
 */
public class _蓄水池算法 {
    static Random random = new Random();

    public static void main(String[] args) {
        int test = 10000;
        int dataBase = 100;
        int[] count = new int[101];
        for (int i = 0; i < test; i++) {
            int[] bag = new int[10];
            int bagIndex = 0;
            for (int num = 1; num <= dataBase; num++) {
                // 如果小于10,直接入池
                if (num <= 10) {
                    bag[bagIndex++] = num;
                } else {
                    // 如果大于10,则以 10/i 的概率观察是否可以入池
                    // 如果小于等于10,则证明可以入池
                    if (getNum(num) <= 10) {
                        // 随机淘汰池里面的一个数
                        int index = random.nextInt(10);
                        bag[index] = num;
                    }
                }
            }
            for (int num : bag) {
                count[num]++;
            }
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }


    public static int getNum(int i) {
        // random.nextInt(i):返回[0,i)的数
        return random.nextInt(i) + 1;
    }
}
