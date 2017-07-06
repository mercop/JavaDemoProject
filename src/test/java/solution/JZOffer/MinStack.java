package solution.JZOffer;


import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by mercop on 2017/7/6.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MinStack {

    Deque<Integer> deque = new LinkedList<Integer>();

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    public void push(int node) {

        deque.push(node);
        priorityQueue.add(node);
    }

    public void pop() {
        Integer i = deque.pop();
        priorityQueue.remove(i);
    }

    public int top() {
        return deque.peek();
    }

    public int min() {
        return priorityQueue.peek();
    }


    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(2);
        minStack.push(5);
        minStack.push(1);


        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}
