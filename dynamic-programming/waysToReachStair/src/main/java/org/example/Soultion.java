package org.example;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, Integer> memo = new HashMap<>();
    int target ;
    public int waysToReachStair(int k) {
        this.target = k;
        this.memo.clear();
        return solve(1,0, true);
    }

    public int solve(int i , int jump , boolean canDown){
//        Base case
        if(i > target+1) return 0;

        String key = i + "," + jump + "," + canDown;
        if(memo.containsKey(key))
            return memo.get(key);
        int count = (i == target) ? 1 : 0;

        if(canDown&&i > 0){

            count +=solve(i-1,jump,false);
//            memo.put(key,count);
        }
        int nextStair = (int) (i+ Math.pow(2,jump));
        count += solve(nextStair, jump+1,true);
        memo.put(key, count);
        return count;
    }
     void main() {
         System.out.println(waysToReachStair(1));
    }
}