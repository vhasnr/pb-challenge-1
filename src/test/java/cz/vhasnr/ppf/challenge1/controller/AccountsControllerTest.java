package cz.vhasnr.ppf.challenge1.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.fasterxml.jackson.databind.ObjectMapper;

import cz.vhasnr.ppf.challenge1.dto.TransactionDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Testcontainers
@AutoConfigureMockMvc
public class AccountsControllerTest {

    @Container
    static MSSQLServerContainer<?> mssqlServer = new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2022-latest")
            .acceptLicense()
            .withPassword("83edb36d-f757-4f0d-9ed3-d31299b993dc");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mssqlServer::getJdbcUrl);
        registry.add("spring.datasource.username", mssqlServer::getUsername);
        registry.add("spring.datasource.password", mssqlServer::getPassword);
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Sql(scripts = "/test-data-valid-account.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getAccountTransactions_ValidAccountId_ReturnsTransactions() throws Exception {
        // Given - account ID that exists in test data
        String accountId = "2002222222";

        // When
        MvcResult result = mockMvc.perform(get("/accounts/{accountId}/transactions", accountId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Then
        String responseContent = result.getResponse().getContentAsString();
        List<TransactionDto> transactions = objectMapper.readValue(responseContent, 
                objectMapper.getTypeFactory().constructCollectionType(List.class, TransactionDto.class));

        // Should have at least 3 transactions for account 2002222222 based on test data
        // Note: Data accumulates between tests, so we check for at least the expected number
        assertThat(transactions).hasSizeGreaterThanOrEqualTo(3);
        
        // Verify first transaction (TXN001)
        TransactionDto firstTransaction = transactions.get(0);
        assertThat(firstTransaction.getId()).isEqualTo("TXN001");
        assertThat(firstTransaction.getAmount().getValue()).isEqualTo(1000);
        assertThat(firstTransaction.getAmount().getCurrency()).isEqualTo("CZK");
        assertThat(firstTransaction.getBankref()).isEqualTo("BR001");
        assertThat(firstTransaction.getTransactionId()).isEqualTo("TRX001");
        assertThat(firstTransaction.getCreditDebitIndicator()).isEqualTo("CRDT");
        assertThat(firstTransaction.getOwnAccountNumber()).isEqualTo("2002222222");
        assertThat(firstTransaction.getDetails().getDetail1()).isEqualTo("Payment received");
        assertThat(firstTransaction.getDetails().getDetail2()).isEqualTo("From customer");
        assertThat(firstTransaction.getDetails().getDetail3()).isEqualTo("Invoice #12345");
        assertThat(firstTransaction.getDetails().getDetail4()).isEqualTo("Reference: REF001");
        assertThat(firstTransaction.getProductBankRef()).isEqualTo("PBR001");
        assertThat(firstTransaction.getTransactionType()).isEqualTo("Transfer");
        assertThat(firstTransaction.getTransactionTypeCode()).isEqualTo(100);
        assertThat(firstTransaction.getStatementNumber()).isEqualTo("STMT001");
        assertThat(firstTransaction.getStatementPeriod()).isEqualTo("2024-01");
        assertThat(firstTransaction.getSpecificSymbol()).isEqualTo("123456");
        assertThat(firstTransaction.getVariableSymbol()).isEqualTo("789012");
        assertThat(firstTransaction.getCounterPartyAccount().getAccountNumber()).isEqualTo("3003333333");
        assertThat(firstTransaction.getCounterPartyAccount().getAccountName()).isEqualTo("Counter Party Account");
    }

    @Test
    @Sql(scripts = "/test-data-empty-account.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getAccountTransactions_NonExistentAccountId_ReturnsNotFound() throws Exception {
        // Given - account ID that doesn't exist in test data
        String accountId = "9999999999";

        // When & Then - should return 404 for non-existent account
        mockMvc.perform(get("/accounts/{accountId}/transactions", accountId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @Sql(scripts = "/test-data-empty-account.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void getAccountTransactions_InvalidAccountId_ReturnsBadRequest() throws Exception {
        // Given - account ID too long (exceeds @Size(max = 20) constraint)
        String accountId = "123456789012345678901"; // 21 characters

        // When & Then
        mockMvc.perform(get("/accounts/{accountId}/transactions", accountId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}