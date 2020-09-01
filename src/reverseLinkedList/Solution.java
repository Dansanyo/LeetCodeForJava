package reverseLinkedList;

public class Solution {
    /***
     * 双指针迭代，每次都用tmp去存储right的下一位，然后用right的next指向left， 然后把right赋值给left，并将tmp的值赋给自己来完成向右移位操作
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode left = null;
        ListNode right = head;
        while (right != null) {
            // 用tmp来存储当前循环到的节点的下一个节点
            ListNode tmp = right.next;

            // 把当前节点的下一位指向上一个节点
            right.next = left;

            // 向右移位
            left = right;
            right = tmp;
        }

        return left;
    }
}
