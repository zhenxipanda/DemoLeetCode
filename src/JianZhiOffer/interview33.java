package JianZhiOffer;

/**
 * 剑指offer 33
 * 题意：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 * 提示：
 * 数组长度 <= 1000
 * 思路：特别注意：if(left >= right) return true
 *      以及最后的 判断 l == right
 *      100% , 99.73%
 */
public class interview33 {
    public static void main(String[] args) {
        int[] postorder = {1,6,3,2,5};
        boolean res = verifyPostorder(postorder);
        System.out.println(res);
    }
    public static boolean verifyPostorder(int[] postorder){
        return isValid(postorder , 0 , postorder.length - 1);
    }

    private static boolean isValid(int[] postorder, int left, int right) {
        if(left >= right){
            return true;
        }
        int m = left ;
        int value = postorder[right];
        while (m < right && postorder[m] < value){
            m ++ ;
        }
        int l = m;
        while (l < right && postorder[l] > value){
            l ++ ;
        }
        return l == right && isValid(postorder , left , m - 1) && isValid(postorder , m , right - 1);
    }
}
