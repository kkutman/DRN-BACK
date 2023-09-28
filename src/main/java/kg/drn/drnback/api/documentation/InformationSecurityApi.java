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
@RequestMapping("/api/information_security")
@RequiredArgsConstructor
@Tag(name = "ДОКУМЕНТЫ / ИНФОРМАЦИОННАЯ БЕЗОПАСНОСТЬ API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InformationSecurityApi {
    final DocumentationService service;
    @Operation(summary = "Сохранение информационной безопасности", description = "Этот метод для сохранение информационной безопасности!")
    @PostMapping("/save_information_security")
    public SimpleResponse saveInformationSecurity(@RequestBody InformationClassRequest request) {
        return service.saveInformationSecurity(request);
    }
    @Operation(summary = "Информационноые безопасности", description = "Информационноые безопасности!")
    @GetMapping("/get_all_information_security")
    public List<InformationClassResponse> getAllInformationSecurity() {
        return service.getAllInformationSecurity();
    }
    @Operation(summary = "Удаления информационной безопасности", description = "Этот метод для удаления информационной безопасности!")
    @DeleteMapping("/delete_information_security")
    public SimpleResponse deleteInformationSecurity(Long id) {
        return service.deleteInformationSecurity(id);
    }
    @Operation(summary = "Редактирование информационной безопасности", description = "Этот метод для редактирование информационной безопасности!")
    @PostMapping("/update_information_security")
    public SimpleResponse updateInformationSecurity(@RequestParam Long id, @RequestBody InformationClassRequest request) {
        return service.updateInformationSecurity(request, id);
    }
}
