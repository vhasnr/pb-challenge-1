package cz.vhasnr.ppf.challenge1.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.vhasnr.ppf.challenge1.dto.TransactionDto;
import cz.vhasnr.ppf.challenge1.service.AccountService;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountService accountService;

    /**
     * 
     * Response code 200 if account found + transaction list in response payload
     * Response code 400 if accountId is invalid (might be to long)
     * Response code 404 if account not found
     * 
     * @param accountId
     * @return
     */
    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<List<TransactionDto>> getAccountTransactions(
            @PathVariable @Size(min = 1, max = 20) String accountId) {
        return ResponseEntity.ok(accountService.findAllByAccountId(accountId));
    }
}
