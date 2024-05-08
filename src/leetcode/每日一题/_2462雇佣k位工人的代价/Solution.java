package leetcode.每日一题._2462雇佣k位工人的代价;

import java.util.PriorityQueue;

public class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long res = 0;
        boolean[] visited = new boolean[n];
        int selected = 0;
        PriorityQueue<int[]> pqLeft = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> pqRight = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < candidates; i++) {
            pqLeft.add(new int[]{costs[i], i});
        }
        int rightIndex = Math.max(candidates - 1, n - 1 - candidates);
        for (int i = n - 1; i > rightIndex; i--) {
            pqRight.add(new int[]{costs[i], i});
        }
        int leftLast = candidates - 1;
        int rightBegin = n - candidates;
        while (k > 0) {
            if (n - selected < candidates) {
                res += findRemaining(costs, visited);
            } else {
                int[] left = pqLeft.size() == 0 ? new int[]{-1, -1} : pqLeft.peek();
                int[] right = pqRight.size() == 0 ? new int[]{-1, -1} : pqRight.peek();
                if (left[0] == -1 && right[0] == -1) {
                    res += findRemaining(costs, visited);
                } else if (left[0] != -1 && right[0] != -1) {
                    if (left[0] <= right[0]) {
                        pqLeft.poll();
                        visited[left[1]] = true;
                        res += left[0];
                        if (leftLast < n - 1 && leftLast < rightBegin) {
                            pqLeft.add(new int[]{costs[++leftLast], leftLast});
                        }
                    } else {
                        pqRight.poll();
                        visited[right[1]] = true;
                        res += right[0];
                        if (rightBegin > 0 && leftLast < rightBegin) {
                            pqRight.add(new int[]{costs[--rightBegin], rightBegin});

                        }
                    }
                } else if (left[0] == -1 && right[0] != -1) {
                    pqRight.poll();
                    visited[right[1]] = true;
                    res += right[0];
                    if (rightBegin > 0 && leftLast < rightBegin) {
                        pqRight.add(new int[]{costs[--rightBegin], rightBegin});

                    }
                } else {
                    pqLeft.poll();
                    visited[left[1]] = true;
                    res += left[0];
                    if (leftLast < n - 1 && leftLast < rightBegin) {
                        pqLeft.add(new int[]{costs[++leftLast], leftLast});

                    }

                }
            }
            k--;
            selected++;

        }
        return res;

    }

    int findRemaining(int[] costs, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int select = -1;
        for (int i = 0; i < costs.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (min > costs[i]) {
                min = costs[i];
                select = i;
            }
        }
        visited[select] = true;
        return costs[select];
    }

    public static void main(String[] args) {

        new Solution().totalCost(new int[]{28, 35, 21, 13, 21, 72, 35, 52, 74, 92, 25, 65, 77, 1, 73, 32, 43, 68, 8, 100, 84, 80, 14, 88, 42, 53, 98, 69, 64, 40, 60, 23, 99, 83, 5, 21, 76, 34}, 32, 12);
    }
}