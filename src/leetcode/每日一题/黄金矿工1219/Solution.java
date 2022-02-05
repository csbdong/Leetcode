package leetcode.每日一题.黄金矿工1219;

public class Solution {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int[][] grid;
    int row;
    int col;
    int result = 0;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    dfs(i, j, 0);
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, int gold) {
        gold+=grid[i][j];
        result=Math.max(result,gold);
        int curGold=grid[i][j];
        grid[i][j]=0;
        for(int k=0;k<4;k++){
            int nx=i+dir[k][0];
            int ny=j+dir[k][1];
            if(nx>=0&&nx<row&&ny>=0&&ny<col&&grid[nx][ny]!=0){
                dfs(nx,ny,gold);
            }
        }
        grid[i][j]=curGold;
    }
}
