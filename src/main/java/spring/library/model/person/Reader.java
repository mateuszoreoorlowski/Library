package spring.library.model.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reader")
public class Reader {

    @Id
    @Basic
    private String libraryCardNumber;

    @PrePersist
    private void generateLibraryCardNumber() {
        libraryCardNumber = "LCN_" + generateCustomLibraryCardNumber();
    }

    private String generateCustomLibraryCardNumber() {
        String part1 = generateRandomString(2).toUpperCase();
        String part2 = generateRandomString(5).toUpperCase();
        String part3 = generateRandomString(5).toUpperCase();
        return part1 + "_" + part2 + "_" + part3;
    }

    private String generateRandomString(int length) {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, length);
    }

    @Basic
    @Column(nullable = false)
    private LocalDate registrationDate;


    @OneToMany(
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PhoneNumber> phoneNumbers = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false, updatable = false)
    @NotNull(message = "Person cannot be null")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;


    //TODO add financial penalty (probably needed or not)
}
