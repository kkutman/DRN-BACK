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
@RequestMapping("/api/laws")
@RequiredArgsConstructor
@Tag(name = "ДОКУМЕНТЫ / НОРМАТИВНЫЕ ПРАВОВЫЕ АКТЫ API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LawsApi {
    final DocumentationService service;
    @Operation(summary = "Сохранение нормативного прававого акта", description = "Этот метод для сохранение нормативного прававого акта!")
    @PostMapping("/save_laws")
    public SimpleResponse saveLaws(@RequestBody InformationClassRequest request) {
        return service.saveLaws(request);
    }
    @Operation(summary = "Нормативные правовые акты", description = "Нормативные правовые акты!")
    @GetMapping("/get_all_laws")
    public List<InformationClassResponse> getAllLaws() {
        return service.getAllLaws();
    }
    @Operation(summary = "Удаления нормативного прававого акта", description = "Этот метод для удаления нормативного прававого акта!")
    @DeleteMapping("/delete_laws")
    public SimpleResponse deleteLaws(Long id) {
        return service.deleteLaws(id);
    }
    @Operation(summary = "Редактирование нормативного прававого акта", description = "Этот метод для редактирование нормативного прававого акта!")
    @PostMapping("/update_laws")
    public SimpleResponse updateLaws(@RequestParam Long id, @RequestBody InformationClassRequest request) {
        return service.updateLaws(request, id);
    }
}
