package Sort;

import java.util.Arrays;

/***
 * 冒泡排序，稳定排序，时间复杂度评价O(N^2)，最好O(N)，因为设置了有序判断，空间O(1)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3,2,4,2,5,1};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {
        if(nums == null || nums.length < 2){
            return ;
        }
        boolean stop = true;
        for(int i = 0;i < nums.length - 1;i ++){
            stop = true;
            for(int j = 0; j < nums.length - i - 1; j ++){
                if(nums[j] > nums[j + 1]){   //有逆序的，设置标记位
                    stop = false;
                    swap(nums , j ,j + 1);
                }
            }
            if(stop){   //当前数组中没有逆序对了，数组已有序，可以停止遍历
                break;
            }
        }
    }

    private static void swap(int[] nums, int j, int i) {
        int k = nums[j];
        nums[j] = nums[i];
        nums[i] = k;
    }
}
