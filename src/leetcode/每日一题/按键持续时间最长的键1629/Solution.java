package leetcode.每日一题.按键持续时间最长的键1629;

public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] keys = keysPressed.toCharArray();
        char result = keys[0];
        int curMax = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] > curMax || (releaseTimes[i] - releaseTimes[i - 1] == curMax && keys[i] > result)) {
                result = keys[i];
                curMax = releaseTimes[i] - releaseTimes[i - 1];
            }
        }
        return result;

    }
}
