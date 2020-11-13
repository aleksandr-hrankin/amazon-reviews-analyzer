package ua.antibyte.analyzer.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "helpfulness_numerator")
    private int helpfulnessNumerator;
    @Column(name = "helpfulness_denominator")
    private int helpfulnessDenominator;
    private int score;
    private LocalDateTime time;
    private String summary;
    @Lob
    private String text;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
}
