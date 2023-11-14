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
	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	/**
	 * Adds an element to the list
	 * @param element element to be added
	 */
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		checkCapacity(size);
		list[size] = element;
		size++;
	}
	
	/**
	 * checks if the given index is within the capacity of the list
	 * @param size size of the list
	 */
	@SuppressWarnings("unchecked")
	private void checkCapacity(int size) {
		if (size == list.length) {
			E[] tempList = (E[]) new Object[list.length + 10];
			for (int i = 0; i < list.length; i++) {
				tempList[i] = list[i];
			}
			list = tempList;
		}
	}
	
	/**
	 * Removes the element at the given index
	 * @param idx index of the element to remove
	 * @return the removed element
	 */
	public E remove(int idx) {
		checkIndex(idx);
		E temp = list[idx];
		for (int i = idx; i < size; i++) {
			list[i] = list[i + 1];
		}
		size--;
		return temp;
	}
	
	/**
	 * Checks the index of the list
	 * @param idx index to be checked
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}
	
	/**
	 * Moves the element at the given index one spot forward in the list
	 * @param idx index of the element to move
	 */
	public void moveUp(int idx) {
		checkIndex(idx);
		if (size == 0) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		
		if (idx != 0) {
			E temp = list[idx - 1];
			list[idx - 1] = list[idx];
			list[idx] = temp;
		}
	}
	
	/**
	 * Moves the element at the given index one spot backward in the list
	 * @param idx index of the element to move
	 */
	public void moveDown(int idx) {
		checkIndex(idx);
		if (size == 0) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		
		if (idx != size - 1) {
			E temp = list[idx + 1];
			list[idx + 1] = list[idx];
			list[idx] = temp;
		}
		
	}
	
	/**
	 * Moves the element at the given index to the front of the list
	 * @param idx index of the element to move
	 */
	public void moveToFront(int idx) {
		checkIndex(idx);
		if (size == 0) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		
		if (idx != 0) {
			E oldFront = list[0];
			list[0] = list[idx];
			for (int i = idx; i > 1; i--) {
				list[i] = list[i - 1];
				
			}
			list[1] = oldFront;
		}
	}
	
	/**
	 * Moves the element at the given index to the back of the list
	 * @param idx index of the element to move
	 */
	public void moveToBack(int idx) {
		checkIndex(idx);
		if (size == 0) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		
		if (idx != size - 1) {
			E oldBack = list[size - 1];
			list[size - 1] = list[idx];
			for (int i = idx; i < size - 2; i++) {
				list[i] = list[i + 1];
			}
			list[size - 2] = oldBack;
		}
	}
	
	/**
	 * Gets the element at the given index
	 * @param idx index of the element to get
	 * @return the element at the given index
	 */
	public E get(int idx) {
		checkIndex(idx);
		return list[idx];
	}
	
	/**
	 * Gets the number of elements in the list
	 * @return the number of elements in the list
	 */
	public int size() {
		return size;
	}
}
