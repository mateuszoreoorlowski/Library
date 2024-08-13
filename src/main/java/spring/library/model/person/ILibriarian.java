package spring.library.model.person;

import java.time.LocalDate;

public interface ILibriarian {

    Librarian asLibrarian();

    default LocalDate getEmploymentDate() {
        return asLibrarian().getEmploymentDate();
    }

    default void setEmploymentDate(LocalDate employmentDate) {
        asLibrarian().setEmploymentDate(employmentDate);
    }

    default Librarian.WorkChange getWorkChange() {
        return asLibrarian().getWorkChange();
    }

    default void setWorkChange(Librarian.WorkChange workChange) {
        asLibrarian().setWorkChange(workChange);
    }


}
