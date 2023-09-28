package kg.drn.drnback.api.aboutTheDepartment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.dto.request.ContactsRequest;
import kg.drn.drnback.dto.response.ContactsResponse;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.services.AboutTheDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
@Tag(name = "О ДЕПАРТАМЕНТЕ / КОНТАКТЫ API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactApi {
    final AboutTheDepartmentService service;

    @Operation(summary = "Сохранение контакта", description = "Этот метод для сохранение контакта!")
    @PostMapping("/save_contact")
    public SimpleResponse saveContact(@RequestBody ContactsRequest request) {
        return service.saveContact(request);
    }

    @Operation(summary = "Редактирование контакта", description = "Этот метод для редактирование контакта!")
    @PostMapping("/update_contact")
    public SimpleResponse updateContact(@RequestBody ContactsRequest request) {
        return service.updateContact(request);
    }

    @Operation(summary = "Удаления контакта", description = "Этот метод для удаления контакта!")
    @DeleteMapping("/delete_contact")
    public SimpleResponse deleteContact() {
        return service.deleteContact();
    }

    @Operation(summary = "Контакт", description = "Этот метод для контакта!")
    @GetMapping("/get_contact")
    public ContactsResponse contact() {
        return service.contact();
    }
}
