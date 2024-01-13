package leetcode.每日一题._2182构造限制重复的字符串;

public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
            int[] nums = new int[26];
            for (char c : s.toCharArray()) {
                nums[c - 'a']++;
            }
            StringBuilder sb=new StringBuilder();
            int m=0;
            for(int i=25,j=24;i>=0&&j>=0;){
                if(nums[i]==0){
                    m=0;
                    i--;
                }
                else if(m<repeatLimit){
                    nums[i]--;
                    sb.append((char)(i+'a'));
                    m++;
                }
                else if(j>=i||nums[j]==0){
                    j--;
                }else{
                    nums[j]--;
                    sb.append((char)('a'+j));
                    m=0;
                }
            }
            return sb.toString();

    }


    public static void main(String[] args) {
        new Solution().repeatLimitedString("cczazcc",3);
    }
}