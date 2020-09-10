package linkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 双指针迭代，如果fast==null则说明没有环，返回false
     * 如果有环则fast和slow都会一直迭代下去直到碰到 返回true
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            if (slow==fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    /***
     * hashSet中无法存入相同元素，则如果有环就会迭代到相同的元素 如果set中已有了这个元素就说明有环
     * 迭代完毕后还没有重复 则说明无环
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head){
        if (head==null || head.next==null) {
            return false;
        }
        Set<ListNode>set = new HashSet<>();
        while(head!=null){
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

}
