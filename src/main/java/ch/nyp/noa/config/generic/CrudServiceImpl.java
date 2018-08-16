package ch.nyp.noa.config.generic;

import java.util.List;
import java.util.Optional;

import ch.nyp.noa.webContext.exceptionHandling.EntityNotFoundException;

/**
 * Generic abstract class that implements the CrudService
 *
 * @author Yves Kaufmann
 */
public abstract class CrudServiceImpl<T extends ExtendedEntity> implements
		CrudService<T> {
	
	private ExtendedJpaRepository<T> repository;

	protected ExtendedJpaRepository<T> getRepository() {
		return repository;
	}

	public CrudServiceImpl(ExtendedJpaRepository<T> repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(T entity) throws EntityNotFoundException {
		repository.save(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(T entity) throws EntityNotFoundException {
		repository.delete(entity);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(Long id) throws EntityNotFoundException {
		repository.deleteById(id);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(T entity) throws EntityNotFoundException {
		repository.save(entity);
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T findById(Long id) throws EntityNotFoundException {
		Optional<T> entity = repository.findById(id);
		return entity.get();
	}
	
}
