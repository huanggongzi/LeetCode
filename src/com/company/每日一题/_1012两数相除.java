package com.company.每日一题;

import javafx.scene.AmbientLight;

import javax.sound.midi.MidiChannel;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/12/21:39
 * @Description:
 */
public class _1012两数相除 {
    class Solution {
        public int divide(int _dividend, int _divisor) {
            // dividend / divisor
            long dividend = _dividend;
            long divisor = _divisor;
            // 看一下最后的结果是负数还是正数
            boolean flag = true;
            if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
                flag = false;
            }

            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);

            // dividend = divisor * x
            long left = 0;
            long right = dividend;
            while (left <= right) {
                long mid = (right - left) / 2 + left;
                if (mul(divisor, mid) <= dividend) {
                    left = mid + 1;
                } else if (mul(divisor, mid) > dividend) {
                    right = mid - 1;
                }
            }
            long ans = flag ? right : -right;
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) ans;
        }

        public long mul(long divisor, long mid) {
            long ans = 0;
            while (divisor > 0) {
                if ((divisor & 1) == 1) {
                    ans = ans + mid;
                }
                divisor = divisor >> 1;
                mid += mid;
            }
            return ans;
        }
    }
}
