package kg.drn.drnback.services;

import kg.drn.drnback.dto.request.EmployeeRequest;
import kg.drn.drnback.dto.request.DefaultRequest;
import kg.drn.drnback.dto.request.HistoryRequest;
import kg.drn.drnback.dto.request.StructureRequest;
import kg.drn.drnback.dto.response.*;

import java.util.List;

public interface AboutUsService {
    SimpleResponse saveHistory(HistoryRequest request);
    SimpleResponse updateHistory(HistoryRequest request);
    SimpleResponse deleteHistory();
    HistoryResponse history();
    SimpleResponse saveEmployee(EmployeeRequest request);
    SimpleResponse updateEmployee(EmployeeRequest request);
    SimpleResponse deleteEmployee(Long id);
    List<EmployeeResponse>getAllEmployee();
    SimpleResponse saveStructure(StructureRequest request);
    SimpleResponse updateStructure(StructureRequest request);
    SimpleResponse deleteStructure();
    StructureResponse structure();
    SimpleResponse saveFunctionsAndTasks(DefaultRequest request);
    SimpleResponse updateFunctionsAndTasks(DefaultRequest request);
    SimpleResponse deleteFunctionsAndTasks();
    FunctionsAndTasksResponse functionsAndTasks();
    SimpleResponse saveNPA(DefaultRequest request);
    SimpleResponse updateNPA(DefaultRequest request,Long id);
    SimpleResponse deleteNPA(Long id);
    List<InformationClassResponse>getAllNPA();
    SimpleResponse saveSymbolism(StructureRequest request);
    SimpleResponse updateSymbolism(StructureRequest request);
    SimpleResponse deleteSymbolism();
    SymbolismResponse symbolism();
}
