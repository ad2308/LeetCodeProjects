import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    private String itemToString() {
        return val+(next == null ? "" : ","+next.itemToString());
    }

    public String toString() {
        return "["+this.itemToString()+"]";
    }
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Case not needed due to constraints of problem.
//        if (n < 1) throw new IndexOutOfBoundsException();

        // Instantiate a circular buffer to hold the last (n+1) encountered nodes.
        // In this way, we avoid a second pass by being guaranteed to have all the nodes needed to perform the deletion,
        // even though we don't know precisely where the end of the list is.
        // This is sufficient since the node (n+1) nodes back from the last node is the node *before* the node being removed
        // This node needs to be stored since we need to update its next pointer.
        ListNode[] nodeBuffer = new ListNode[n+1];

        int length = 0;
        ListNode current = head;
        while (current != null) {
            // The buffer index is calculated mod (n+1), in order to ensure later items overwrite earlier items.
            nodeBuffer[length % (n+1)] = current;
            length++;
            current = current.next;
        }

        // Case not needed due to constraints of problem.
//        if (n > length) throw new IndexOutOfBoundsException();

        // At this point, the value of the variable length is the length of the list.
        // The item at nodeBuffer[length % (n+1)] is one past the end of the list.
        // Due to it being a circular buffer, this means it stores the (n+1)th last item i.e. the previous node (if it exists).
        // The item after the one being deleted (if it exists) therefore exists two spaces later in the circular buffer
        // Therefore, it is at index (length + 2) % (n + 1).
        // Those are the only two nodes we need to complete the operation.
        ListNode prev = nodeBuffer[length % (n+1)];
        ListNode next = nodeBuffer[(length + 2) % (n + 1)];
        if (n == length) {
            // Special case: remove the first item from the list. In this case, the head of the new list is the node after the head node passed in.
            return head.next;
        }

        // Link the previous node to the next node (if n = 1 then we are removing the last item in the list,
        // and the previous node should link to nothing), and return the head of the modified list.
        prev.next = (n == 1) ? null : next;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new Solution19().removeNthFromEnd(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, null)
                                        )
                                )
                        )
                ), 2
        ));
    }
}