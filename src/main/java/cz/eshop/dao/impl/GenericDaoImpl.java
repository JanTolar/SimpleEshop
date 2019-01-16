package cz.eshop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository layer for common CRUD operations with generic object
 */
@Repository
@Transactional(readOnly = true)
public abstract class GenericDaoImpl<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Create generic object
	 * @param object
	 */
	@Transactional(readOnly = false)
	public void create(final T object) {
		entityManager.persist(object);
	}

	/**
	 * Update generic object
	 * @param object
	 */
	@Transactional(readOnly = false)
	public void update(final T object) {
		entityManager.merge(object);
	}

	/**
	 * Remove generic object
	 * @param object
	 */
	@Transactional(readOnly = false)
	public void remove(final T object) {
		entityManager.remove(entityManager.contains(object) ? 
				object : 
				entityManager.merge(object));
	}

	/**
	 * Find list of generic objects
	 * @param CriteriaQuery crit
	 * @return List<T>
	 */
	public List<T> findByCriteria(final CriteriaQuery<T> crit) {
		return entityManager.createQuery(crit).getResultList();
	}

}
