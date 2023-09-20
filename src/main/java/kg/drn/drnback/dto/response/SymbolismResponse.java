package kg.drn.drnback.dto.response;

import lombok.Builder;

@Builder
public record SymbolismResponse(
        String symbolism,
        String subject,
        String text
) {
}
