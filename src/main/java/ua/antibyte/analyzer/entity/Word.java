package ua.antibyte.analyzer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "words")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Word {
    @Id
    private String word;
    private Integer count;
}
