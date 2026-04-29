package org.sum;

public class maxProduct {

    static void main() {
        int [] arr = {1,4,1,6,-3,3,-5,2,26};
        int k = 4 ;
        Long result = getMaxProduct(arr, k);

        if (result != null) {
            System.out.println("Maximum product of subarray of size " + k + " is: " + result);
        } else {
            System.out.println("Invalid input: Array length is less than k.");
        }

        int [] arrWithZeros = {1,0,2,3,4,0};
        int k2 = 3 ;
        Long result2 = getMaxProductWithZeros(arrWithZeros, k2);
        System.out.println("Testing getMaxProductWithZeros and result2 is  "+ result2);
    }
    // assume the array doesn't have zeros
    public static Long getMaxProduct(int[] arr, int k){
        if (arr == null || arr.length < k || k <= 0) {
            return null;
        }

        long currentProduct = 1;
        for(int i = 0 ; i < k ; i++)
            currentProduct *= arr[i];
        long maxProduct = currentProduct;
        for (int i = 0 ;i < arr.length-k ; i++){
            currentProduct/=arr[i];
            currentProduct*=arr[k+i];
            maxProduct = Math.max(maxProduct, currentProduct);
        }

        return maxProduct;
    }
    public static Long getMaxProductWithZeros(int[] arr, int k){
        if (arr == null || arr.length < k || k <= 0) {
            return null;
        }
        int zeroCount=0;
        long currentProductWithoutZeros = 1;
        long maxProduct = Long.MIN_VALUE;
        // first window
        for(int i = 0 ; i < k ; i++){
            if(arr[i]==0)
                zeroCount++;
            else
                currentProductWithoutZeros*=arr[i];
        }

        maxProduct = zeroCount > 0 ? 0 : Math.max(maxProduct,currentProductWithoutZeros) ;

        for (int i = k; i < arr.length ; i++){
           int incoming = arr[i];
           int outcoming = arr[i-k];

           if(incoming == 0)
               zeroCount++;
           else
                currentProductWithoutZeros*=incoming;

           if(outcoming == 0)
               zeroCount --;
           else
               currentProductWithoutZeros/=outcoming;
           long currentWindowValue = zeroCount > 0 ? 0 : currentProductWithoutZeros;
           maxProduct = Math.max(maxProduct,currentWindowValue);

        }

        return maxProduct;
    }
}
