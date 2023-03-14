// The ListIterator is what moves through the LinkedList to find specific data

public class ListIterator<T> {

    /* Current node (of type ListNode) */
    protected ListNode<T> curNode;

    /* ListIterator constructor. Accepts the current node. */
    public ListIterator(ListNode<T> currentNode) {
        curNode = currentNode;
    }

    public boolean isPastEnd() {
        // Tells us if we are on the dummy tail
        if (curNode.next == null){ // This checks to see if we are on the tail as it is the only node with null as next
            return true;
        }
        return false;
    }

    public boolean isPastBeginning() {
        // Tells us if we are on the dummy head
        if (curNode.prev == null){ // This checks to see if we are on the head as it is the only node with null as prev
            return true;
        }
        return false;
    }

    public T value() {
        // As long as we are neither the dummy head nor tail node, then we get the data, otherwise the data is null
        T data = null;
        if (!isPastEnd() & !isPastBeginning()){
            data = curNode.getData();
        }
        return data;
        /* Hint: Remember to first validate the position of the Iterator */
    }

    public void moveForward() {
        // Moves the iterator forwards as long as we are not at the end
        if (!isPastEnd()){
            curNode = curNode.next;
        }
    }

    public void moveBackward() {
        // Moves the iterator backwards as long as we are not at the beginning
        if (!isPastBeginning()){
            curNode = curNode.prev;
        }
    }
}
