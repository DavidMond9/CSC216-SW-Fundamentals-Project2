package edu.ncsu.csc216.stp.model.util;

public interface ILog<E> {
	
	public void add(E log);
	public void get(int num);
	public int size();
}
