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
	@SuppressWarnings("unchecked")
	public Log() {
		log = (E[]) new Object[INIT_CAPACITY];
		size = 0;
	}
	
	/**
	 * Adds an element to the end of the list
	 * @param element element to be added
	 */
	@SuppressWarnings("unchecked")
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (size >= log.length - 1) {
			E[] tempList = log;
			log = (E[]) new Object[log.length * 2];
			for (int i = 0; i < tempList.length - 1; i++) {
				log[i] = tempList[i];
			}
		}
		log[size] = element;
		size++;
	}
	
	/**
	 * Gets the element at the index
	 * @param idx index of the desired element
	 * @return the element at the given index
	 */
	public E get(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		return log[idx];
	}
	
	/**
	 * Gets the number of elements in the array
	 * @return the number of elements in the array
	 */
	public int size() {
		return size;
	}

	
}
