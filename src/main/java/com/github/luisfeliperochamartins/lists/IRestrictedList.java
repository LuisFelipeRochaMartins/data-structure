package com.github.luisfeliperochamartins.lists;

public interface IRestrictedList<T> {


	/**
	 * Verifies if has space to insert a new Node
	 *
	 * @return boolean
	 */
	boolean hasSpace();

	/**
	 * Verifies if empty or not
	 *
	 * @return boolean
	 */
	boolean empty();

	/**
	 * Insert a new Node.
	 *
	 * @param node T
	 */
	void push(T node);

	/**
	 * Removes the last Node
	 */
	void pop();
}