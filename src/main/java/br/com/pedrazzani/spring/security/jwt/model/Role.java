package br.com.pedrazzani.spring.security.jwt.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@Builder
public class Role implements GrantedAuthority{
    private Long id;
    private RoleType type;

    @Override
    public String getAuthority() {
        return type.name();
    }
}

