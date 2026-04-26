package org.sum;

public class MaxSum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 10, 25, 3, 5, 0, 26};
        int k = 4;


        Long result = getMaxSum(arr, k);

        if (result != null) {
            System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
        } else {
            System.out.println("Invalid input: Array length is less than k.");
        }
    }


    static Long getMaxSum(int[] arr, int k) {
        // Edge Case: التأكد من أن طول المصفوفة كافٍ
        if (arr == null || arr.length < k || k <= 0) {
            return null;
        }

        long currentSum = 0;

        //  (First Window)
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }

        long maxSum = currentSum;

         for (int i = k; i < arr.length; i++) {
            currentSum = currentSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}