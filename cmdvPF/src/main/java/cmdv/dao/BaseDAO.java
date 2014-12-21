package cmdv.dao;

public interface BaseDAO <T, K> {

	public T create(T entity);

	public T update(T entity);

	public void delete(T entity);

	public T findById(K key);
	
	public T genrico(T entity);

}
