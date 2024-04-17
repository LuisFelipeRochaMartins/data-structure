package com.github.luisfeliperochamartins.lists;

public interface IList<T> {

	/**
	 * Verifies if the list is empty
	 *
	 * @return boolean
	 */
	boolean empty();

	/**
	 * Insert a new node into the beginning of the list
	 *
	 * @param node T
	 */
	void insert(T node);

	/**
	 * Insert a new node into the end of the list
	 * @param node T
	 */
	void append(T node);

	void append(T ...nodes);

	/**
	 * Deletes by node id
	 *
	 * @param id Integer
	 */
	void deleteById(Integer id);

	/**
	 * Deletes the first node of the list
	 */
	void deleteFirst();

	/**
	 * Deletes the last node of the lsit
	 */
	void deleteLast();

	/**
	 *  Removes a node if it's in the list
	 *
	 * @param node T
	 */
	void remove(T node);

	/**
	 * Removes a node by its position in the list
	 * @param pos int
	 */
	void removeByPosition(int pos);

	/**
	 * Counts the number of nodes in the list
	 *
	 * @return Integer count
	 */
	Integer count();

	/**
	 * Returns the position of a node by its id <br/>
	 * Returns -1 if the node is not found!
	 *
	 * @param id Integer
	 * @return Integer
	 */
	Integer findById(Integer id);
}
