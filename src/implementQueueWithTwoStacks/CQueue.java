package implementQueueWithTwoStacks;

import java.util.Stack;

public class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * 用两个栈实现队列
     * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     */
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * 添加元素
     * @param value
     */
    public void appendTail(Integer value) {
        stack1.push(value);
    }

    /**
     * 弹出头部元素
     * @return
     */
    public int deleteHead() {
        if (stack2.empty())
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        if (stack2.empty()) {
            return -1;
        } else
            return stack2.pop();
    }
}
