package ch.nyp.noa.webContext.domain.role;

public interface RoleService {

	Role findById(long id);

	Role findByRole(String name);

	void save(Role role);

	void update(Role role);

	void deleteById(long id);
	
	void deleteByRole(String name);

}
