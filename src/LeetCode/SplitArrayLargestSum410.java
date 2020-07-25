package LeetCode;

/**
 * LeetCode 410
 * 题意：
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 思路：比较难
 *      各自和的最大值在[数组最大值，数组总和]之间
 *      用这两者为边界进行二分，中间值为 mid ，统计连续和大于 mid的子数组个数 cnt
 *      如果个数大于 m ，说明分组分多了，mid值偏小了，所以移动左边界
 *      否则，说明分组说了，mid值偏大或正好，移动右边界，right = mid，not mid - 1
 *      72.72% , 33.33%
 */
public class SplitArrayLargestSum410 {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 3;
        int res = splitArray(nums , m);
        System.out.println(res);
    }
    public static int splitArray(int[] nums, int m) {
        // sum 为数组和 ，left 为数组最大值，long 防止int 越界
        long sum = 0 , left = nums[0];
        for(int i = 0;i < nums.length;i ++){
            sum += nums[i];
            left = (left > nums[i]) ? left : nums[i];
        }
        // 进行二分
        while(left < sum){
            // 计算中间值，需要long
            long mid = (left + sum) >> 1;
            // 连续和 tmp 存储
            long tmp = 0;
            // 连续和大于 mid 的子数组个数，初始为1，因为整个数组总和一定大于 mid
            int cnt = 1;
            for(int num : nums){
                tmp += num;
                if(tmp > mid){
                    cnt ++;
                    // 更新 tmp ,从当前位置开始重新记录连续和
                    tmp = num;
                }
            }
            // 分组多了，移动左边界
            if(cnt > m){
                left = mid + 1;
            }
            // 分组少了，移动右边界，注意不是mid - 1，，因为mid 可能是最优解
            else{
                sum = mid;
            }
        }
        return (int)left;
    }
}
