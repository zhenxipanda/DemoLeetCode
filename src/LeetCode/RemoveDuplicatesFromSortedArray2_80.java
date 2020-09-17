package LeetCode;

/**
 * LeetCode 80
 * 题意：给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 思路：关键是统计重复元素的个数，两个指针控制，right负责向右遍历，
 *      left负责控制不超过两次的元素下标
 *      97.44% , 11.22%
 */
public class RemoveDuplicatesFromSortedArray2_80 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3,3};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }
    public static int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 1 , right = 1 , count = 1;
        for(; right < nums.length ; right ++){
            if(nums[right] == nums[right - 1]){
                count ++ ;
            }
            else{
                count = 1;
            }
            if(count <= 2){
                nums[left ++] = nums[right];
            }
        }
        return left;
    }
}
