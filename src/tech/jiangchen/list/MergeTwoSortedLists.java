package tech.jiangchen.list;

import tech.jiangchen.struct.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = a == null ? b : a;

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists demo = new MergeTwoSortedLists();
        ListNode l1 = ListNode.initWithParams(2, 3, 5);
        ListNode l2 = ListNode.initWithParams(1, 4);
        System.out.println(demo.mergeTwoLists(l1, l2));
    }
}
