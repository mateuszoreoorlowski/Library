package spring.library.model.person;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements IReader, ILibriarian, IAuthor {

    @Id
    private String personId;

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String surname;

    @OneToOne(mappedBy = "person", cascade = CascadeType.REMOVE)
    private Reader reader;

    @OneToOne(mappedBy = "person", cascade = CascadeType.REMOVE)
    private Librarian librarian;

    @OneToOne(mappedBy = "person", cascade = CascadeType.REMOVE)
    private Author author;

    @PrePersist
    @PreUpdate
    private void validateAssociations() {
        if (reader != null && (librarian != null || author != null)) {
            throw new IllegalArgumentException("Person cannot be both reader and librarian or author");
        }
    }

    @Override
    public Reader asReader() {
        if (reader == null) {
            throw new IllegalArgumentException("Person is not a reader");
        }
        return reader;
    }

    @Override
    public Librarian asLibrarian() {
        if (librarian == null) {
            throw new IllegalArgumentException("Person is not a librarian");
        }
        return librarian;
    }

    @Override
    public Author asAuthor() {
        if (author == null) {
            throw new IllegalArgumentException("Person is not an author");
        }
        return author;
    }
}
