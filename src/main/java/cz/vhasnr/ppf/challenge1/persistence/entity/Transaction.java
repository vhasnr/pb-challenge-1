package cz.vhasnr.ppf.challenge1.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trxId")
    private Long trxId;

    @Column(name = "amount", nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    @Column(name = "id", nullable = false, length = 20)
    private String id;

    @Column(name = "bankref", nullable = false, length = 20)
    private String bankref;

    @Column(name = "transactionId", nullable = false, length = 20)
    private String transactionId;

    @Column(name = "bookingDate")
    private LocalDate bookingDate;

    @Column(name = "postingDate", nullable = false)
    private LocalDate postingDate;

    @Column(name = "creditDebitIndicator", length = 4)
    private String creditDebitIndicator;

    @Column(name = "ownAccountNumber", length = 20)
    private String ownAccountNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "counterPartyAccount", nullable = false)
    private Account counterPartyAccount;

    @Column(name = "detail1", length = 50)
    private String detail1;

    @Column(name = "detail2", length = 50)
    private String detail2;

    @Column(name = "detail3", length = 50)
    private String detail3;

    @Column(name = "detail4", length = 50)
    private String detail4;

    @Column(name = "productBankRef", length = 50)
    private String productBankRef;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transactionType", nullable = false)
    private TransactionType transactionType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statement", nullable = false)
    private Statement statement;

    @Column(name = "constantSymbol", length = 10)
    private String constantSymbol;

    @Column(name = "specificSymbol", length = 10)
    private String specificSymbol;

    @Column(name = "variableSymbol", length = 10)
    private String variableSymbol;
}
