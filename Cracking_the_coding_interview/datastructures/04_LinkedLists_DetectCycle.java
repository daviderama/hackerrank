// Linked Lists: Detect a Cycle
// https://www.hackerrank.com/challenges/ctci-linked-list-cycle

// using the Fast and Slower Runner technique
boolean hasCycle(Node head) {
    if( head == null ) return false;

    Node slow = head;
    Node fast = head.next;

    while( fast != null && fast.next != null ){
        if (fast == slow) {
            return true;
        }

        slow = slow.next;
        fast = fast.next.next;
    }

    return false;
}
