package leetcode.hot100._56合并区间;

import java.util.*;

public class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            StringBuilder sb;
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        ArrayList<int[]> list = new ArrayList();
        int curLeft = intervals[0][0];
        int curRight = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (curRight < intervals[i][0]) {
                list.add(new int[] { curLeft, curRight });
                curLeft = intervals[i][0];
                curRight = intervals[i][1];
            } else {
                curRight = Math.max(curRight, intervals[i][1]);
            }
        }
        if (list.size() == 0 || list.get(list.size() - 1)[0] != curLeft || list.get(list.size() - 1)[1] != curRight) {
            list.add(new int[] { curLeft, curRight });
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;

    }

        public static void main(String[] args) {
        int[][] src=new int[][]{{1,4},{0,4}};
        new Solution().merge(src);
    }
}
