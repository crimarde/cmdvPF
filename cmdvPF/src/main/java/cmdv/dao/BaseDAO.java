package cmdv.dao;

import java.io.Serializable;

public interface BaseDAO <T, K extends Serializable> {

	public T create(T entity);

	public T update(T entity);

	public void delete(T entity);

	public T findById(K key);
	
	public T genrico(T entity);

}
