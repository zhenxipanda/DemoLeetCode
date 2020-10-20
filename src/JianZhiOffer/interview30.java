package JianZhiOffer;
/**
 * 剑指offer 30
 * 题意：两个栈，s1正常入栈，s2为空 或者 s2.peek() >= x , s2.push()
 *      删除元素时，if((s1.pop()).equals(s2.peek())){ s2.pop() ;}
 *      这种写法可以学习一下
 *      30.15% , 99.56%
 */

import java.util.Stack;

public class interview30 {
    public static void main(String[] args) {

    }

}
class MinStack {
    private Stack<Integer> stackData ;
    private Stack<Integer> stackMin ;
    /** initialize your data structure here. */
    public MinStack() {
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int x) {
        stackData.push(x);
        if(stackMin.isEmpty() || stackMin.peek() >= x){
            stackMin.push(x);
        }
    }

    public void pop() {
        // if(stackData.pop() == stackMin.peek()){
        //     stackMin.pop();
        // }
        if((stackData.pop()).equals(stackMin.peek())){  //因为是Integer引用数据类型，所以用equals not ==
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
