package cn.zhumouren.leetcode.swordoffer;

public class Offer12 {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCEE"));
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCEC"));
    }

    private static boolean dfs(char[][] board, char[] word, boolean[][] visited, int i, int j, int start) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
                || word[start] != board[i][j]) {
            return false;
        }
        if (start == word.length - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean b;
        b = dfs(board, word, visited, i + 1, j, start + 1)
                || dfs(board, word, visited, i, j + 1, start + 1)
                || dfs(board, word, visited, i - 1, j, start + 1)
                || dfs(board, word, visited, i, j - 1, start + 1);
        visited[i][j] = false;
        return b;
    }

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, chars, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
