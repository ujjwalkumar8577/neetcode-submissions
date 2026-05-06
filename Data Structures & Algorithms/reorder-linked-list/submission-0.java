/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = getMiddleNode(head);
        ListNode rev = reverseList(mid.next);
        mid.next = null;
        mergeAlternatively(head, rev);
    }

    public ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeAlternatively(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;
            
            head1.next = head2;
            if (tmp1 == null) {
                break;
            }
            head2.next = tmp1;

            head1 = tmp1;
            head2 = tmp2;
        }
    }
}
