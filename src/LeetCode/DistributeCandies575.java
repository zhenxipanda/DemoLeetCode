package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 575
 * 题意：
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 * 示例 1:
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 *      最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 * 示例 2 :
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 * 注意:
 * 数组的长度为[2, 10,000]，并且确定为偶数。
 * 数组中数字的大小在范围[-100,000, 100,000]内。
 * 思路：偶数长度，两个人平均分，每人得到n/2个糖果，
 *      如果不同的糖果种类数 >= n / 2，也是n/2种
 *      如果不同的糖果种类数 < n / 2，那就是糖果种类数，
 *      所以关键是求出糖果的种类数，没有必要用Map计算每种多少个
 *      可以用set存储种类数
 *      63.76% , 13.40%
 */
public class DistributeCandies575 {
    public static void main(String[] args) {
        int[] candies = {2,1,1,3,1,4};
        int res = distributeCandies(candies);
        System.out.println(res);
    }
    public static int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for(int can : candies){
            set.add(can);
        }
        return Math.min(candies.length >> 1 , set.size());
    }
}
