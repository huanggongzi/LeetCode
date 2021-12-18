package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/18/23:49
 * @Description:
 */
public class _1218甲板上的战舰 {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    dfs(board, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    // 染色法
    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') {
            return;
        }
        board[i][j] = '.';
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);

    }
}
