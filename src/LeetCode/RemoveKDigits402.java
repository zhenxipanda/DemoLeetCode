package LeetCode;

import java.util.LinkedList;

/**
 * LeetCode 402
 * 题意：
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * 思路：在下降的拐点处进行删除，
 *      但是如何删除元素呢？使用到栈
 *      栈中的元素是非严格的升序，允许存在重复元素
 *      如果拐点数小于 k ，在升序的栈中，弹栈顶，删除大元素
 *      最后从头遍历栈，忽略前导零
 *      78.42% ，46.84%
 */
public class RemoveKDigits402 {
    public static void main(String[] args) {

    }
    public static String removeKdigits(String num, int k){
        if(num.length() == k){
            return "0";
        }
        LinkedList<Character> stack = new LinkedList<>();
        for(char c : num.toCharArray()){
            while(stack.size() > 0 && k > 0 && stack.peekLast() > c){
                stack.removeLast();
                k --;
            }
            stack.addLast(c);
        }
        // 如果 k != 0,继续移除堆顶
        for(int i = 0;i < k ; i ++){
            stack.removeLast();
        }
        StringBuffer sb = new StringBuffer();
//        判断是否是前导零
        boolean isBeforeZero = true;
        for(char c : stack){
            if(isBeforeZero && c == '0'){
                continue;
            }
            isBeforeZero = false;
            sb.append(c);
        }
//        如果是前导零，sb.length() == 0
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}
