package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/09/23:25
 * @Description:
 */
public class _1209有效的井字游戏 {
    public boolean validTicTacToe(String[] board) {
        // num1：O
        // num2：X
        int num1 = 0;
        int num2 = 0;

        for(int i = 0; i < board.length; i++){
            String str = board[i];
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == 'X'){
                    num1++;
                }else if(str.charAt(j) == 'O'){
                    num2++;
                }
            }
        }
        // 玩家二的棋子 大于 玩家一 的棋子
        if(num2 > num1){
            return false;
        }

        // 玩家一 和 玩家二 之间的差距大于1也不可以
        if(num1 - num2 > 1){

            return false;
        }


        // X
        boolean f1 = check(board, 'X');
        boolean f2 = check(board, 'O');
        if(f1 == true && f2 == true){
            return false;
        }

        if(f1 == true && f2 == false){
            if(num1 > num2){
                return true;
            }else{
                return false;
            }
        }

        if(f1 == false && f2 == true){
            if(num1 == num2){
                return true;
            }else{
                return false;
            }
        }

        if(f1 == false && f2 == false){
            return true;
        }

        return true;

    }


    public boolean check(String[] board, char ch){
        int len = board.length;
        // 横着
        for(int i = 0; i < 3; i++){
            String str = board[i];
            if(str.charAt(0) == ch && str.charAt(1) == ch && str.charAt(2) == ch){
                return true;
            }
        }
        // 竖着
        for(int i = 0; i < 3; i++){
            if(board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch){
                return true;
            }
        }

        // 斜着
        if(board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch){
            return true;
        }

        if(board[2].charAt(0) == ch && board[1].charAt(1) == ch && board[0].charAt(2) == ch){
            return true;
        }

        return false;
    }
}
