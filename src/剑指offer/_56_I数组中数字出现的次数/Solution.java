package 剑指offer._56_I数组中数字出现的次数;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int xOrY=nums[0];
        for(int i=1;i<nums.length;i++){
            xOrY^=nums[i];
        }
        int firstOnePosition=1;
        while((xOrY&firstOnePosition)==0){
            firstOnePosition=firstOnePosition<<1;
        }
        int left=0;
        int firstIndex=-1;
        for(int i=0;i<nums.length;i++){
            if((firstOnePosition&nums[i])>0){
                if(firstIndex>=0){
                    left^=nums[i];
                }else{
                    left=nums[i];
                    firstIndex=i;
                }
            }
        }
        int[] result=new int[2];
        result[0]=left;
        result[1]=xOrY^left;
        return result;
    }

    public static void main(String[] args) {
        new Solution().singleNumbers(new int[]{1,2,5,2});
    }
}