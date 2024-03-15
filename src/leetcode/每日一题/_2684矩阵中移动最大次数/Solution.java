package leetcode.每日一题._2684矩阵中移动最大次数;

public class Solution {
    public int maxMoves(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            dp[i][0] = 1;
        }
        int n = grid[0].length;
        int res = 0;
        int m = grid.length;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < grid.length; i++) {
                // dp[i][j]=dp[i+1][j-1]+1;
                // dp[i][j]=dp[i][j-1]+1;
                // dp[i][j]=dp[i-1][j-1]+1;
                if ((dp[i][j - 1] == 1 && grid[i][j] > grid[i][j - 1]) || (i - 1 > -1 && dp[i - 1][j - 1] == 1 && grid[i][j] > grid[i - 1][j - 1]) || (i + 1 < m && dp[i + 1][j - 1] == 1 && grid[i][j] > grid[i + 1][j - 1])) {
                    dp[i][j] = 1;
                    res = j;
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        new Solution().maxMoves(new int[][]{{187, 167, 209, 251, 152, 236, 263, 128, 135}, {267, 249, 251, 285, 73, 204, 70, 207, 74}, {189, 159, 235, 66, 84, 89, 153, 111, 189}, {120, 81, 210, 7, 2, 231, 92, 128, 218}, {193, 131, 244, 293, 284, 175, 226, 205, 245}});
    }
}