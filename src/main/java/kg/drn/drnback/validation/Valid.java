package kg.drn.drnback.validation;

public interface Valid {
    String textValid(String text);
    String subjectValid(String text);
    String nameValid(String name, String type);
    String addressNameValid(String name,String type);
    String imageValid(String img);
    String emailValid(String email);
    String emailValid2(String email);
    String phoneNumberValid(String phoneNumber);
    String contactPhoneNumberValid(String phoneNumber,String message);
    String addressAndJobValid(String str,String name);
}
