
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Deserialize
public static ListNode deserialize(String data) {
    String[] nodes = data.substring(1, data.length() - 1).split(",");
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    for (String node : nodes) {
        if (!node.isEmpty()) { // Skip empty strings
            current.next = new ListNode(Integer.parseInt(node));
            current = current.next;
        }
    }
    return dummy.next;
}

    // Serialize
    public static String serialize(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val).append(",");
            curr = curr.next;
        }
        sb.deleteCharAt(sb.length() - 1); // remove trailing comma
        sb.append("]");
        return sb.toString();
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage
        String serialized = "[1,2,3,4,5]";
        ListNode head = ListNode.deserialize(serialized);
        
        Solution solution = new Solution();
        ListNode reversed = solution.reverseList(head);
        
        String reversedSerialized = ListNode.serialize(reversed);
        System.out.println("Reversed list: " + reversedSerialized);
    }
}
