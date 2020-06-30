package JianZhiOffer;

import java.util.Stack;

/**
 * 剑指offer 09
 * 题意：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 思路：比较简单，栈s1，负责appendTail(),栈s2负责deleteHead()
 *      删除头部元素时，先判断s2是否为空，如果为空，需要将s1中所有元素导入s2中，
 *      为空，return -1，不空，返回栈顶并删除
 *      85.59% ， 100%
 */
public class interview09 {
    public static void main(String[] args) {

    }
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s2.size() <= 0){
            while(s1.size() > 0){
                s2.push(s1.pop());
            }
        }
        if(s2.size() == 0){
            return -1;
        }
        return s2.pop();
    }
}
