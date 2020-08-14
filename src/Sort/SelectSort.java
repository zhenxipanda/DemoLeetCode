package Sort;

import java.util.Arrays;

/***
 * 选择排序，非稳定，时间复杂度O(N^2)，空间复杂度O(1)
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {3,2,4,1,1,1};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void selectSort(int[] nums) {
        if(nums == null || nums.length < 2){
            return ;
        }
        int min = 0;
        for(int i = 0;i < nums.length - 1; i ++){
            min = i;
            for(int j = i + 1; j < nums.length; j ++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            swap(nums , min , i);
        }
    }

    private static void swap(int[] nums, int min, int i) {
        int n = nums[min];
        nums[min] = nums[i];
        nums[i] = n;
    }

}
