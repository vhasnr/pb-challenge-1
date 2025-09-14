package cz.vhasnr.ppf.challenge1.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import cz.vhasnr.ppf.challenge1.dto.TransactionDto;
import cz.vhasnr.ppf.challenge1.persistence.entity.Transaction;

@Mapper
public interface TransactionMapper {

    List<TransactionDto> toDto(List<Transaction> transactions);

    @Mapping(target = "transactionType", source = "transactionType.type")
    @Mapping(target = "transactionTypeCode", source = "transactionType.code")
    @Mapping(target = "amount.value", source = "amount")
    @Mapping(target = "amount.currency", source = "currency")
    @Mapping(target = "statementNumber", source = "statement.number")
    @Mapping(target = "statementPeriod", source = "statement.period")
    @Mapping(target = "counterPartyAccount.accountName", source = "counterPartyAccount.name")
    @Mapping(target = "counterPartyAccount.accountNumber", source = "counterPartyAccount.number")
    @Mapping(target = "counterPartyAccount.bankCode", source = "counterPartyAccount.code")
    @Mapping(target = "details.detail1", source = "detail1")
    @Mapping(target = "details.detail2", source = "detail2")
    @Mapping(target = "details.detail3", source = "detail3")
    @Mapping(target = "details.detail4", source = "detail4")
    TransactionDto toDto(Transaction transaction);
}
