public class Solution {

    boolean hasCycle(Node head) {
        Set<Object> set = new HashSet<Object>();

        while (head != null) {
            if (!set.add(head))
                return true;
            head = head.next;
        }
        return false;

    }
}
