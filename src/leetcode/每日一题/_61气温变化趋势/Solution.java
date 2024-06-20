package leetcode.每日一题._61气温变化趋势;

public class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        for (int i = temperatureA.length - 1; i >= 1; i--) {
            if (temperatureA[i] > temperatureA[i - 1]) {
                temperatureA[i] = 2;
            } else if (temperatureA[i] == temperatureA[i - 1]) {
                temperatureA[i] = 1;
            } else {
                temperatureA[i] = 0;
            }

            if (temperatureB[i] > temperatureB[i - 1]) {
                temperatureB[i] = 2;
            } else if (temperatureB[i] == temperatureB[i - 1]) {
                temperatureB[i] = 1;
            } else {
                temperatureB[i] = 0;
            }

        }

        for (int i = temperatureA.length - 1; i >= 1; i--) {
            temperatureA[i] -= temperatureB[i];
        }
        temperatureA[0] = -1;
        //
        int res = 0;
        int i = 1;
        int count = 0;
        while (i < temperatureA.length) {
            if (temperatureA[i] == 0) {
                count++;
                res = Math.max(count, res);
            } else {
                count = 0;
            }
            i++;
        }
        return res;

    }

    public static void main(String[] args) {
        new Solution().temperatureTrend(new int[]{21, 18, 18, 18, 31}, new int[]{34, 32, 16, 16, 17});
    }
}