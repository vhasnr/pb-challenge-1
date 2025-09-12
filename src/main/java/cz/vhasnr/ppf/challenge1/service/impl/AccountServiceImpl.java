package cz.vhasnr.ppf.challenge1.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import cz.vhasnr.ppf.challenge1.persistence.entity.Transaction;
import cz.vhasnr.ppf.challenge1.persistence.repository.AccountRepository;
import cz.vhasnr.ppf.challenge1.service.AccountService;
import cz.vhasnr.ppf.challenge1.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    @Override
    public List<Transaction> findAllByAccountId(String accountId) {

        // Throw 404 if account not found
        if (!accountRepository.existsByNumber(accountId)) {
            log.error("Account not found in AccountServiceImpl for accountId: {}", accountId);
            ErrorResponseException exception = new ErrorResponseException(HttpStatus.NOT_FOUND);
            exception.setTitle("Account not found");
            throw exception;
        }

        return transactionService.findAllByAccountId(accountId);
    }
}
