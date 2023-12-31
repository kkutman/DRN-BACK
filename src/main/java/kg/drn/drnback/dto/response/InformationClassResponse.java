package kg.drn.drnback.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record InformationClassResponse(
        Long id,
        String subject,
        List<InformationSubClassResponse>informationSubClassResponses,
        LocalDate createAt
) {
}
