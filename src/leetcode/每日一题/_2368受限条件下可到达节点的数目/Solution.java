package leetcode.每日一题._2368受限条件下可到达节点的数目;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer>[] g;
    boolean[] r;
    int res = 0;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        g = new List[n];
        r = new boolean[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        for (int restrict : restricted) {
            r[restrict] = true;
        }

        dfs(g, r, -1, 0);
        return res;
    }

    void dfs(List<Integer>[] g, boolean[] r, int cur, int next) {
        res++;
        for (int gi : g[next]) {
            if (gi != cur && !r[gi]) {
                dfs(g, r, next, gi);
            }
        }

    }

    public static void main(String[] args) {
        new Solution().reachableNodes(7, new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}}, new int[]{4, 5});
    }
}