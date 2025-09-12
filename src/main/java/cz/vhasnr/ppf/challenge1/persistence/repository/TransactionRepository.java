package cz.vhasnr.ppf.challenge1.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.vhasnr.ppf.challenge1.persistence.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    /**
     * Find transactions by owning account number
     * 
     * @param accountId
     * @return
     */
    Optional<List<Transaction>> findByOwnAccountNumber(String accountId);
}
