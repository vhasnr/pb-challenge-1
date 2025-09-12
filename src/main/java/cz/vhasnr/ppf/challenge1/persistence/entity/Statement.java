package cz.vhasnr.ppf.challenge1.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "statement")
@Data
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statementId")
    private Long statementId;

    @Column(name = "number", nullable = false, length = 20)
    private String number;

    @Column(name = "period", nullable = false, length = 20)
    private String period;

    @Column(name = "description", length = 1000)
    private String description;
}
