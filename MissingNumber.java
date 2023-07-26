public class MissingNumber {
    //using the n(n+1)/2 method
    public static void findMissingNumber(int arr[], int n) {
        int size = arr.length;
        int sum = (n*(n+1))/2;
        int currSum = 0;
        for(int i=0; i<size; i++) {
            currSum += arr[i];
        }
        int missingNum = sum - currSum;
        System.out.println(missingNum);
    }
    //using the xor method
    public static void findMissingNumber(int arr[], int n) {
        int size = arr.length;
        int xor1 = 0;
        int xor2 = 0;
        for(int i=0; i<size; i++) {
            xor1 ^= arr[i];
            xor2 ^= (i+1);
        }
        xor2 ^= n;
        int missingNum = xor1 ^ xor2;
        System.out.println(missingNum);
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 6};
        findMissingNumber(arr, 6);
    }
}