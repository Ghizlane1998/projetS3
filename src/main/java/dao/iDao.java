package dao;

import java.util.List;

public interface iDao <T> {

	boolean create (T o);
	boolean update (T o);
	boolean delete (T o);
	T getById(int id);
	List<T> getAll();
	List<String> getAllFields();
}
