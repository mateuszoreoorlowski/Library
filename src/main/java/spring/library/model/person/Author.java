package spring.library.model.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.library.model.book.Book;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "author")
public class Author {

    @Id
    private String authorId;

    @PrePersist
    private void generateAuthorId() {
        authorId = "AID_" + generateCustomAuthorId();
    }

    private String generateCustomAuthorId() {
        String part1 = generateRandomString(2).toUpperCase();
        String part2 = generateRandomString(5).toUpperCase();
        String part3 = generateRandomString(5).toUpperCase();
        return part1 + "_" + part2 + "_" + part3;
    }

    private String generateRandomString(int length) {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, length);
    }

    @Basic
    @NotNull(message = "Birth date cannot be null")
    private LocalDate birthDate;

    private LocalDate deathDate = null;

    @Column(nullable = false)
    private LocalDate debutDate;

    private int age; // calculated

    @Column(nullable = false, length = 1000)
    private String biography;

    @Column(nullable = false)
    private String nationality;

    @Transient
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false, updatable = false)
    @NotNull(message = "Person cannot be null")
    private Person person;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

}
