/**
 * @author SkyeInfo
 * @LastModifyTime 2017/8/28
 * @LastModify SkyeInfo
 */
import java.util.Stack;
import java.lang.RuntimeException;

public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()){
            throw new RuntimeException("栈均为空");
        }

        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
