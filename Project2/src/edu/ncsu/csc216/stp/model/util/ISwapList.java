package edu.ncsu.csc216.stp.model.util;

public interface ISwapList<E> {
	public void add(E list);
	public void remove(int i);
	public void moveUp(int i);
	public void moveDown(int i);
	public void moveToFront(int i);
	public void moveToBack(int i);
	public int get(int i);
	public int size();
}
