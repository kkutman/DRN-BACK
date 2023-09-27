package kg.drn.drnback.services.impl;

import kg.drn.drnback.dto.request.*;
import kg.drn.drnback.dto.response.*;
import kg.drn.drnback.entity.*;
import kg.drn.drnback.entity.enums.EmployeeType;
import kg.drn.drnback.entity.enums.InformationClassType;
import kg.drn.drnback.entity.enums.RegionType;
import kg.drn.drnback.entity.enums.SubCategoryType;
import kg.drn.drnback.exception.exceptions.BadRequestException;
import kg.drn.drnback.exception.exceptions.NotFoundException;
import kg.drn.drnback.mapper.InformationSubClassMapper;
import kg.drn.drnback.repository.*;
import kg.drn.drnback.repository.custom.AddressRepositoryCustom;
import kg.drn.drnback.repository.custom.EmployeeRepositoryCustom;
import kg.drn.drnback.repository.custom.InformationRepositoryCustom;
import kg.drn.drnback.services.AboutTheDepartmentService;
import kg.drn.drnback.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AboutTheDepartmentServiceImpl implements AboutTheDepartmentService {
    final TextRepository textRepository;
    final EmployeeRepository employeeRepository;
    final Valid validation;
    final EmployeeRepositoryCustom employeeRepositoryCustom;
    final AddressRepositoryCustom addressRepositoryCustom;
    final ContactsRepository contactsRepository;
    final RegionRepository regionRepository;
    final AddressRepository addressRepository;
    final InformationClassRepository informationClassRepository;
    final InformationRepositoryCustom informationRepositoryCustom;

    Text getText(SubCategoryType type, String message) {
        return textRepository.findBySubCategoryType(type).orElseThrow(
                () -> new BadRequestException(message));
    }

    Contacts getContact() {
        return contactsRepository.findBySubCategoryType(SubCategoryType.CONTACT).orElseThrow(
                () -> new NotFoundException("Контакт не сохранен!"));
    }

    @Override
    public SimpleResponse saveHistory(HistoryRequest request) {
        if (textRepository.existsBySubCategoryType(SubCategoryType.HISTORY)) {
            return SimpleResponse.builder().status(HttpStatus.BAD_REQUEST).message("История уже есть!").build();
        }
        textRepository.save(Text.builder()
                .subject(validation.subjectValid(request.subject()))
                .text(validation.textValid(request.text()))
                .subCategoryType(SubCategoryType.HISTORY)
                .build());
        log.info("История успешно сохранена!");
        return SimpleResponse.builder().message("История успешно сохранена!")
                .status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse updateHistory(HistoryRequest request) {
        Text text = getText(SubCategoryType.HISTORY, "История не сохранена");
        text.setText(validation.textValid(request.text()));
        text.setSubject(validation.subjectValid(request.subject()));
        textRepository.save(text);
        log.info("История успешно обновлена!");
        return SimpleResponse.builder().message("История успешно обновлена!")
                .status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse deleteHistory() {
        textRepository.delete(getText(SubCategoryType.HISTORY, "История не сохранена"));
        log.info("История успешно удалена!");
        return SimpleResponse.builder().message("История успешно удалена!")
                .status(HttpStatus.OK).build();
    }

    @Override
    public HistoryResponse history() {
        Text text = getText(SubCategoryType.HISTORY, "История не сохранена");
        log.info("История взята!");
        return HistoryResponse.builder().history(text.getText()).subject(text.getSubject()).build();
    }


    @Override
    public SimpleResponse saveEmployee(EmployeeRequest request) {
        System.out.println(request.address());
        employeeRepository.save(
                Employee.builder()
                        .firstName(validation.nameValid(request.firstName(), "Имя"))
                        .lastName(validation.nameValid(request.lastName(), "Фамилия"))
                        .surname(validation.nameValid(request.surname(), "Отчество"))
                        .phoneNumber(validation.phoneNumberValid(request.phoneNumber()))
                        .image(validation.imageValid(request.image()))
                        .email(validation.emailValid(request.email()))
                        .region(RegionType.valueOf(request.region().toUpperCase()))
                        .jobTitle(validation.addressAndJobValid(request.jobTitle(), "должностя"))
                        .address(validation.addressAndJobValid(request.address(), "адреса"))
                        .employeeType(EmployeeType.GUIDELINES)
                        .build());
        log.info("Работник успешно сохранен!");
        return SimpleResponse.builder().message("Работник успешно сохранен!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse updateEmployee(EmployeeRequest request, Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Работник с id %s не найден", id)));
        if (!request.firstName().isEmpty()) employee.setFirstName(validation.nameValid(request.firstName(), "Имя"));
        if (!request.lastName().isEmpty()) employee.setLastName(validation.nameValid(request.lastName(), "Фамилия"));
        if (!request.surname().isEmpty()) employee.setSurname(validation.nameValid(request.surname(), "Отчество"));
        if (!request.phoneNumber().isEmpty())
            employee.setPhoneNumber(validation.phoneNumberValid(request.phoneNumber()));
        if (!request.image().isEmpty()) employee.setImage(validation.imageValid(request.image()));
        if (!request.email().isEmpty()) employee.setEmail(validation.emailValid2(request.email()));
        if (!request.region().isEmpty()) employee.setRegion(RegionType.valueOf(request.region().toUpperCase()));
        if (!request.jobTitle().isEmpty())
            employee.setJobTitle(validation.addressAndJobValid(request.jobTitle(), "должностя"));
        if (!request.address().isEmpty())
            employee.setAddress(validation.addressAndJobValid(request.address(), "адреса"));
        log.info("Работник успешно обнавлен!");
        return SimpleResponse.builder().message("Работник успешно обнавлен!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse deleteEmployee(Long id) {
        employeeRepository.delete(employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Работник с id %s не найден", id))));
        log.info("Работник успешно удален!");
        return SimpleResponse.builder().message("Работник успешно удален!").status(HttpStatus.OK).build();
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        log.info("Работники взяты!");
        return employeeRepositoryCustom.getAllEmployeeResponse();
    }


    @Override
    public SimpleResponse saveStructure(StructureRequest request) {
        if (textRepository.existsBySubCategoryType(SubCategoryType.STRUCTURE)) {
            return SimpleResponse.builder().status(HttpStatus.BAD_REQUEST).message("Стуктура уже есть!").build();
        }
        textRepository.save(Text.builder()
                .image(validation.imageValid(request.image()))
                .text(validation.textValid(request.text()))
                .subCategoryType(SubCategoryType.STRUCTURE)
                .build());
        log.info("Структура успешно сохранено!");
        return SimpleResponse.builder().message("Структура успешно сохранено!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse updateStructure(StructureRequest request) {
        Text text = getText(SubCategoryType.STRUCTURE, "Структура не сохранена");
        if (request.text() != null) text.setText(validation.textValid(request.text()));
        if (request.image() != null) text.setImage(validation.imageValid(request.image()));
        textRepository.save(text);
        log.info("Структура успешно обнавлена!");
        return SimpleResponse.builder().message("Структура успешно обнавлена!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse deleteStructure() {
        textRepository.delete(getText(SubCategoryType.STRUCTURE, "Структура не сохранена"));
        log.info("Структура успешно удалена!");
        return SimpleResponse.builder().message("Структура успешно удалена!").status(HttpStatus.OK).build();
    }

    @Override
    public StructureResponse structure() {
        Text text = getText(SubCategoryType.STRUCTURE, "Структура не сохранена");
        log.info("Структура взята");
        return StructureResponse.builder().text(text.getText()).image(text.getImage()).build();
    }


    @Override
    public SimpleResponse saveSymbolism(SymbolismRequest request) {
        if (textRepository.existsBySubCategoryType(SubCategoryType.SYMBOLISM)) {
            return SimpleResponse.builder().status(HttpStatus.BAD_REQUEST).message("Символика уже есть!").build();
        }
        textRepository.save(Text.builder()
                .image(validation.imageValid(request.symbolism()))
                .subject(validation.subjectValid(request.subject()))
                .text(validation.textValid(request.text()))
                .subCategoryType(SubCategoryType.SYMBOLISM)
                .build());
        log.info("Символика успешно сохранено!");
        return SimpleResponse.builder().message("Символика успешно сохранено!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse updateSymbolism(SymbolismRequest request) {
        Text text = getText(SubCategoryType.SYMBOLISM, "Символика не сохранена");
        if (request.text() != null) text.setText(validation.textValid(request.text()));
        if (request.symbolism() != null) text.setImage(validation.imageValid(request.symbolism()));
        if (request.subject() != null) text.setSubject(validation.subjectValid(request.subject()));
        textRepository.save(text);
        log.info("Символика успешно обнавлена!");
        return SimpleResponse.builder().message("Символика успешно обнавлена!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse deleteSymbolism() {
        textRepository.delete(getText(SubCategoryType.SYMBOLISM, "Символика не сохранена"));
        log.info("Символика успешно удалена!");
        return SimpleResponse.builder().message("Символика успешно удалена!").status(HttpStatus.OK).build();

    }

    @Override
    public SymbolismResponse symbolism() {
        Text text = getText(SubCategoryType.SYMBOLISM, "Символика не сохранена");
        log.info("Символика взята");
        return SymbolismResponse.builder().symbolism(text.getImage()).text(text.getText()).subject(text.getSubject()).build();
    }


    @Override
    public SimpleResponse saveContact(ContactsRequest request) {
        if (contactsRepository.existsBySubCategoryType(SubCategoryType.CONTACT)) {
            return SimpleResponse.builder().status(HttpStatus.OK).message("Контакт ранее уже был сохранен!").build();
        }
        contactsRepository.save(Contacts.builder()
                .commonDepartment(validation.contactPhoneNumberValid(request.commonDepartment(), "обшего отдела"))
                .pressService(validation.contactPhoneNumberValid(request.pressService(), "пресс-центра"))
                .fax(validation.contactPhoneNumberValid(request.fax(), "факса"))
                .reception(validation.contactPhoneNumberValid(request.reception(), "приемного отдела"))
                .callCentre(validation.contactPhoneNumberValid(request.callCentre(), "call-centre"))
                .generalReception(validation.contactPhoneNumberValid(request.generalReception(), "обшего приема"))
                .email(validation.emailValid(request.email()))
                .twoGISLink(request.twoGISLink())
                .subCategoryType(SubCategoryType.CONTACT)
                .build());
        log.info("Контакт сохранен успешно!");
        return SimpleResponse.builder().status(HttpStatus.OK).message("Контакт сохранен успешно!").build();
    }

    @Override
    public SimpleResponse updateContact(ContactsRequest request) {
        Contacts contacts = getContact();
        if (request.commonDepartment() != null)
            contacts.setCommonDepartment(validation.contactPhoneNumberValid(request.commonDepartment(), "обшего отдела"));
        if (request.pressService() != null)
            contacts.setPressService(validation.contactPhoneNumberValid(request.pressService(), "пресс-центра"));
        if (request.fax() != null) contacts.setFax(validation.contactPhoneNumberValid(request.fax(), "факса"));
        if (request.reception() != null)
            contacts.setReception(validation.contactPhoneNumberValid(request.reception(), "приемного отдела"));
        if (request.callCentre() != null)
            contacts.setCallCentre(validation.contactPhoneNumberValid(request.callCentre(), "call-centre"));
        if (request.generalReception() != null)
            contacts.setGeneralReception((validation.contactPhoneNumberValid(request.generalReception(), "обшего приема")));
        if (request.email() != null) contacts.setEmail(validation.emailValid(request.email()));
        if (request.twoGISLink() != null) contacts.setTwoGISLink(request.twoGISLink());
        contactsRepository.save(contacts);
        log.info("Контакт сохранен обнавлен!");
        return SimpleResponse.builder().status(HttpStatus.OK).message("Контакт сохранен обнавлен!").build();
    }

    @Override
    public SimpleResponse deleteContact() {
        contactsRepository.delete(getContact());
        log.info("Контакт сохранен удален!");
        return SimpleResponse.builder().status(HttpStatus.OK).message("Контакт сохранен удален!").build();
    }

    @Override
    public ContactsResponse contact() {
        Contacts contacts = getContact();
        log.info("Контакт взят!");
        return ContactsResponse.builder()
                .callCentre(contacts.getCallCentre())
                .commonDepartment(contacts.getCommonDepartment())
                .pressService(contacts.getPressService())
                .reception(contacts.getReception())
                .twoGISLink(contacts.getTwoGISLink())
                .email(contacts.getEmail())
                .fax(contacts.getFax())
                .generalReception(contacts.getGeneralReception())
                .build();
    }


    @Override
    public SimpleResponse saveAddress(AddressRequest request) {
        addressRepository.save(Address.builder()
                .name(validation.addressNameValid(request.name(), "Название "))
                .address(validation.addressNameValid(request.address(), "Адрес "))
                .city(validation.addressAndJobValid(request.city(), "Город "))
                .phoneNumber(validation.phoneNumberValid(request.phoneNumber()))
                .region(regionRepository.findById(request.regionId())
                        .orElseThrow(() -> new NotFoundException(String.format(
                                "Регион с id %s не найден, регион 1-10", request.regionId()))))
                .build());
        log.info("Адрес сохранен успешно!");
        return SimpleResponse.builder().message("Адрес сохранен успешно!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse updateAddress(AddressRequest request, Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new NotFoundException(String.format("Адрес с id %s не найден", addressId)));
        if (request.name() != null) address.setName(validation.addressNameValid(request.name(), "Название "));
        if (request.address() != null) address.setAddress(validation.addressNameValid(request.address(), "Адрес "));
        if (request.city() != null) address.setCity(validation.addressAndJobValid(request.city(), "Город "));
        if (request.phoneNumber() != null) address.setPhoneNumber(validation.phoneNumberValid(request.phoneNumber()));
        if (request.regionId() != null) address.setRegion(regionRepository.findById(request.regionId())
                .orElseThrow(() -> new NotFoundException(String.format(
                        "Регион с id %s не найден, регион 1-10", request.regionId()))));
        addressRepository.save(address);
        log.info("Адрес обнавлен успешно!");
        return SimpleResponse.builder().message("Адрес обнавлен успешно!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse deleteAddress(Long id) {
        addressRepository.delete(addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Адрес с id %s не найден", id))));
        log.info("Адрес успешно удален!");
        return SimpleResponse.builder().message("Адрес успешно удален!").status(HttpStatus.OK).build();
    }

    @Override
    public RegionResponse region(Long id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(
                        "Регион с id %s не найден, регион 1-10", id)));
        return RegionResponse.builder()
                .name(region.getRegionName())
                .address(addressRepositoryCustom.getAllAddressByRegionId(id))
                .build();
    }


    @Override
    public SimpleResponse saveNPA(InformationClassRequest request) {
        InformationClass informationClass = InformationClass
                .builder()
                .subject(validation.subjectValid(request.subject()))
                .createAt(LocalDate.now())
                .type(InformationClassType.POSITION)
                .build();
        informationClass.setInformationSubClasses(new InformationSubClassMapper().dtoToEntity(request.informationSubClassRequests(), informationClass));
        informationClassRepository.save(informationClass);
        log.info("Положение успешно сохранено!");
        return SimpleResponse.builder().message("Положение успешно сохранено!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse updateNPA(InformationClassRequest request, Long id) {
        InformationClass informationClass = informationClassRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Положение c id %s не найден!", id)));
        System.out.println(request.toString());
//        informationClass.setInformationSubClasses(new InformationSubClassMapper().dtoToEntity(request.informationSubClassRequests(), informationClass));
        if (request.subject()!=null)informationClass.setSubject(request.subject());
        informationClassRepository.save(informationClass);
        log.info("Положение успешно обнавлено!");
        return SimpleResponse.builder().message("Положение успешно обнавлено!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse deleteNPA(Long id) {
        informationClassRepository.delete(informationClassRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Положение c id %s не найден!", id))));
        log.info("Положение успешно удалена!");
        return SimpleResponse.builder().message("Положение успешно удалена!").status(HttpStatus.OK).build();
    }

    @Override
    public List<InformationClassResponse> getAllNPA() {
        return informationRepositoryCustom.getAllInformationClass();
    }
}
