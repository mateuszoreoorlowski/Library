package spring.library.model.book;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.library.model.person.PhoneNumber;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "publishment")
public class Publishment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "publishment_id", nullable = false)
    private Long publishmentId;

    @Basic
    @Column(name = "publishment_name", nullable = false)
    private String publishmentName;

    @Basic
    @Column(nullable = false)
    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_number_id", referencedColumnName = "id")
    private PhoneNumber phoneNumber;

    @Basic
    @Column(name = "publishment_date", nullable = false)
    private LocalDate publishmentDate;
}
