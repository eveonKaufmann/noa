package ch.nyp.noa.webContext.domain.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;
	
	/**
	 * 
	 */
	public RoleServiceImpl() {
		super();
	}

	/**
	 * @param roleRepository
	 */
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public Role findById(long id) {
		Role role = roleRepository.getOne(id);
		return role;
	}

	@Override
	public Role findByRole(String role) {
		Role foundRole = roleRepository.findByRole(role);
		return foundRole;
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
		
	}

	@Override
	public void update(Role role) {
		roleRepository.save(role);
		
	}

	@Override
	public void deleteById(long id) {
		roleRepository.deleteById(id);
		
	}

	@Override
	public void deleteByRole(String role) {
		roleRepository.deleteByRole(role);
	}	
}
