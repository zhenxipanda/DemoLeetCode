package JianZhiOffer;

/**
 * 剑指offer 39
 * 题意：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * 限制：
 * 1 <= 数组长度 <= 50000
 * 思路：与 LeetCode 169 相同
 *      比较简单，通过time计算出现多的元素，
 *      99.94% , 93.31%
 */
public class interview39 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,1,5,2};
        int res = majorityElement(nums);
        System.out.println(res);
    }
    public static int majorityElement(int[] nums) {
        int res = nums[0];
        int time = 1;
        for(int i = 1;i < nums.length; i ++){
            if(nums[i] == res){
                time ++;
            }
            else{
                time --;
            }
            if(time == 0){
                res = nums[i];
                time = 1;
            }
        }
        return res;
    }
}
