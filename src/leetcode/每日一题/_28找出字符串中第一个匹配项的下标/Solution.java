package leetcode.每日一题._28找出字符串中第一个匹配项的下标;

public class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        if(m==0){
            return 0;
        }
        if(n<m){
            return -1;
        }
        int[] next=new int[needle.length()];
        getNext(next,needle);
        int j=0;
        int i=0;
        while(i<n&&j<m){
            if(j==-1||haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }
        }
        if(j==m){
            return i-j;
        }
        return -1;
    }

    void getNext(int[] next,String s){
        next[0]=-1;
        int k=-1;
        int j=0;
        while(j<s.length()-1){
            if(k==-1||s.charAt(j)==s.charAt(k)){
                k++;
                j++;
                next[j]=k;
            }
            else{
                k=next[k];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi","issip"));
    }
}
