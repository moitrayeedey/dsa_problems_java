import java.util.Stack;
public class MaxAreaHistogram {
    public static int findmaxArea(int height[]) {
        //initialize the maxArea as 0 
        int maxArea = 0;
        //helper array for next smaller right
        int nsr[] = new int[height.length];
        //helper array for next smaller left
        int nsl[] = new int[height.length];

        //finding next smaller right
        Stack<Integer> s = new Stack<>();
        //start from the back
        for(int i = height.length-1; i>=0; i--) {
            //until the stack is empty and top >= current value, pop the top
            while(!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            //if the stack is empty, assign the value as the length of array
            if(s.isEmpty()) {
                nsr[i] = height.length;
            }
            //else the index of the next smaller element
            else {
                nsr[i] = s.peek();
            }
            //lastly push the index value to the stack
            s.push(i);
        }

        //finding next smaller left
        s = new Stack<>();
        //start from the front
        for(int i = 0; i<height.length; i++) {
            //until the stack is empty and top >= current value, pop the top
            while(!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            //if the stack is empty, assign the value as -1
            if(s.isEmpty()) {
                nsl[i] = -1;
            }
            //else the index of the next smaller element
            else {
                nsl[i] = s.peek();
            }
            //lastly push the index value to the stack
            s.push(i);
        }
        //finding current area
        for(int i=0; i<height.length; i++) {
            int length = height[i];
            //formula for width:
            int width = nsr[i] - nsl[i] - 1;
            //calculate the current area and compare it with the maxArea
            int currArea = length * width;
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int height[] = {2,1,5,6,2,3};
        System.out.println(findmaxArea(height));
    }
}