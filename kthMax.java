import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] temp_array = new int[k + 1];
        Arrays.fill(temp_array, -10001);
        for (int num : nums) {
            if (num > temp_array[1]) {
                temp_array = addHeap(temp_array, num);
            }
        }
        System.out.println(Arrays.toString(temp_array));
        return temp_array[1];
    }

    private int[] addHeap (int[] arr, int num) {
        arr[1] = num;
        int i = 1;
        int swapIndex;
        int temp;
        while (2 * i < arr.length) {
            swapIndex = 2 * i;
            if ((2 * i) + 1 < arr.length && arr[(2 * i) + 1] < arr[2 * i]) {
                swapIndex = (2 * i) + 1;
            } 
            
            if (arr[swapIndex] < arr[i]) {
                temp = arr[swapIndex]; 
                arr[swapIndex] = arr[i];
                arr[i] = temp;
                i = swapIndex;
            } else {
                break;
            }
        }
        return arr;
    }
}