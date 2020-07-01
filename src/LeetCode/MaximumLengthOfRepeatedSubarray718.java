package LeetCode;

/**
 * LeetCode 718
 * 题意：
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例 1:
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * 思路：对齐的方式有两类：第一类为 A 不变，B 的首元素与 A 中的某个元素对齐；
 *      第二类为 B 不变，A 的首元素与 B 中的某个元素对齐。
 *      对于每一种对齐方式，我们计算它们相对位置相同的重复子数组即可。
 *      76.36% , 100.00%
 */
public class MaximumLengthOfRepeatedSubarray718 {
    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        int res = findLength(A , B);
        System.out.println(res);
    }
    public static int findLength(int[] A, int[] B) {
        int n = A.length , m = B.length;
        int res = 0 , len = 0;
        //每次都用B的开始(0)去比较A的遍历元素(0,1,2...)
        for(int i = 0;i < n; i ++){
            len = Math.min(m , n - i);
            int maxLen = maxLength(A , B , i , 0 , len);
            res = Math.max(maxLen , res);
        }
        //每次都用A的开始(0)去比较B的遍历元素(0,1,2...)
        for(int i = 0;i < m; i ++){
            len = Math.min(n , m - i);
            int maxLen = maxLength(A , B ,0 , i , len);
            res = Math.max(maxLen , res);
        }
        return res;
    }
    public static int maxLength(int[] A , int[] B , int s1 , int s2 , int len){
        int res = 0 , k = 0;
        for(int i = 0;i < len ; i ++){
            if(A[s1 + i] == B[s2 + i]){
                k ++;
            }
            else{ //因为是连续的，所以k = 0
                k = 0;
            }
            res = Math.max(res , k);
        }
        return res;
    }
}
