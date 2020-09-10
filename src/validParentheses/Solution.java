package validParentheses;

import java.util.*;

public class Solution {
    /**
     * 遍历括号字符串，碰到左括号的话放进栈里，
     * 碰到右括号的话先看栈里有没有元素，如果有的话就弹出，比较左右两个括号是否能匹配，能的话继续遍历
     * 如果不能匹配就返回false
     * 遍历结束后如果栈内还有元素则说明无效 返回false；没有元素说明全部匹配上了 返回true
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '{' || aChar == '(' || aChar == '[')
                left.push(aChar);
            else {
                if (left.size() == 0)
                    return false;
                else {
                    Character pop = left.pop();
                    if ((aChar == ')' && '(' == pop) || (aChar == '}' && '{' == pop) || (aChar == ']' && '[' == pop))
                        continue;
                    else
                        return false;
                }
            }
        }
        return left.empty();
    }

    /**
     * 遍历s 碰到左括号就把对应的右括号压栈
     * 碰到右括号的话判断 栈内无元素 或栈顶的右括号和当前遍历到的右括号不一样的话 return false
     * 遍历结束后 return栈的状态
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> stark = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='(')
                stark.push(')');
            else if(c=='{')
                stark.push('}');
            else if(c=='[')
                stark.push(']');
            else{
                if(stark.empty() || stark.pop()!=c)
                    return false;
            }
        }
        return stark.empty();
    }
}
