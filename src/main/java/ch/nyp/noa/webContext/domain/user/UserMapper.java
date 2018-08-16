package ch.nyp.noa.webContext.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ch.nyp.noa.webContext.domain.user.dto.UserDTO;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

	UserDTO userToUserDTO(User user);
	User userDTOToUser(UserDTO userDTO);
	
}
