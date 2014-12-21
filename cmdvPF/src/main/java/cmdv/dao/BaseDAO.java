package cmdv.dao;

/**
 * Implementa las operaciones basicas de un CRUD mediante genericos
 * 
 * @author Chris
 *
 * @param <T> Clase a persisitir
 * @param <K> Parametro usado como id de la clase para realizar selects o updates
 */
public interface BaseDAO <T, K> {

	/**Insert*/
	public T create(T entity);
	
	/**Update*/
	public T update(T entity);

	/**Delete*/
	public void delete(T entity);

	/**Select*/
	public T findById(K key);

}
