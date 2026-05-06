/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node copy = new Node(head.val);
        Node tmp = head;
        Node copyTmp = copy;
        map.put(head, copy);
        while (tmp.next != null) {
            copyTmp.next = new Node(tmp.next.val);
            map.put(tmp.next, copyTmp.next);
            tmp = tmp.next;
            copyTmp = copyTmp.next;
        }
        tmp = head;
        copyTmp = copy;
        while (tmp != null) {
            copyTmp.random = map.getOrDefault(tmp.random, null);
            tmp = tmp.next;
            copyTmp = copyTmp.next;
        }
        return copy;
    }
}
