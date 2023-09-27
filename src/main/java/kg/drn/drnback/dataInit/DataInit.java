package kg.drn.drnback.dataInit;


import jakarta.annotation.PostConstruct;
import kg.drn.drnback.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataInit {
    @Value("${data.init}")
    private String str;
    private final JdbcTemplate jdbcTemplate;
    private final RegionRepository regionRepository;

    public DataInit(JdbcTemplate jdbcTemplate, RegionRepository regionRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.regionRepository = regionRepository;
    }

    @PostConstruct
    public void dataInit() {
        if (regionRepository.findAll().size() == 0) {
            if (str.equals("always")) {
                jdbcTemplate.update("""
                        INSERT INTO region (id, region_name, region_type)
                        VALUES (1, 'Бишкек', 'BISHKEK'),
                               (2, 'Ош', 'OSH'),
                               (3, 'Баткен', 'BATKEN'),
                               (4, 'Жалал-Абад', 'JALAL_ABAD'),
                               (5, 'Нарын', 'NARYN'),
                               (6, 'Талас', 'TALAS'),
                               (7, 'Чүй', 'CHUY'),
                               (8, 'Ысык-Көл', 'ISSYK_KOL')
                               
                        """);
            }
        }
    }
}
