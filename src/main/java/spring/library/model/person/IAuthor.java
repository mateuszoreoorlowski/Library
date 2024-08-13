package spring.library.model.person;

import java.time.LocalDate;

public interface IAuthor {

    Author asAuthor();

    default LocalDate getBirthDate() {
        return asAuthor().getBirthDate();
    }

    default void setBirthDate(LocalDate birthDate) {
        asAuthor().setBirthDate(birthDate);
    }

    default LocalDate getDeathDate() {
        return asAuthor().getDeathDate();
    }

    default void setDeathDate(LocalDate deathDate) {
        asAuthor().setDeathDate(deathDate);
    }

    default LocalDate getDebutDate() {
        return asAuthor().getDebutDate();
    }

    default void setDebutDate(LocalDate debutDate) {
        asAuthor().setDebutDate(debutDate);
    }

    default String getBiography() {
        return asAuthor().getBiography();
    }

    default void setBiography(String biography) {
        asAuthor().setBiography(biography);
    }

    default String getNationality() {
        return asAuthor().getNationality();
    }

    default void setNationality(String nationality) {
        asAuthor().setNationality(nationality);
    }

}
