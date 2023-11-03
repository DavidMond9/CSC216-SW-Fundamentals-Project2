package edu.ncsu.csc216.stp.model.util;

/**
 * A list that maintains a log of elements that are added to the end and cannot be removed
 * @param <E> Generic type of elements log can accept
 * @author Gavin Douglas
 * @author David Mond
 */
public class Log<E> implements ILog<E> {
	
	/** An array that holds elements of a generic type */
	private E[] log;
	
	/** Number of elements in the array */
	private int size;
	
	/** Initial capacity of the array */
	private static final int INIT_CAPACITY = 10;
	
	/**
	 * Constructor for Log
	 */
	public Log() {
		log[0] = null;
		size = INIT_CAPACITY;
		size += size;
	}
	
	/**
	 * Adds an element to the end of the list
	 * @param element element to be added
	 */
	public void add(E element) {
		
	}
	
	/**
	 * Gets the element at the index
	 * @param idx index of the desired element
	 * @return the element at the given index
	 */
	public E get(int idx) {
		@SuppressWarnings("unchecked")
		E x = (E)"a";
		return x;
	}
	
	/**
	 * Gets the number of elements in the array
	 * @return the number of elements in the array
	 */
	public int size() {
		return 0;
	}



	
}
