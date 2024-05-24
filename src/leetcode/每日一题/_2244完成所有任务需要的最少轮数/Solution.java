package leetcode.每日一题._2244完成所有任务需要的最少轮数;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> taskMap = new HashMap();
        for (int task : tasks) {
            taskMap.put(task, taskMap.getOrDefault(task, 0) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> it = taskMap.entrySet().iterator();
        int sum = 0;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            int curValue = entry.getValue();
            while (curValue != 0) {
                if (curValue == 1) {
                    return -1;
                }
                if (curValue - 3 >= 2) {
                    curValue -= 3;
                    sum++;
                    continue;
                } else {
                    curValue -= 2;
                    sum++;
                    continue;
                }
            }
        }
        return sum;

    }
}