package kg.drn.drnback.api.aboutTheDepartment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.dto.request.HistoryRequest;
import kg.drn.drnback.dto.response.HistoryResponse;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.services.AboutTheDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
@Tag(name = "О ДЕПАРТАМЕНТЕ / ИСТОРИЯ API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HistoryApi {
    final AboutTheDepartmentService service;

    @Operation(summary = "Сохранение историй", description = "Этот метод для сохранение историй!")
    @PostMapping("/save_history")
    public SimpleResponse saveHistory(@RequestBody HistoryRequest request) {
        return service.saveHistory(request);
    }

    @Operation(summary = "Редактирование историй", description = "Этот метод для редактирование историй!")
    @PostMapping("/update_history")
    public SimpleResponse updateHistory(@RequestBody HistoryRequest request) {
        return service.updateHistory(request);
    }

    @Operation(summary = "Удаления историй", description = "Этот метод для удаления историй!")
    @DeleteMapping("/delete_history")
    public SimpleResponse deleteHistory() {
        return service.deleteHistory();
    }

    @Operation(summary = "История", description = "Этот метод для историй!")
    @GetMapping("/get_history")
    public HistoryResponse history() {
        return service.history();
    }
}
