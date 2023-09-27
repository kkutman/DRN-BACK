package kg.drn.drnback.validation;

import kg.drn.drnback.exception.exceptions.BadRequestException;
import kg.drn.drnback.repository.EmployeeRepository;
import kg.drn.drnback.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Validation implements Valid {
    final EmployeeRepository employeeRepository;

    @Override
    public String textValid(String text) {
        if (text.length() > 15000 || text.length() < 5)
            throw new BadRequestException("Текст не должен перевышать длину 15000" +
                                          " символов и не должен быть меньше 5 символов");
        return text;
    }

    @Override
    public String subjectValid(String text) {
        if (text.length() > 1000 || text.length() < 3)
            throw new BadRequestException("Тема не должен перевышать длину 1000 " +
                                          "символов и не должен быть меньше 3 символов");
        return text;
    }

    @Override
    public String nameValid(String name, String type) {
        if (!name.matches("^[a-zA-Zа-яА-Я]+$") || name.length() <= 3 || name.length() >= 33)
            throw new BadRequestException(type + " не должно превышать 33 символа и не должно быть короче" +
                                          " 3 символов. Оно также не должно содержать цифры.");
        return name;
    }

    @Override
    public String addressNameValid(String name, String type) {
        if (name.length() <= 1 || name.length() >= 100)
            throw new BadRequestException(type+" не должно превышать 100 символа и не должно быть короче" +
                                          " 1 символа.");
        return name;
    }

    @Override
    public String imageValid(String img) {
        if (img.length() > 1500 || img.length() < 1)
            throw new BadRequestException("URL изображения не должен перевышать длину 1000 ");
        return img;
    }

    @Override
    public String emailValid(String email) {
        if (!email.contains("@gmail.com") || email.split("@")[1].length()==10)
            throw new BadRequestException("Напишите действительный адрес электронной почты!");
        if (employeeRepository.existsByEmail(email))
            throw new BadRequestException("Работник с такой электронной почтой уже сушествует!");
        return email;
    }

    @Override
    public String phoneNumberValid(String phoneNumber) {
        if (!phoneNumber.contains("+996") || phoneNumber.length() != 13)
            throw new BadRequestException("Телефонный номер должен содержать \"+996\" и быть в длину 13 символов!");
        return phoneNumber;
    }

    @Override
    public String emailValid2(String email) {
        if (!email.contains("@gmail.com") || email.split("@")[1].length()==10)
            throw new BadRequestException("Напишите действительный адрес электронной почты!");
        return email;
    }

    @Override
    public String addressAndJobValid(String str,String name) {
        if (str.length() > 1500 || str.length() < 1)
            throw new BadRequestException("Длина"+name+" не должен перевышать 1000 символов ");
        return str;
    }

    @Override
    public String contactPhoneNumberValid(String phoneNumber, String message) {
        if (!phoneNumber.contains("+996") || phoneNumber.length() != 13)
            throw new BadRequestException("Номер "+message+" должен содержать \"+996\" и быть в длину 13 символов!");
        return phoneNumber;
    }
}
