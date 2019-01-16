package cz.eshop.dao;

/**
 * Interface for common db operations with generic object 
 */
public interface GenericDao<T extends Object> {

	/**
	 * Create generic object
	 * @param object
	 */
	void create(T object);

	/**
	 * Update generic object
	 * @param object
	 */
	void update(T object);

	/**
	 * Remove generic object
	 * @param object
	 */
	void remove(T object);

}
