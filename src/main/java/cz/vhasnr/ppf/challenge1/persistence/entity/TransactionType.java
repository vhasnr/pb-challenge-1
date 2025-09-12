package cz.vhasnr.ppf.challenge1.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "transactionType")
@Data
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trxTypeId")
    private Long trxTypeId;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "code", nullable = false)
    private Integer code;
}
