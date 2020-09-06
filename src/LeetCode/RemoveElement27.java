package LeetCode;

/**
 * LeetCode 27
 * 题意：给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 思路：与26的思路大致相同，双指针，一个遍历，一个记录新下标
 *      100% , 94.66%
 */
public class RemoveElement27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int res = removeElement(nums , val);
        System.out.println(res);
    }
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int index = 0;
        for(int i = 0; i < nums.length ; i ++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index ++ ;
            }
        }
        return index ;
    }
}
