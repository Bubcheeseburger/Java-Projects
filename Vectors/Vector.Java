// This is a self made version of the Vector type of an array, the purpose is to understand exactly
// the way this sort of array works

package vector;

import java.util.Arrays;

public class Vector<T> implements SimpleList<T> {

	private T[] itemArray;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;

	public Vector() {
		this(INITIAL_CAPACITY);  // calls the other constructor that takes an int parameter
	}

	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		this.itemArray = (T[]) new Object[capacity];
		this.size = 0;
	}

	public int capacity() {
		return this.itemArray.length;
	}

	/**
	 * When the underlying array fills up, we need to somehow resize it to accommodate the
	 * Vectors's elements.
	 * Ignores the request if the requested new capacity is too small to fit the elements
	 * already in the Vector
	 */
	public void resize(int newCapacity) {
		// Changes the capacity to what the new one may be. If the new is bigger than old, then a new larger vector is
		// made that replaces the old; if the new is less than the old and is still greater than the size, the capacity
		// reduces to that size; otherwise the capacity remains the same.
		T[] newGuy = (T[]) new Object[newCapacity];
		T[] og = (T[]) new Object[capacity()];
		if (newCapacity > capacity()) {
			// For when capacity needs to increase
			for (int i = 0; i < capacity(); i++) {
				newGuy[i] = itemArray[i];
			}
			itemArray = newGuy;
		} else if (size() < newCapacity) {
			// For when newCapacity is the same or less than the old on the condition that it is greater than the size
			for (int i = 0; i < newCapacity; i++) {
				newGuy[i] = itemArray[i];
			}
			itemArray = newGuy;
		} else {
			// For when the newCapacity fails all the above conditions, maintains the oldCapacity
			for (int i = 0; i < capacity(); i++) {
				og[i] = itemArray[i];
			}
			itemArray = og;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		// Sets every item in the list to null and then resizes it to be "empty": Actual capacity remains the same
		for (int i = 0; i < itemArray.length; i++){
			itemArray[i] = null;
		}
		size = 0;
	}

	@Override
	public void insertAtTail(T item) {
		// Grabs the last item in the Vector and makes it null
		int capacity = size() + 1;
		size = capacity;
		resize(capacity);
//		for (int i = 0; i < size(); i++){
//			if (itemArray[i] == null){
//				itemArray[i] = item;
//			}
//		}
		itemArray[size()-1] = item;
	}

	@Override
	public void insertAtHead(T item) {
		// Uses insert at tail and then rearranges the vector to move the item from the back all the way to the front
		insertAtTail(item);
		for (int i = size()-1; i > 0; i --){
			int j = i -1;
			T temp = itemArray[i];
			itemArray[i] = itemArray[j];
			itemArray[j] = temp;
		}
	}

	@Override
	public void insertAt(int index, T item) {
		// Uses the insert at tail method and rearranges the vector to push back numbers and move the item to the index
		if (index <= size()){ // Checks to see if the index is valid
			insertAtTail(item);
			for (int i = size()-1; i > index; i --){
				int j = i -1;
				T temp = itemArray[i];
				itemArray[i] = itemArray[j];
				itemArray[j] = temp;
			}
		}
	}

	@Override
	public T removeAtTail() {
		// Assigns an object to the last item in the list and then removes it, changes the vector size
		T removed = itemArray[size()-1];
		itemArray[size()-1] = null;
		int capacity = size() - 1;
		size = capacity;
		return removed;
	}

	@Override
	public T removeAtHead() {
		// Assigns an object to the first item and then removes it, rearranges the list and then changes the vector size
		for (int i = 0; i < size() - 1; i++) {
			int j = i + 1;
			T temp = itemArray[i];
			itemArray[i] = itemArray[j];
			itemArray[j] = temp;
		}
		T removed = itemArray[size()-1];
		itemArray[size()-1] = null;
		int capacity = size() - 1;
		size = capacity;
		return removed;
	}

	@Override
	public int find(T item) {
		int found = -1;
		for (int i = 0; i < size(); i++){
			if (itemArray[i].equals(item) && found == -1){
				found = i;
			}
		}
		return found;
	}

	@Override
	public T get(int index) {
		T item = null;
		item = itemArray[index];
		return item;
	}

	/*
	 * This toString() method allow you to print a nicely formatted version of your Vector. E.g.
	 *     System.out.println( myVector );
	 * It uses utility methods in the Java Arrays library.
	 */
	@Override
	public String toString() {
//		return Arrays.toString(this.itemArray); // prints entire array from 0 to capacity-1
		return Arrays.toString(Arrays.copyOfRange(this.itemArray, 0, this.size)); // prints from 0 to size-1
	}

}
