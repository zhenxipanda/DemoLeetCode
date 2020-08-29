package LeetCode;

/**
 * LeetCode 11
 * 题意：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 思路：左右两个指针扫描，当前水量就是最短者*宽度，谁小移动谁
 *      92.66% , 24.47%
 */
public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(height);
        System.out.println(res);
    }
    public static int maxArea(int[] height) {
        int left = 0 , right = height.length - 1;
        int res = 0;
        while(left < right){
            int min = height[left] < height[right] ? height[left] : height[right];
            res = Math.max(res , min * (right - left));
            if(height[left] < height[right]){
                left ++ ;
            }
            else{
                right -- ;
            }
        }
        return res;
    }
}
