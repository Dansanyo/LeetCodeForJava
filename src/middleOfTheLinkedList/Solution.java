package middleOfTheLinkedList;

public class Solution {
    /**
     * 双节点遍历，一个一次向后2位，一个一次向后1位，第一个走完了 第二个的位置就是中间
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(first != null && first.next!=null){
            first = first.next.next;
            second = second.next;
        }
        return second;
    }
}
