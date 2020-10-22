package JianZhiOffer;

/**
 * 剑指offer 51
 * 题意：在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * 限制：
 * 0 <= 数组长度 <= 50000
 * 思路：比较难的一题，在二分排序的过程中记录逆序对的个数，
 *      分为组内个数和组间个数，
 *      97.93% ， 15.38%
 */
public class interview51 {
    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        int res = reversePairs(nums);
        System.out.println(res);
    }
    public static int reversePairs(int[] nums){
        if(nums.length < 2){
            return 0;
        }
        int[] tmp = new int[nums.length];
        int res = reverse(nums , 0 , nums.length - 1 , tmp);
        return res;
    }

    private static int reverse(int[] nums, int start, int end, int[] tmp) {
        if(start == end){
            return 0;
        }
        int mid = (start + end) >> 1;
        int left = reverse(nums , start , mid , tmp);
        int right = reverse(nums , mid + 1 , end , tmp);
        int re = left + right;
        if(nums[mid] <= nums[mid + 1]){
            return re;
        }
        int rg = mergeSort(nums , start , mid , end , tmp);
        return re + rg;
    }

    private static int mergeSort(int[] nums, int start, int mid, int end, int[] tmp) {
        int i = start , j = mid + 1;
        int res = 0;
        for(int k = start ; k <= end ; k ++){
            tmp[k] = nums[k];
        }
        for(int k = start ; k <= end ; k ++){
            if(i > mid){
                nums[k] = tmp[j];   // is tmp[j], not nums[j]
                j ++;
            }
            else if(j > end){
                nums[k] = tmp[i];
                i ++ ;
                res += end - mid;
            }
            else if(tmp[i] <= tmp[j]){
                nums[k] = tmp[i];
                i ++ ;
                res += j - mid - 1;
            }
            else{
                nums[k] = tmp[j];
                j ++ ;
            }
        }
        return res;
    }
}
