package org.sum;

public class SubarraySumTarkgetK {
    static void main() {
        int[] nums = {2,3,2,2,3,1,3,8,5,0,2,4};
        int target = 7 ;
        int k = 3;

        System.out.println(subarraySum(nums,target,k));

    }
    public static int subarraySum(int[] nums, int target ,int k) {

        int currentSum = 0 ;
        for (int i = 0 ; i <  k ; i++){
            currentSum+=nums[i];
        }
        int count = (currentSum==target) ? 1 : 0;

        for (int i = k ; i < nums.length ; i++){
            currentSum-=nums[i-k];
            currentSum+=nums[i];
            if(currentSum == target)
                count++;
        }
        return count;
    }
}
