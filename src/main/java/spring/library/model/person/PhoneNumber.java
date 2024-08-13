package spring.library.model.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@Value
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Basic
    @NotBlank(message = "Phone number cannot be null or empty")
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{3}", message = "Phone number must be in format XXX-XXX-XXX")
    @Column(name = "number", nullable = false)
    String number;

    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    Reader reader;
}
