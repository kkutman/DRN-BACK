package kg.drn.drnback.dto.response;

import kg.drn.drnback.entity.enums.Role;
import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String email,
        Role role,
        String token
) {
}
