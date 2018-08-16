package ch.nyp.noa.config.generic;

import java.util.List;

import ch.nyp.noa.webContext.exceptionHandling.EntityNotFoundException;

/**
 * Generic interface that covers the basic CRUD related methods
 *
 * @author Yves Kaufmann
 */
public interface CrudService<E extends ExtendedEntity> {
	
	/**
	 * Saves the given entity
	 *
	 * @param entity The entity to be saved
	 */
	void save(E entity) throws EntityNotFoundException;

	/**
	 * Updates the given entity
	 *
	 * @param entity The entity to be updated
	 */
	void update(E entity) throws EntityNotFoundException;

	/**
	 * Deletes the given entity
	 *
	 * @param entity The entity to be deleted
	 */
	void delete(E entity) throws EntityNotFoundException;

	/**
	 * Deletes an entity with a given primary key
	 *
	 * @param id Primary key of entity
	 */
	void deleteById(Long id);

	/**
	 * Finds all records of one entity
	 *
	 * @return Returns a list of all records of the given entity
	 */
	List<E> findAll();

	/**
	 * Finds an entity with a given primary key
	 *
	 * @param id Primary key of entity
	 * @return Returns requested entity with given primary key id
	 */
	E findById(Long id) throws EntityNotFoundException;
	
}