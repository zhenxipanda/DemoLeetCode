package LeetCode;

import java.util.*;

/**
 * LeetCode 347
 * 题意：
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * 思路：使用HashMap 统计每个元素出现的次数
 *      然后用 List[]存储出现次数为xx的元素有哪些，list[3] -> {1}，代表出现次数为3的有元素1
 *      从List[]尾部开始遍历，这样得到的就是出现次数最多的，
 *      然后向res[]中添加k个元素，添加到k个之后，就得到了前K个高频，即返回
 *      98.29% , 94.77%
 */
public class TopKFrequentElements347 {
    public static void main(String[] args) {
       int[] nums = {1,1,1,2,2,2,3};
       int k = 2;
       int[] res = topKFrequent(nums , k);
        System.out.println(Arrays.toString(res));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        List<Integer>[] list = new List[nums.length + 1];
        for(int i = 0;i < nums.length + 1 ; i ++){
            list[i] = new ArrayList<>();
        }
        for(HashMap.Entry<Integer, Integer> entry: map.entrySet()){
            list[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int m = 0;
        for(int i = nums.length ; i >= 0 ; i --){
            if(list[i].size() != 0){
                for(int j = 0;j < list[i].size() ; j ++){
                    res[m ++] = list[i].get(j);
                }

            }
            if(k == m){
                break;
            }
        }
        return res;
    }
}
