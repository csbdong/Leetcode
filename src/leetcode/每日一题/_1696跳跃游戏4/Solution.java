package leetcode.每日一题._1696跳跃游戏4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution {
    public int maxResult(int[] nums, int k) {
//        int[] score = new int[nums.length];
//        score[0] = nums[0];
//        int current = Integer.MIN_VALUE;
//        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        queue.add(score[0]);
//        for (int i = 1; i < nums.length; i++) {
//            int beginIndex = Math.max(0, i - k);
//            for (int j = 0; j < beginIndex; j++) {
//                if (queue.peek() == score[j]) {
//                    queue.poll();
//                }
//            }
//            score[i] = queue.peek() + nums[i];
//            queue.add(score[i]);
//        }
//        return score[nums.length - 1];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int current = Integer.MIN_VALUE;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(0);
        for (int i = 1; i < nums.length; i++) {
            while (queue.peekFirst() < i - k) {
                queue.pollFirst();
            }
            dp[i] = dp[queue.peekFirst()] + nums[i];
            while (!queue.isEmpty() && dp[queue.peekLast()] < dp[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return dp[nums.length - 1];
    }


    public static void main(String[] args) {
        new Solution().maxResult(new int[]{40, 30, -100, -100, -10, -7, -3, -3}, 2);
    }
}