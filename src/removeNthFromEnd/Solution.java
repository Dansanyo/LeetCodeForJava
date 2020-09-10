package removeNthFromEnd;

public class Solution {
    /**
     * 双游标遍历，first比second先走n次，然后两个一起开始遍历列表，当first到了末端当时候，second的位置就是倒数第n个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(-1);
        tmp.next=head;
        ListNode first = tmp;
        ListNode second = tmp;
        for(int i = 0; i <=n; i++){
            first = first.next;
        }
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        second.next=second.next.next;
        return tmp.next;
    }

    /**
     * 两次循环。第一次拿到链表的长度，然后减去n得到倒数第n个节点的正数位置k。
     * 然后第二次从链表头循环到第k位就是倒数第n位了
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n){
        // 用tmp处理边界问题
        ListNode tmp = new ListNode(-1);
        tmp.next=head;
        int length = 0;
        ListNode first = head;
        // 第一次循环
        while(first!=null){
            length++;
            first = first.next;
        }
        length = length-n;
        first = tmp;
        // 第二次循环
        while(length>0){
            first = first.next;
            length--;
        }
        first.next = first.next.next;
        return tmp.next;
    }

    //todo 别人写的 下次在看
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        int pos = helper(head, n);
        // 说明删除的是头节点
        if(pos == n - 1) {
            return head.next;
        }
        return head;
    }

    // 获取节点所在位置，逆序
    public int helper(ListNode node, int n) {
        if(node.next == null) {
            return 0;
        }
        int pos = helper(node.next, n) + 1;
        if(pos == n) {
            node.next = node.next.next;
        }
        return pos;
    }
}
