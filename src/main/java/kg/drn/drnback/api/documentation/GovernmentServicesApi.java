package kg.drn.drnback.api.documentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.dto.request.InformationClassRequest;
import kg.drn.drnback.dto.response.InformationClassResponse;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.entity.enums.PdfType;
import kg.drn.drnback.services.DocumentationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/information_security")
@RequiredArgsConstructor
@Tag(name = "ДОКУМЕНТЫ / РЕГЛАМЕНТ ГОСУСЛУГ И СТАНДАРТЫ ГОСУСЛУГ API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GovernmentServicesApi {
    final DocumentationService service;
    @Operation(summary = "Сохранение регламента госуслуг", description = "Этот метод для сохранение регламента госуслуг!")
    @PostMapping("/save_government_service")
    public SimpleResponse saveGovernmentServicesStandards(@RequestParam String pdf) {
        return service.saveGovernmentServicesStandards(pdf);
    }
    @Operation(summary = "Удаление регламента госуслуг", description = "Этот метод для удаление регламента госуслуг!")
    @DeleteMapping("/delete_government_service")
    public SimpleResponse deleteGovernmentServicesStandards() {
        return service.deleteGovernmentServicesStandards();
    }

    @Operation(summary = "Сохранение стандартов госуслуг", description = "Этот метод для сохранение стандартов госуслуг!")
    @PostMapping("/save_regulations_public_service")
    public SimpleResponse saveRegulationsPublicServices(@RequestParam String pdf) {
        return service.saveRegulationsPublicServices(pdf);
    }

    @Operation(summary = "Удаление стандартов госуслуг", description = "Этот метод для удаление стандартов госуслуг!")
    @DeleteMapping("/delete_regulations_public_service")
    public SimpleResponse deleteRegulationsPublicServices() {
        return service.deleteRegulationsPublicServices();
    }

    @Operation(summary = "Регламент госуслуг", description = "PDF регламента госуслуг!")
    @GetMapping("/regulations_public_service")
    public String regulationsPublicServices() {
        return service.getPdf(PdfType.REGULATION_PUBLIC_SERVICE);
    }

    @Operation(summary = "Стандарты госуслуг", description = "PDF стандарта госуслуг!")
    @GetMapping("/government_service")
    public String governmentServicesStandards() {
        return service.getPdf(PdfType.GOVERNMENT_SERVICE_STANDARDS);
    }
}
