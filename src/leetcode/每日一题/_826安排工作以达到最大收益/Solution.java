package leetcode.每日一题._826安排工作以达到最大收益;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] worth = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            worth[i][0] = difficulty[i];
            worth[i][1] = profit[i];
        }
        Arrays.sort(worth, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
        Arrays.sort(worker);
        int res = 0;
        int difIndex = difficulty.length - 1;
        int best = 0;

        for (int i=worker.length-1;i>=0;i--) {
            while (difIndex<difficulty.length && worker[i]>= worth[difIndex][0]) {
                best = Math.max(best, worth[difIndex][1]);
                difIndex++;
            }
            res += best;
        }
        return res;
    }
}