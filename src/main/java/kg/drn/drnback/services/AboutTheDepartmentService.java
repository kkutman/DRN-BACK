package kg.drn.drnback.services;

import kg.drn.drnback.dto.request.*;
import kg.drn.drnback.dto.response.*;
import kg.drn.drnback.entity.Region;

import java.util.List;

public interface AboutTheDepartmentService {
    //-история
    SimpleResponse saveHistory(DefaultRequest request);

    SimpleResponse updateHistory(DefaultRequest request);

    SimpleResponse deleteHistory();

    DefaultResponse history();

    // -руководство
    SimpleResponse saveEmployee(EmployeeRequest request);

    SimpleResponse updateEmployee(EmployeeRequest request, Long id);

    SimpleResponse deleteEmployee(Long id);

    List<EmployeeResponse> getAllEmployee();

    // -структура
    SimpleResponse saveStructure(StructureRequest request);

    SimpleResponse updateStructure(StructureRequest request);

    SimpleResponse deleteStructure();

    StructureResponse structure();

    //-символика
    SimpleResponse saveSymbolism(SymbolismRequest request);

    SimpleResponse updateSymbolism(SymbolismRequest request);

    SimpleResponse deleteSymbolism();

    SymbolismResponse symbolism();

    //-контакты
    SimpleResponse saveContact(ContactsRequest request);

    SimpleResponse updateContact(ContactsRequest request);

    SimpleResponse deleteContact();

    ContactsResponse contact();

    //-территориальные подразделения(области)
    SimpleResponse saveAddress(AddressRequest request);

    SimpleResponse updateAddress(AddressRequest request, Long addressId);

    SimpleResponse deleteAddress(Long id);

    RegionResponse region(Long id);
    List<Region>getAllRegion();

    // -положение
    SimpleResponse saveNPA(InformationClassRequest request);

    SimpleResponse updateNPA(InformationClassRequest request, Long id);

    SimpleResponse deleteNPA(Long id);

    List<InformationClassResponse> getAllNPA();

}
