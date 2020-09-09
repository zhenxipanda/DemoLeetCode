package LeetCode;

/**
 * LeetCode 42
 * 题意：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 思路：左右各维护一个最大值，谁小谁动，
 *      左右指针要left <= right，因为中间位置还没有累加上
 *
 */
public class TrappingRainWater42 {
    public static void main(String[] args) {
        int[] height = {5,5,1,7,1,1,5,2,7,6};
        int res = trap(height);
        System.out.println(res);
    }
    public static int trap(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int left = 0 , right = height.length - 1;
        int maxLeft = height[left] , maxRight = height[right];
        int sum = 0;
        while (left <= right){
            if(maxLeft <= maxRight){
                maxLeft = Math.max(maxLeft , height[left]);
                sum += maxLeft - height[left];
                left ++ ;
            }
            else{
                maxRight = Math.max(maxRight , height[right]);
                sum += maxRight - height[right];
                right --;
            }
        }
        return sum;
    }
}
