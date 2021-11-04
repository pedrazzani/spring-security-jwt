package br.com.pedrazzani.spring.security.jwt.dto.mapper;

import br.com.pedrazzani.spring.security.jwt.model.User;
import br.com.pedrazzani.spring.security.jwt.dto.AuthResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthResponseMapper {

    AuthResponseMapper INSTANCE = Mappers.getMapper(AuthResponseMapper.class);

    AuthResponseDto from(User user);

}
