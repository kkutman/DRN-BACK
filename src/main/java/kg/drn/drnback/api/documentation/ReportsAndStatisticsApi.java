package kg.drn.drnback.api.documentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.dto.request.InformationClassRequest;
import kg.drn.drnback.dto.response.InformationClassResponse;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.services.DocumentationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports_and_statistics")
@RequiredArgsConstructor
@Tag(name = "ДОКУМЕНТЫ / ОТЧЕТЫ И СТАТИСТИКА API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReportsAndStatisticsApi {
    final DocumentationService service;
    @Operation(summary = "Сохранение отчета и статистики", description = "Этот метод для сохранение отчета и статистики!")
    @PostMapping("/save_reports_and_statistics")
    public SimpleResponse saveReportsAndStatistics(@RequestBody InformationClassRequest request) {
        return service.saveReportsAndStatistics(request);
    }
    @Operation(summary = "Отчеты и статистика", description = "Отчеты и статистика!")
    @GetMapping("/get_all_reports_and_statistics")
    public List<InformationClassResponse> getAllReportsAndStatistics() {
        return service.getAllReportsAndStatistics();
    }
    @Operation(summary = "Удаления отчета и статистики", description = "Этот метод для удаления отчета и статистики!")
    @DeleteMapping("/delete_reports_and_statistics")
    public SimpleResponse deleteReportsAndStatistics(Long id) {
        return service.deleteReportsAndStatistics(id);
    }
    @Operation(summary = "Редактирование отчета и статистики", description = "Этот метод для редактирование отчета и статистики!")
    @PostMapping("/update_reports_and_statistics")
    public SimpleResponse updateReportsAndStatistics(@RequestParam Long id, @RequestBody InformationClassRequest request) {
        return service.updateReportsAndStatistics(request, id);
    }
}
