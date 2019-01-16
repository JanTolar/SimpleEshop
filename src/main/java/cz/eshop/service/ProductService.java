package cz.eshop.service;

import java.util.List;

import cz.eshop.entity.Product;

public interface ProductService {

	/**
	 * Create new Product
	 * @param product
	 */
	public void create(Product product);

	/**
	 * Update new Product
	 * @param product
	 */
	public void update(Product product);

	/**
	 * Remove Product
	 * @param product
	 */
	public void remove(Product product);

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
