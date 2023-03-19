package leetcode.每日一题._1233删除子文件夹;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> str;
        str = new ArrayList();
        for(int i=0;i<folder.length;i++){
            str.add(folder[i]);
        }
        List<String> result=new ArrayList();
        for(int i=0;i<folder.length;i++){
            for(int j=i+1;j<folder.length;j++){
                /**
                if(str.get(i).(str.get(j))){
                    continue;
                }
                 */
            }
            result.add(str.get(i));
        }
        return result;
    }
}