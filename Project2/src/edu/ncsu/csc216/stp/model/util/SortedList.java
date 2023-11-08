package edu.ncsu.csc216.stp.model.util;

/**
 * A sorted list hold elements in a custom order
 * @param <E> Generic type of the values that can be stored in SortedList
 * @author Gavin Douglas
 * @author David Mond
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {
	
	/** Number of elements in the list */
	private int size;
	
	/** First Node in the list */
	private ListNode front;
	
	/** 
	 * Constructor for SortedList
	 */
	public SortedList() {
		this.front = null;
		this.size = 0;
	}

	/**
	 * Removes the element at the given index
	 * @param idx the index of the element to remove
	 * @return the removed element
	 */
	public E remove(int idx) {
		checkIndex(idx);
		if (idx < 0 || idx > size - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		ListNode current = null;
		ListNode remove = null;
		
		if (idx == 0) {
			current = front;
			front = front.next;
			return current.data;
			
		} else {
			current = front;
			for (int i = 0; i < idx - 1; i++) {
				current = current.next;
			}
			
			remove = current.next;
			if (idx == size - 1) {
				current.next = null;
			} else {
				current.next = current.next.next;
			}
			
			remove.next = null;
			size--;
			return remove.data;
		}		
	}
	
	/**
	 * Checks that there is an element at the given index
	 * @param idx index to check
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		
		ListNode current = front;
		for (int i = 0; i < idx - 1; i++) {
			current = front.next;
		}
		
		if (current.next.data == null) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Gets the element at the given index
	 * @param idx the index of the element to get
	 * @return the element at the given index
	 */
	public E get(int idx) {
		
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		if (idx == 0) {
			return front.data;
		}
		ListNode current = front;
		
		for (int i = 0; i < idx - 1; i++) {
			current = current.next;
		}
		
		return current.next.data;
	}
	
	/**
	 * Gets the number of elements in the list
	 * @return the number of elements in the list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Adds the element to the list
	 * @param element element to be added
	 */
	public void add(E element) {
		if (element == null) {
			throw new IllegalArgumentException();
		}
		
		
		
		
	}
	
	/**
	 * Check if the list contains the given element
	 * @param element element being looked for
	 * @return true if the list contains the element, false otherwise
	 */
	public boolean contains(E element) {
		
		ListNode current = front;
		for (int i = 0; i < size; i++) {
			if (element.equals(current.data)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Represents a node in the SortedList
	 * @author Gavin Douglas
	 * @author David Mond
	 */
	private class ListNode {
		
		/** The data in the node */
		E data;
		
		/** Next node in the list */
		private ListNode next;
		
		/**
		 * Constructor for a ListNode
		 * @param data data held in the node
		 * @param next next node in the list
		 */
		public ListNode (E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
}

