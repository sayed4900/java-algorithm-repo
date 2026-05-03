package org.sum;

import java.util.HashMap;
// problem link : https://leetcode.com/problems/subarray-sum-equals-k/submissions/
public class FindSubarraySum {
    int [] nums = {-1,-1,1};
    int target = 0 ;

    public int subarraySum(int[] nums, int k) {
        int currentSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0 ; i < nums.length ; i++){
            currentSum+=nums[i];

            if(map.containsKey(currentSum - k)){
                count+=map.get(currentSum-k);
            }

            map.put(currentSum, map.getOrDefault(currentSum,0)+1);
        }
        return count;
    }

    void main() {
        System.out.println(subarraySum(nums,target));
    }
}
