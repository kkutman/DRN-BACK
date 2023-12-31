package kg.drn.drnback.repository.custom;

import kg.drn.drnback.dto.response.InformationClassResponse;
import kg.drn.drnback.dto.response.InformationSubClassResponse;
import kg.drn.drnback.entity.enums.InformationClassType;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InformationRepositoryCustom {
    private final JdbcTemplate jdbcTemplate;

    public List<InformationClassResponse> getAllInformationClass(InformationClassType type) {
        String sql = """
                SELECT
                    i.id as id,
                    i.subject as subject,
                    i.create_at as created_at
                FROM information_class i where type = ?
                         """;
        return jdbcTemplate.query(sql, (resultSet, i)
                -> InformationClassResponse.builder()
                .id(resultSet.getLong("id"))
                .subject(resultSet.getString("subject"))
                .createAt(resultSet.getDate("created_at").toLocalDate())
                .informationSubClassResponses(getAllInformationSubClass(resultSet.getLong("id")))
                .build(),type.name());
    }

    public List<InformationSubClassResponse> getAllInformationSubClass(Long id) {
        String sql = """
                SELECT
                    i.subject as subject,
                    i.text as text
                FROM information_sub_class i where i.information_class_id = ?
                   """;
        return jdbcTemplate.query(sql, (resultSet, i)
                -> InformationSubClassResponse.builder()
                .subject(resultSet.getString("subject"))
                .text(resultSet.getString("text"))
                .build(), id);
    }

    public void deleteInformationSubClassByIfoId(Long id) {
        jdbcTemplate.update("delete from information_sub_class i where information_class_id = ?", id);
    }
}
