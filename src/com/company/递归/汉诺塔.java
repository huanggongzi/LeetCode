package com.company.递归;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/17/17:02
 * @Description:
 */
public class 汉诺塔 {
    public static void main(String[] args) {
        汉诺塔 test = new 汉诺塔();
        test.leftMoveRight(3);
        System.out.println("======");
        test.hannuota(3, "left", "right", "mid");
    }

    // 把1~N圆盘从最左到最右
    public void leftMoveRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to right");
            return;
        }
        leftMoveMid(n - 1);
        System.out.println("Move " + n + " from left to right");
        midMoveRight(n - 1);
    }


    // 把1~N圆盘从最左到中
    public void leftMoveMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to mid");
        }
        leftMoveRight(n - 1);
        System.out.println("Move " + n + " from left to mid");
        rightMoveMid(n - 1);
    }


    public void midMoveRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from mid to right");
            return;
        }
        midMoveleft(n - 1);
        System.out.println("Move " + n + " from mid to right");
        leftMoveRight(n - 1);
    }

    public void rightMoveMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from right to mid");
            return;
        }
        rightMoveleft(n - 1);
        System.out.println("Move " + n + " from right to mid");
        leftMoveMid(n - 1);
    }

    public void midMoveleft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from mid to left");
            return;
        }
        midMoveRight(n - 1);
        System.out.println("Move " + n + " from mid to left");
        rightMoveleft(n - 1);
    }

    public void rightMoveleft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from right to left");
            return;
        }
        rightMoveMid(n - 1);
        System.out.println("Move " + n + " from right to left");
        midMoveRight(n - 1);
    }


    public void hannuota(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
            return;
        }
        hannuota(n - 1, from, other, to);
        System.out.println("Move " + n + " from " + from + " to " + to);
        hannuota(n - 1, other, to, from);

    }
}
