package kg.drn.drnback.dto.response;

import lombok.Builder;

@Builder
public record InformationSubClassResponse(
        String subject,
        String text
) {
}
