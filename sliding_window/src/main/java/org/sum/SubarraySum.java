
// problem link on leetcode : https://leetcode.com/problems/subarray-sum-equals-k/
package org.sum;

import java.util.HashMap;

public class SubarraySum {

    void main() {
        int[] nums = {-1,-1,1} ;
        int k = 0;
        System.out.println(subarraySum(nums,k));
    }

    public int subarraySum(int[] nums, int k) {

        int currentSum = 0 ;
        int result = 0 ;
        HashMap<Integer,Integer> prefixSum = new HashMap<>();

        prefixSum.put(0,1);

        for(int i = 0 ; i < nums.length ; i++){
            currentSum+=nums[i];
            int target = currentSum - k ;

            if(prefixSum.containsKey(target)){
                result+= prefixSum.get(target);
            }
            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum,0)+1);
        }
        return result;
    }
    // this solution have problems with negative numbers!
    public int subarraySum_(int[] nums, int k) {

        int currentSum = 0 ;
        int result = 0 ;
        int lastOutIndex = 0;
        for(int i = 0 ; i < nums.length ; i++){

            currentSum+=nums[i];

            if(currentSum == k)
                result++;
            else
                while (currentSum >= k) {
                    if(currentSum == k){
                        result++;
                        break;
                    }
                    if(lastOutIndex <= i)
                        currentSum-=nums[lastOutIndex++];

                }
        }
        return result;
    }
}
