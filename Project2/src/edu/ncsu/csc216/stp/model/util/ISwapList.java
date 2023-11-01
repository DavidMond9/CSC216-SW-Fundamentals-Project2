package edu.ncsu.csc216.stp.model.util;

/**
 * Interface for a list that changes the position of elements through
 * swap operations. 
 * 
 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
 *
 * @param <E> type for the ISwapList
 */
public interface ISwapList<E> {
	
	/**
	 * Adds the element to the end of the list.
	 * @param element element to add
	 */
	void add(E element);
	
	/**
	 * Returns the element from the given index.  The element is
	 * removed from the list.
	 * @param idx index to remove element from
	 * @return element at given index
	 * 		for the list
	 */
	E remove(int idx);
	
	/**
	 * Moves the element at the given index to index-1.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move up
	 */
	void moveUp(int idx);
	
	/**
	 * Moves the element at the given index to index+1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move down
	 */
	void moveDown(int idx);
	
	/**
	 * Moves the element at the given index to index 0.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move to the front
	 */
	void moveToFront(int idx);
	
	/**
	 * Moves the element at the given index to size-1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move to the back
	 */
	void moveToBack(int idx);
	
	/**
	 * Returns the element at the given index.
	 * @param idx index of the element to retrieve
	 * @return element at the given index
	 */
	E get(int idx);
	
	/**
	 * Returns the number of elements in the list.
	 * @return number of elements in the list
	 */
	int size();

}