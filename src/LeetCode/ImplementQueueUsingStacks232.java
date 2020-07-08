package LeetCode;

import java.util.Stack;

/**
 * LeetCode 232
 * 题意：
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size,
 * 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * 思路：与《剑指offer》09相同，
 *      用两个栈实现队列，这不过这里的peek(),pop()方法一致，都要先把s2中的元素处理完，
 *      当s2为空时，才能将s1中的元素压入。
 *      所以pushToPop()方法单独声明
 *      100% , 7.14%
 */
public class ImplementQueueUsingStacks232 {
    public static void main(String[] args) {

    }
    class MyQueue {
        Stack<Integer> s1 ;
        Stack<Integer> s2 ;
        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void pushToPop(){
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
        }
        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            pushToPop();
            if(!s2.isEmpty()){
                return s2.pop();
            }
            return -1;
        }

        /** Get the front element. */
        public int peek() {
            pushToPop();
            if(!s2.isEmpty()){
                return s2.peek();
            }return -1;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            pushToPop();
            return s2.isEmpty();
        }
    }
}
