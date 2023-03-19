package leetcode.每日一题._6322检查骑士巡视方案;

import java.util.Arrays;

public class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int curRow = 0;
        int curCol = 0;
        for (int i = 0; i < n * n; i++) {
            int[][] curResult = {findOne(grid, i, curRow, curCol, 0, 0),findOne(grid, i, curRow, curCol, 1, 3), findOne(grid, i, curRow, curCol, 1, 4), findOne(grid, i, curRow, curCol, 2, 3), findOne(grid, i, curRow, curCol, 2, 4), findOne(grid, i, curRow, curCol, 3, 1), findOne(grid, i, curRow, curCol, 4, 1), findOne(grid, i, curRow, curCol, 3, 2), findOne(grid, i, curRow, curCol, 4, 2)};
            boolean findMatch = false;
            for (int j = 0; j < curResult.length; j++) {
                if (curResult[j][0] == 1) {
                    findMatch = true;
                    curRow=curResult[j][1];
                    curCol=curResult[j][2];
                }
            }
            if (!findMatch) {
                return false;
            }

        }
        return true;
    }


    //在当前位置决策下一步的走路（stepOne为2步，stepTwo为1步）
    //上下左右分别为1，2，3，4代表
    //返回result[0]=1 TRUE 0 FALSE result[1] curRow result[2] curCol
    public int[] findOne(int[][] grid, int beginNum, int rowIndex, int columnIndex, int stepOne, int stepTwo) {
        switch (stepOne) {
            case 1:
                if ((rowIndex - 2 < 0))
                    return new int[]{0, 0, 0};
                rowIndex -= 2;
                break;
            case 2:
                if ((rowIndex + 2 >= grid.length))
                    return new int[]{0, 0, 0};
                rowIndex += 2;
                break;
            case 3:
                if ((columnIndex - 2 < 0))
                    return new int[]{0, 0, 0};
                columnIndex -= 2;
                break;
            case 4:
                if ((columnIndex + 2 >= grid.length))
                    return new int[]{0, 0, 0};
                columnIndex += 2;
                break;
            default:
                break;
        }

        switch (stepTwo) {
            case 1:
                if ((rowIndex - 1 < 0))
                    return new int[]{0, 0, 0};
                rowIndex -= 1;
                return grid[rowIndex][columnIndex] == beginNum? new int[]{1, rowIndex, columnIndex} : new int[]{0, 0, 0};
            case 2:
                if ((rowIndex + 1 >= grid.length))
                    return new int[]{0, 0, 0};
                rowIndex += 1;
                return grid[rowIndex][columnIndex] == beginNum ? new int[]{1, rowIndex, columnIndex} : new int[]{0, 0, 0};
            case 3:
                if ((columnIndex - 1 < 0))
                    return new int[]{0, 0, 0};
                columnIndex -= 1;
                return grid[rowIndex][columnIndex] == beginNum? new int[]{1, rowIndex, columnIndex} : new int[]{0, 0, 0};
            case 4:
                if ((columnIndex + 1 >= grid.length))
                    return new int[]{0, 0, 0};
                columnIndex += 1;
                return grid[rowIndex][columnIndex] == beginNum ? new int[]{1, rowIndex, columnIndex} : new int[]{0, 0, 0};
            case 0:
                return grid[rowIndex][columnIndex] == beginNum? new int[]{1, rowIndex, columnIndex} : new int[]{0, 0, 0};
            default:
                return new int[]{0, 0, 0};
        }

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}

        };
        new Solution().checkValidGrid(grid);
    }
}