package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 283
 * 题意：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 思路：只能在原数组上操作，而且要保证先后顺序不变
 *      扫描一遍数组，遇到不为0的元素，就对index下标元素进行覆盖，
 *      用index控制下一个将要被覆盖的元素，
 *      最后将数组后面补充0，即新值赋为0,
 *      100% , 5.62%
 */
public class MoveZeroes283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0;i < nums.length; i ++){
            // 找到值不为0的元素，将其复制到Index下标下
            if(nums[i] != 0){
                nums[index] = nums[i];
                // index 后移
                index ++;
            }
        }
        // 将数组后面部分置为0
        for(int i = index; i < nums.length; i ++){
            nums[i] = 0;
        }
    }
}
