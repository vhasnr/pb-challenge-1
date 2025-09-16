-- Test data for empty account test
-- This script is loaded using @Sql annotation

-- Insert test accounts (but no transactions for account 9999999999)
INSERT INTO [account] ([name], [number], [code]) VALUES 
('Test Account', '2002222222', 'TEST'),
('Counter Party Account', '3003333333', 'CPTY'),
('Another Test Account', '4004444444', 'ATST');

-- Insert transaction types
INSERT INTO [transactionType] ([type], [code]) VALUES 
('Transfer', 100),
('Payment', 200),
('Withdrawal', 300);

-- Insert statements
INSERT INTO [statement] ([number], [period], [description]) VALUES 
('STMT001', '2024-01', 'January 2024 Statement'),
('STMT002', '2024-02', 'February 2024 Statement');

-- Insert test transactions for other accounts (not 9999999999)
INSERT INTO [transactions] (
    [amount], [currency], [id], [bankref], [transactionId], 
    [bookingDate], [postingDate], [creditDebitIndicator], 
    [ownAccountNumber], [counterPartyAccount], 
    [detail1], [detail2], [detail3], [detail4], 
    [productBankRef], [transactionType], [statement], 
    [constantSymbol], [specificSymbol], [variableSymbol]
) VALUES 
-- Transaction for account 2002222222 (not the one we're testing)
(1000.00, 'CZK', 'TXN001', 'BR001', 'TRX001', 
 '2024-01-15', '2024-01-15', 'CRDT', '2002222222', 1001, 
 'Payment received', 'From customer', 'Invoice #12345', 'Reference: REF001', 
 'PBR001', 1000, 1000, '0008', '123456', '789012');
