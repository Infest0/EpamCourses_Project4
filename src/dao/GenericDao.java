package dao;

import java.util.List;

/**
 * Add generic conditions and contains default CRUD operations
 * @author Nick
 *
 * @param <E>
 */
interface GenericDao<E> {
	void create(E e);

	boolean update(E e);

	boolean delete(int id);

	E find(int id);
	
	List<E> findAll();
}
