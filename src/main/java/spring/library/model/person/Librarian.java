package spring.library.model.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "librarian")
public class Librarian {

    public enum WorkChange { PORANNA, POPOLUDNIOWA, NOCNA}

    @Id
    private String workerId;

    @PrePersist
    private void generateWorkerId() {
        workerId = "WID_" + generateCustomWorkerId();
    }

    private String generateCustomWorkerId() {
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
    private LocalDate employmentDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkChange workChange;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false, updatable = false)
    @NotNull(message = "Person cannot be null")
    private Person person;

}
