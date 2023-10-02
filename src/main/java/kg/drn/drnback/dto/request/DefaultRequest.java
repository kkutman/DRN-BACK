package kg.drn.drnback.dto.request;


import lombok.Builder;

@Builder
public record DefaultRequest(
        String text,
        String subject
) {
}
