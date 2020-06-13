package LeetCode;
import java.util.*;

/**
 * LeetCode 155
 * 题意：设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * 思路：用一个辅助栈min ， stack是正常栈，记录元素的压入和弹出
 *      min只有当为空或者栈顶元素比待压入元素大时，才入min栈
 *      即min 的栈顶是当前遍历到的最小值，弹出时，如果stack的弹出元素与min的栈顶相等，即弹出
 *      97.26% ， 14.46%
 */
public class MinStack155 {
    public static void main(String[] args) {

    }
    private static Stack<Integer> stack ;
    private static Stack<Integer> min ;
    /** initialize your data structure here. */
    public MinStack155() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public static void push(int x) {
        stack.push(x);
        if(! min.isEmpty() && min.peek() < x){
            return ;
        }
        min.push(x);
    }

    public static void pop() {
        int x = stack.pop();
        if(! min.isEmpty() && x == min.peek()){
            min.pop();
        }
    }

    public static int top() {
        return stack.peek();
    }

    public static int getMin() {
        return min.peek();
    }
}
