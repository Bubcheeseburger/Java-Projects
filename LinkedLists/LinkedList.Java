// Ali Khan
// pnv4bs
// HW6 - LLQueue


package list;

/**
 *
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements SimpleList<T>{

    // Dummy head and tail
    private ListNode<T> head, tail;
    private int size;

    public LinkedList() {
        // Creates an empty LinkedList which has a size of zero with a dummy head and tail which
        // are linked to one another
        head = new ListNode<T>(null);
        tail = new ListNode<T>(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        // Clears out the entire list by returning it to the default states, does not get rid of the data,
        // simply rewires the dummy head and tail nodes to each other and resets size
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void insertAtTail(T data) {
        // Inserts new data to the end of the list
        ListNode<T> temp = new ListNode<>(data);
        temp.prev = tail.prev;
        tail.prev = temp;
        temp.next = tail;
        temp.prev.next = temp;
        size++;
    }

    public void insertAtHead(T data) {
        // Inserts new data to the front of the list
        ListNode<T> temp = new ListNode<>(data);
        temp.next = head.next;
        head.next = temp;
        temp.prev = head;
        temp.next.prev = temp;
        size++;
    }

    public void insertAt(int index, T data) {
        // Inserts new data after a specific indexed item, if that index is greater than items in the list,
        // adds that item to the tail
        ListIterator<T> indexing = front();
        for (int i = 0; i < index; i++){
            indexing.moveForward();
        }
        ListNode<T> temp = new ListNode<>(data);
        temp.prev = indexing.curNode.prev;
        indexing.curNode.prev = temp;
        temp.next = indexing.curNode;
        temp.prev.next = temp;
        size++;

    }

    public void insert(ListIterator<T> it, T data) {
        // Adds data after the item the iterator is currently pointing to
        ListNode<T> temp = new ListNode<>(data);
        temp.next = it.curNode.next;
        temp.next.prev = temp;
        temp.prev = it.curNode;
        it.curNode.next = temp;
        size ++;
    }



    public T removeAtTail(){
        // // Removes the data at the end of the list
        T removed = tail.prev.getData();
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        size--;
        return removed;
    }

    public T removeAtHead(){
        // Removes the data at the front of the list
        T removed = head.next.getData();
        head.next.next.prev = head;
        head.next = head.next.next;
        size--;
        return removed;
    }

    public T remove(ListIterator<T> it) {
        // Removes data the item the iterator is currently pointing to
        T removed = it.curNode.getData();
        it.moveForward();
        it.curNode.prev.prev.next = it.curNode;
        it.curNode.prev = it.curNode.prev.prev;
        size--;
        return removed;
    }
  
    public int find(T data) {
        // Gives the index of the first occurence of the data in the list, otherwise returns -1
        ListIterator<T> indexing = front();
        int found = -1;
        int index = 0;
        for (int i = 0; i < size(); i++){
            if (((int) indexing.curNode.getData() == (int) data) && found == -1){
                found = index;
            }
            indexing.moveForward();
            index++;
        }
        return found;
    }

    public T get(int index) {
        // Gives the data of the item at the stated index, otherwise gives null
        ListIterator<T> indexing = front();
        T data;
        for (int i = 0; i < index; i++){
            indexing.moveForward();
        }
        data = indexing.curNode.getData();
        if (index >= size() || index < 0){
            data = null;
        }
        return data;
    }
  
    public String toString() {
        // Formats the LinkedList as an array
        String toRet = "[";
        ListNode<T> curNode = head.next;
        while(curNode != tail) {
            toRet += curNode.getData() + ", ";
            curNode = curNode.next;
        }

        return toRet + "]";
    }

    public ListIterator<T> front(){
        // Moves the iterator to the front of the list
        ListIterator<T> front = new ListIterator<T>(head.next);
        return front;
    }

    public ListIterator<T> back(){
        // Moves the iterator to the end of the list
        ListIterator<T> back = new ListIterator<T>(tail.prev);
        return back;
    }


}
