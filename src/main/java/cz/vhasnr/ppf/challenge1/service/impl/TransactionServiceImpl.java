package cz.vhasnr.ppf.challenge1.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import cz.vhasnr.ppf.challenge1.dto.TransactionDto;
import cz.vhasnr.ppf.challenge1.mapper.TransactionMapper;
import cz.vhasnr.ppf.challenge1.persistence.entity.Transaction;
import cz.vhasnr.ppf.challenge1.persistence.repository.TransactionRepository;
import cz.vhasnr.ppf.challenge1.service.TransactionService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public List<TransactionDto> findAllByAccountId(String accountId) {
        List<Transaction> transactionList = transactionRepository.findByOwnAccountNumber(accountId)
                .orElse(Collections.emptyList());

        return transactionMapper.toDto(transactionList);
    }
}
