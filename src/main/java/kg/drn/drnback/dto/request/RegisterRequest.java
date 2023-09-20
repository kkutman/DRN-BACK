package kg.drn.drnback.dto.request;
public record RegisterRequest(
        String name,
        String email,
        String password
        ) {
}
