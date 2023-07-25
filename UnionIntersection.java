import java.util.HashSet;

public class UnionIntersection {
    //find the union of the two arrays
    public static void printUnion(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:arr1) {
            set.add(i);
        } 
        for(int i:arr2) {
            set.add(i);
        }
        for(int x: set) {
            System.out.print(x+" ");
        }
        System.out.println();
    }
    //find the intersection of two arrays
    public static void printIntersection(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:arr1) {
            set.add(i);
        } 
        for(int i:arr2) {
            if(set.contains(i)) {
                System.out.print(i+" ");
                set.remove(i);
            }
        }
    }
    public static void main(String[] args) {
    int arr1[] = {1, 2, 3, 3, 5};
    int arr2[] = {3, 4, 5, 5, 7};
    printUnion(arr1, arr2);
    printIntersection(arr1, arr2);
    }
}