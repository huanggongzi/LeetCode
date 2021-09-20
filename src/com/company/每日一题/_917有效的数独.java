package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/17/0:22
 * @Description:
 */
public class _917有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] >= '0' && board[i][j] <= '9') {
                    if (!getEffective(i, j, board)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean getEffective(int i, int j, char[][] board) {
        // 验证一行
        for (int k = 0; k < board[i].length; k++) {
            if (board[i][k] == board[i][j] && k != j) {
                return false;
            }
        }
        // 验证一列
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == board[i][j] && k != i) {
                return false;
            }
        }
        // 验证当前 3 * 3 数组
        int heng = (i / 3) * 3;
        int zhong = (j / 3) * 3;

        for (int k1 = heng; k1 < heng + 3; k1++) {
            for (int k2 = zhong; k2 < zhong + 3; k2++) {
                if ((board[k1][k2] == board[i][j]) && (k1 != i && k2 != j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
