package kg.drn.drnback.services;

import kg.drn.drnback.dto.request.*;
import kg.drn.drnback.dto.response.*;

import java.util.List;

public interface AboutTheDepartmentService {
    //-история
    SimpleResponse saveHistory(HistoryRequest request);
    SimpleResponse updateHistory(HistoryRequest request);
    SimpleResponse deleteHistory();
    HistoryResponse history();

    // -руководство
    SimpleResponse saveEmployee(EmployeeRequest request);
    SimpleResponse updateEmployee(EmployeeRequest request);
    SimpleResponse deleteEmployee(Long id);
    List<EmployeeResponse>getAllEmployee();

    // -структура
    SimpleResponse saveStructure(StructureRequest request);
    SimpleResponse updateStructure(StructureRequest request);
    SimpleResponse deleteStructure();
    StructureResponse structure();

    //-символика
    SimpleResponse saveSymbolism(StructureRequest request);
    SimpleResponse updateSymbolism(StructureRequest request);
    SimpleResponse deleteSymbolism();
    SymbolismResponse symbolism();

    //-контакты
    SimpleResponse saveContact(StructureRequest request);
    SimpleResponse updateContact(StructureRequest request);
    SimpleResponse deleteContact();
    ContactsResponse contact();

    //-территориальные подразделения(области)
    SimpleResponse saveAddress(AddressRequest request);
    SimpleResponse updateAddress(AddressRequest request);
    SimpleResponse deleteAddress(AddressRequest request);
    RegionResponse region(Long id);

    // -положение
    SimpleResponse saveNPA(DefaultRequest request);
    SimpleResponse updateNPA(DefaultRequest request,Long id);
    SimpleResponse deleteNPA(Long id);
    List<InformationClassResponse>getAllNPA();

}
