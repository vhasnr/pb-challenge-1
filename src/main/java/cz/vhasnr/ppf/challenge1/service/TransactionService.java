package cz.vhasnr.ppf.challenge1.service;

import java.util.List;

import cz.vhasnr.ppf.challenge1.dto.TransactionDto;

public interface TransactionService {

    /**
     * Find transactions for account
     * 
     * @param accountId
     * @return list of all transactions for account or empty list if no transactions
     *         found
     */
    List<TransactionDto> findAllByAccountId(String accountId);

}
