package leetcode.每日一题._1604警告一小时内使用相同员工卡大于等于三次的人;

import java.util.*;

public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int size = keyName.length;
        Map<String, List<String>> nameTimeMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            List<String> timeList = nameTimeMap.get(keyName[i]);
            if (timeList == null) {
                timeList = new ArrayList();
            }
            timeList.add(keyTime[i]);
            nameTimeMap.put(keyName[i], timeList);
        }
        List<String> result = new ArrayList();
        for (Map.Entry<String, List<String>> entrySet : nameTimeMap.entrySet()) {
            String name = entrySet.getKey();
            List<String> times = entrySet.getValue();
            Collections.sort(times);
            if (match(times)) {
                result.add(name);
            }
        }
        Collections.sort(result);
        return result;
    }

    public boolean match(List<String> times) {
        if (times == null || times.size() < 3) {
            return false;
        }
        for (int i = 0; i <= times.size() - 3; i++) {
            String former = times.get(i);
            String latter = times.get(i + 2);
            int formerHour = Integer.valueOf(former.split(":")[0]);
            int latterHour = Integer.valueOf(latter.split(":")[0]);
            int formerMin = Integer.valueOf(former.split(":")[1]);
            int latterMin = Integer.valueOf(latter.split(":")[1]);
            if (latterHour == formerHour || (latterHour - formerHour == 1 && latterMin <= formerMin)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] keyName = {"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"};
        String[] keyTime = {"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"};
        new Solution().alertNames(keyName, keyTime);
    }
}