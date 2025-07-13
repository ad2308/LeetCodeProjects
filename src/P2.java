
class ListNode
{
    int val;
    ListNode next;

    ListNode()
    {
    }

    ListNode(int val)
    {
        this.val = val;
    }

    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}

class Solution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int carry = 0;
        ListNode result = null;
        ListNode current = null;

        while (l1 != null || l2 != null) {
            int total;
            if (l1 == null) {
                total = l2.val + carry;
                l2 = l2.next;
            }
            else if (l2 == null) {
                total = l1.val + carry;
                l1 = l1.next;
            }
            else {
                total = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }

            int sum = total % 10;
            carry = total / 10;
            if (result == null) {
                result = new ListNode(sum, null);
                current = result;
            }
            else {
                current.next = new ListNode(sum, null);
                current = current.next;
            }
        }

        if (carry > 0)
        {
            current.next = new ListNode(carry, null);
        }
        return result;
    }
}