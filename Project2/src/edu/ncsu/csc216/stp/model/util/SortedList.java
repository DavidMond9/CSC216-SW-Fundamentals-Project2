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
	
	/** 
	 * Constructor for SortedList
	 */
	public SortedList() {
		size += size;
	}

	/**
	 * Removes the element at the given index
	 * @param idx the index of the element to remove
	 * @return the removed element
	 */
	public E remove(int idx) {
		checkIndex(idx);
		@SuppressWarnings("unchecked")
		E x = (E)"a";
		return x;
	}
	
	/**
	 * Checks that there is an element at the given index
	 * @param idx index to check
	 */
	private void checkIndex(int idx) {
		
	}
	
	/**
	 * Gets the element at the given index
	 * @param idx the index of the element to get
	 * @return the element at the given index
	 */
	public E get(int idx) {
		@SuppressWarnings("unchecked")
		E x = (E)"a";
		return x;
	}
	
	/**
	 * Gets the number of elements in the list
	 * @return the number of elements in the list
	 */
	public int size() {
		return 0;
	}
	
	/**
	 * Represents a node in the SortedList
	 * @author Gavin Douglas
	 * @author David Mond
	 */
	public class ListNode {
		
		/**
		 * Data stored in the node
		 */
		public E data;
		
		/**
		 * First node in the list
		 */
		private ListNode front;
		
		/**
		 * Next node in the list
		 */
		public ListNode next;
		
		/**
		 * Constructor for ListNode
		 * @param data in the node
		 * @param front first node in the list
		 */
		public ListNode(E data, ListNode front) {
			System.out.println(this.front);
		}
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
		
		return false;
	}
}

