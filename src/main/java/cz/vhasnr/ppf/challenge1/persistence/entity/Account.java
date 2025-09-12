package cz.vhasnr.ppf.challenge1.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Long accountId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "number", nullable = false, length = 20)
    private String number;

    @Column(name = "code", nullable = false, length = 4)
    private String code;
}
