package cz.eshop.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.eshop.dao.ProductDao;
import cz.eshop.entity.Product;

/**
 * Repository layer for db operations with Product entity
 * Extends AbstractDaoImpl for CRUD operations
 */
@Repository("productDao")
@Transactional(readOnly = true)
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

	@Override
	public List<Product> getList() {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Product> crit = criteriaBuilder.createQuery(Product.class);
		final Root<Product> products = crit.from(Product.class);
		crit.select(products);
		final List<Product> results = findByCriteria(crit);
		return results;
	}

	@Override
	public Product loadById(Long id) {
		if (id == null) {
			return null;
		}
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Product> crit = criteriaBuilder.createQuery(Product.class);
		final Root<Product> products = crit.from(Product.class);

		crit.select(products).where(criteriaBuilder.equal(products.get("id"), id));

		final List<Product> results = findByCriteria(crit);
		if (results.size() != 0) {
			return results.get(0);
		}
		return null;
	}

}
