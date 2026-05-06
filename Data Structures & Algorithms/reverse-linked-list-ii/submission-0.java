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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        int i = 1;
        while (i < left && start.next != null) {
            start = start.next;
            i++;
        }
        ListNode prev = null;
        ListNode curr = start.next;
        ListNode tail = curr;
        while (i<=right && curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            i++;
        }
        start.next = prev;
        tail.next = curr;
        return dummy.next;
    }
}