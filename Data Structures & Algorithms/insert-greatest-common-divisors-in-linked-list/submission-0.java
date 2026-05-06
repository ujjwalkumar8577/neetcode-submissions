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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode tmp = head;
        while (tmp.next != null) {
            int a = tmp.val;
            int b = tmp.next.val;
            int g = gcd(a, b);
            ListNode newNode = new ListNode(g, tmp.next);
            tmp.next = newNode;
            tmp = tmp.next.next;

        }
        return head;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}