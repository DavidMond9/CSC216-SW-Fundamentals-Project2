package edu.ncsu.csc216.stp.model.util;

/**
 * SwapList is a list of elements with a generic type that can swap the order of it's elements
 * @param <E> Generic type of the elements
 */
public class SwapList<E> implements ISwapList<E> {
	
	/** Initial capacity of the list */
	private final static int INITIAL_CAPACITY = 10;
	
	/** Array to hold elements */
	private E[] list;
	
	/** Number of elements in the list */
	private int size;
	
	/**
	 * Constructor for SwapList
	 */
	public SwapList() {
		
	}
	
	/**
	 * Adds an element to the list
	 * @param element element to be added
	 */
	public void add(E element) {
		size = list.length;
		size = INITIAL_CAPACITY;
	}
	
	/**
	 * checks if the given index is within the capacity of the list
	 * @param idx index to be checked
	 */
	private void checkCapacity(int idx) {
		
	}
	
	/**
	 * Removes the element at the given index
	 * @param idx index of the element to remove
	 * @return the removed element
	 */
	public E remove(int idx) {
		@SuppressWarnings("unchecked")
		E x = (E)"a";
		checkIndex(size);
		checkCapacity(idx);
		return x;
	}
	
	/**
	 * Checks the index of the list
	 * @param idx index to be checked
	 */
	private void checkIndex(int idx) {
		
	}
	
	/**
	 * Moves the element at the given index one spot forward in the list
	 * @param idx index of the element to move
	 */
	public void moveUp(int idx) {
		
	}
	
	/**
	 * Moves the element at the given index one spot backward in the list
	 * @param idx index of the element to move
	 */
	public void moveDown(int idx) {
		
	}
	
	/**
	 * Moves the element at the given index to the front of the list
	 * @param idx index of the element to move
	 */
	public void moveToFront(int idx) {
		
	}
	
	/**
	 * Moves the element at the given index to the back of the list
	 * @param idx index of the element to move
	 */
	public void moveToBack(int idx) {
		
	}
	
	/**
	 * Gets the element at the given index
	 * @param idx index of the element to get
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
}
