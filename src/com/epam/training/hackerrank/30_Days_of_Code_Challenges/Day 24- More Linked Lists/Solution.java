class Solution {
    public static Node removeDuplicates(Node head) {
        Node temp = head;
        while (head != null && head.next != null) {
            if (head.data != head.next.data)
                head = head.next;
            else {
                head.next = head.next.next;
            }
        }
        return temp;
    }
}
