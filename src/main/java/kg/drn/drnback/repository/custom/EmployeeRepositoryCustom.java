package kg.drn.drnback.repository.custom;

import kg.drn.drnback.dto.response.EmployeeResponse;
import kg.drn.drnback.entity.enums.RegionType;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class EmployeeRepositoryCustom {
    private final JdbcTemplate jdbcTemplate;
    public List<EmployeeResponse> getAllEmployeeResponse() {
        String sql = """
                SELECT e.first_name   AS first_name,
                       e.last_name    AS last_name,
                       e.surname      AS surname,
                       e.phone_number AS phone_number,
                       e.email        AS email,
                       e.image        AS image,
                       e.job_title    AS job_title,
                       e.region       AS region,
                       e.address      AS address
                FROM employee e WHERE e.employee_type = 'GUIDELINES';
                """;
        return jdbcTemplate.query(sql,(resultSet,i)->
                EmployeeResponse.builder()
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .surname(resultSet.getString("surname"))
                        .phoneNumber(resultSet.getString("phone_number"))
                        .email(resultSet.getString("email"))
                        .image(resultSet.getString("image"))
                        .jobTitle(resultSet.getString("job_title"))
                        .region(RegionType.valueOf(resultSet.getString("region").toUpperCase()))
                        .address(resultSet.getString("address"))
                        .build());
    }

}
