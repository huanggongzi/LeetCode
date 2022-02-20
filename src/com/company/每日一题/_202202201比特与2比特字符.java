package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/20/20:44
 * @Description:
 */
public class _202202201比特与2比特字符 {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }
        boolean b = false;
        for (int i = 0; i < bits.length; i++) {
            if (i == bits.length - 2 && bits[i] == 0) {
                return true;
            } else if (i == bits.length - 2 && bits[i] == 1) {
                return false;
            }
            if (bits[i] == 1) {
                i++;
            }
        }
        return true;
    }
}
