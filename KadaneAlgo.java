public class KadaneAlgo {
    public static void maxSubArraySum(int a[]) {
        int n = a.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        //brute force TC = O(n^3)
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                currSum = 0;
                for(int k=i; k<=j; k++) {
                    currSum += a[k];
                }
                if(currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        //prefix sum approach TC = O(N^2)
        int prefix[] = new int[n];
        prefix[0] = a[0]; //first element will be the same for both
        //calculate the prefix array
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + a[i];
        }
        //calculate the maxSum with the help of prefix_arr
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(i==0) {
                    currSum = prefix[j];
                }
                else {
                    currSum = prefix[j] - prefix[i-1];  //formula
                }
                if(currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        //Kadane's Algo TC = O(n)
        for(int i=0; i<n; i++) {
            //calculate the curr sum
            currSum += a[i];
            //check if it is maxsum or not
            if(currSum > maxSum) {
                maxSum = currSum;
            }
            //if it is less than 0, reset it to 0
            //NOTE: do not do this step before the previous one as it will not run for negative array
            if(currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println("Max Sum: "+maxSum);
    }
    public static void main(String[] args) {
        int a[] = {1, -2, 6, -1, 3};
        //int a[] = {-1, -2, -3, -4, -5};
        maxSubArraySum(a);
    }
}