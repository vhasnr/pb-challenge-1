package cz.vhasnr.ppf.challenge1.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import cz.vhasnr.ppf.challenge1.APITestBase;
import cz.vhasnr.ppf.challenge1.persistence.repository.AccountRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class AccountsControllerContainerTest extends APITestBase {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void containerStartsSuccessfully() {
        // This test verifies that the Testcontainers setup works
        // and the application context loads successfully
        assertThat(accountRepository).isNotNull();
    }
}
