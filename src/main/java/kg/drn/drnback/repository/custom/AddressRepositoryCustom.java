package kg.drn.drnback.repository.custom;

import kg.drn.drnback.dto.response.AddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressRepositoryCustom {
    private final JdbcTemplate jdbcTemplate;

    public List<AddressResponse>getAllAddressByRegionId(Long regionId){
        String sql = """
                SELECT
                    a.id as id,
                    a.name AS name,
                    a.address AS address,
                    a.city AS city,
                    a.phone_number AS phone_number
                FROM address a  where a.region_id = ?
                """;
        return jdbcTemplate.query(sql,(resultSet,i)-> AddressResponse.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .address(resultSet.getString("address"))
                .city(resultSet.getString("city"))
                .phoneNumber(resultSet.getString("phone_number"))
                .build(),regionId);
    }
}
