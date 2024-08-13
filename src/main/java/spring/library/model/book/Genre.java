package spring.library.model.book;

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
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "genre_id", nullable = false)
    private Long genreId;

    @Basic
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
