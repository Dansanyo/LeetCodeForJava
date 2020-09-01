package mergeTwoSortedLists;

public class Solution {
    /***
     * 新建一个节点用来保存头节点的位置，然后用新的头节点去循环访问2个链表拿到偏小的链表的值，并且让该链表的节点往后移位
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        // 用来参与迭代的节点
        ListNode prev = preHead;
        // 记录头节点的位置
        preHead.next=prev;
        while (l1!=null && l2!=null){
            // 哪个链表的当前值偏小 就记录成这个节点，并且让这个链表向后移动
            if(l1.val<=l2.val){
                prev.next=l1;
                l1 = l1.next;
            }else{
                prev.next=l2;
                l2=l2.next;
            }
            // 把刚才记录的节点放在新的链表里
            prev=prev.next;
        }
        prev.next = l1==null?l2:l1;
        return preHead.next;
    }

    /***
     * 递归写法 抄的 能理解但是自己写不出来
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
