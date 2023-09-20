package kg.drn.drnback.dto.request;

import lombok.Builder;

@Builder
public record SymbolismRequest(
        String symbolism,
        String subject,
        String text
) {
}
