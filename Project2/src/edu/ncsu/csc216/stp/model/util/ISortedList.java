package edu.ncsu.csc216.stp.model.util;

public interface ISortedList<E> {
	public void add(E list);
	public void remove(int i);
	public boolean contains(E list);
	public void get(int i);
	public int size();
}
