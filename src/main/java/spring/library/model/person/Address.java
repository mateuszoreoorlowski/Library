package spring.library.model.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "address")
public class Address {

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id")
    private Long id;

    @Basic
    @Column(nullable = false)
    private String street;

    @Basic
    @Column(nullable = false)
    private int buildingNumber;

    @Basic
    @Column(nullable = false)
    private int flatNumber;

    @Basic
    @Column(nullable = false)
    private String city;

    @Basic
    @Column(nullable = false)
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Postal code must be in format XX-XXX")
    private String postalCode;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reader> readers = new HashSet<>();

}
