package cz.vhasnr.ppf.challenge1.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.vhasnr.ppf.challenge1.persistence.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Check if account exists by number
     */
    boolean existsByNumber(String number);

}
