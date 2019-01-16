package cz.eshop.dao;

import java.util.List;

import cz.eshop.entity.Product;

/**
 * Interface for db operations with Product entity
 */
public interface ProductDao extends GenericDao<Product> {

	/**
	 * @return Collection of all Product entities
	 */
	public List<Product> getList();

	/**
	 * @param id
	 * @return loaded Product entity
	 */
	public Product loadById(Long id);

}
