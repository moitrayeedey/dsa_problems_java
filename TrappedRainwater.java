public class TrappedRainwater {
    public static int calculateRainwater(int height[], int n) {
        //calculate the left max boundary
        int[] leftMax = new int[n];
        //element at the 0th index will be the same as our height[0]
        leftMax[0] = height[0];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        //calculate the right max boundary
        int[] rightMax = new int[n];
        //element at the (n-1)th index will be the same as our height[n-1]
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        //calculate the trapped rainwater
        int trappedWater = 0;
        for(int i=0; i<n; i++) {
            //if we take maximum, the excess water will spill. Hence we'll take the minimum of the boundaries
            int waterlevel = Math.min(leftMax[i], rightMax[i]);
            //water is stored above the bar. so waterlevel is basically the original waterlevel + height[i]
            trappedWater += waterlevel - height[i];
        }
        return trappedWater;
    }
    public static void main(String[] args) {
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        int n = height.length;
        System.out.println(calculateRainwater(height, n));
    }
}