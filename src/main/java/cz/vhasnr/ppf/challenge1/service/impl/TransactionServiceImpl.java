package cz.vhasnr.ppf.challenge1.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import cz.vhasnr.ppf.challenge1.persistence.entity.Transaction;
import cz.vhasnr.ppf.challenge1.persistence.repository.TransactionRepository;
import cz.vhasnr.ppf.challenge1.service.TransactionService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAllByAccountId(String accountId) {
        return transactionRepository.findByOwnAccountNumber(accountId).orElse(Collections.emptyList());
    }
}
