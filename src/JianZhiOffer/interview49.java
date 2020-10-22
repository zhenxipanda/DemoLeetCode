package JianZhiOffer;

/**
 * 剑指offer 49
 * 题意：我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 * 思路：创建大小为n的数组，三个移动下标，i,j,k,
 *      找三个数中最小的，并且如果值相等，下标++，注意是三个if，不是if-else if-else
 *      81.85% , 15.15%
 */
public class interview49 {
    public static void main(String[] args) {
        int n = 10;
        int res = nthUglyNumber(n);
        System.out.println(res);
    }
    public static int nthUglyNumber(int n){
        if(n <= 1){
            return 1;
        }
        int[] nums = new int[n];
        int i = 0, j = 0 , k = 0;
        nums[0] = 1;
        for(int p = 1; p < n ; p ++){
            nums[p] = Math.min(Math.min(2 * nums[i] , 3 * nums[j]) , 5 * nums[k]);
            if(nums[p] == 2 * nums[i]){
                i ++ ;
            }
            if(nums[p] == 3 * nums[j]){
                j ++ ;
            }
            if(nums[p] == 5 * nums[k]){
                k ++ ;
            }
        }
        return nums[n - 1];
    }
}
