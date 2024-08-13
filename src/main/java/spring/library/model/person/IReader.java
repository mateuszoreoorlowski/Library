package spring.library.model.person;

import java.time.LocalDate;
import java.util.Set;

public interface IReader {

    Reader asReader();

    default String getLibraryCardNumber() {
        return asReader().getLibraryCardNumber();
    }

    default LocalDate getRegistrationDate() {
        return asReader().getRegistrationDate();
    }

    default void setRegistrationDate(LocalDate registrationDate) {
        asReader().setRegistrationDate(registrationDate);
    }

    default Set<PhoneNumber> getPhoneNumbers() {
        return asReader().getPhoneNumbers();
    }

}
