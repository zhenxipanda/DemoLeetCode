package JianZhiOffer;

/***
 * 剑指offer 11
 * 题意：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 思路：与LeetCode 154相同，
 *      奇妙的是，154是Hard难度，这道题是Easy难度...
 *      数组的旋转，只有部分是有序的，按照二分思想，进行移动
 *      这里只比较 mid 与 right 就可以
 *      100% , 100%
 */
public class interview11 {
    public static void main(String[] args) {
         int[] numbers = {2,2,2,0,1};
         int res = minArray(numbers);
        System.out.println(res);
    }
    public static int minArray(int[] numbers) {
        if(numbers == null || numbers.length == 0){
            return 0;
        }
        // 如果数组只有两个元素，判断哪个最小
        if(numbers.length == 0){
            return numbers[0] < numbers[1] ? numbers[0] : numbers[1];
        }
        int left = 0 , right = numbers.length - 1;
        // 二分的条件
        while(left <= right){
            int mid = (left + right) >> 1;
            // numbers[mid] > numbers[right]，说明 mid肯定不是最小值，所以 left = mid + 1
            if(numbers[mid] > numbers[right]){
                left = mid + 1;
            }
            // numbers[mid] < numbers[right]，不能排除 mid不是最小值，所以 right = mid
            else if(numbers[mid] < numbers[right]){
                right = mid ;
            }
            // numbers[mid] == numbers[right],无法确实最小值在 left-mid之间，还是mid-right之间，所以right --;
            else{
                right = right - 1;
            }
        }
        // left指向的就是最小的元素
        return numbers[left];
    }
}
