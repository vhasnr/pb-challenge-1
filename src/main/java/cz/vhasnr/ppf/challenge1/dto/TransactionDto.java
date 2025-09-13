package cz.vhasnr.ppf.challenge1.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TransactionDto {

    private AmountDto amount;
    private String bankref;
    private LocalDate bookingDate;
    private CounterPartyAccountDto counterPartyAccount;
    private String creditDebitIndicator;
    private DetailsDto details;
    private String id;
    private String ownAccountNumber;
    private LocalDate postingDate;
    private String productBankRef;
    private String specificSymbol;
    private String statementNumber;
    private String statementPeriod;
    private String transactionId;
    private String transactionType;
    private Integer transactionTypeCode;
    private String variableSymbol;
}
