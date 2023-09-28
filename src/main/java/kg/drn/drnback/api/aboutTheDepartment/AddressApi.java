package kg.drn.drnback.api.aboutTheDepartment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.dto.request.AddressRequest;
import kg.drn.drnback.dto.response.RegionResponse;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.entity.Region;
import kg.drn.drnback.services.AboutTheDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
@Tag(name = "О ДЕПАРТАМЕНТЕ / ОБЛАСТИ API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressApi {
    final AboutTheDepartmentService service;
    @Operation(summary = "Сохранение адреса", description = "Этот метод для сохранение адреса!")
    @PostMapping("/save_address")
    public SimpleResponse saveAddress(AddressRequest request) {
        return service.saveAddress(request);
    }

    @Operation(summary = "Редактирование адреса", description = "Этот метод для редактирование адреса!")
    @PostMapping("/update_address")
    public SimpleResponse updateAddress(Long addressId, AddressRequest request) {
        return service.updateAddress(request, addressId);
    }

    @Operation(summary = "Удаления адреса", description = "Этот метод для удаления адреса!")
    @DeleteMapping("/delete_address")
    public SimpleResponse deleteAddress(Long id) {
        return service.deleteAddress(id);
    }

    @Operation(summary = "Адрес", description = "Этот метод для адреса!")
    @GetMapping("/get_address")
    public RegionResponse region(Long id) {
        return service.region(id);
    }

    @Operation(summary = "Области", description = "Все области!")
    @GetMapping("/get_all_region")
    public List<Region> getAllRegion() {
        return service.getAllRegion();
    }

}
