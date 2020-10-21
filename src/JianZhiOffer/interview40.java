package JianZhiOffer;
/**
 * 剑指offer 40
 * 题意：输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * 思路：可以使用partition 也可以使用容量为k的最大堆
 *      79.64% , 94.82%
 */

import java.util.Arrays;

public class interview40 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,1};
        int k = 1;
        int[] res = getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(res));
    }
    public static int[] getLeastNumbers(int[] arr, int k){
        if(arr.length == 0 || arr.length < k || k <= 0){
            return new int[0];
        }
        if(arr.length == k){
            return arr;
        }
        mypartition(arr , 0 , arr.length - 1 , k);
        int[] res = new int[k];
        for(int i = 0 ; i < k ; i ++){
            res[i] = arr[i];
        }
        return res;
    }

    private static void mypartition(int[] arr, int left, int right, int k) {
        int index = partition(arr , left , right);
        if(index == k){
            return;
        }
        else if(index < k){
            mypartition(arr , index + 1 , right , k);
        }
        else{
            mypartition(arr , left , index - 1 , k);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left + 1;
        int j = right;
        int value = arr[left];
        while (true){
            while (arr[i] <= value){
                if(i == right){
                    break;
                }
                i ++;
            }
            while (arr[j] > value){
                if(j == left){
                    break;
                }
                j -- ;
            }
            if(i >= j){
                break;
            }
            swap(arr , i , j);
        }
        swap(arr , left , j);
        return j;
    }
    public static void swap(int[] arr , int x , int y){
        int z = arr[x];
        arr[x] = arr[y];
        arr[y] = z;
    }
}
