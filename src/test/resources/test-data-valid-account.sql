-- Test data for valid account test
-- This script is loaded using @Sql annotation

-- Insert test accounts
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

-- Insert test transactions using the actual generated IDs
INSERT INTO [transactions] (
    [amount], [currency], [id], [bankref], [transactionId], 
    [bookingDate], [postingDate], [creditDebitIndicator], 
    [ownAccountNumber], [counterPartyAccount], 
    [detail1], [detail2], [detail3], [detail4], 
    [productBankRef], [transactionType], [statement], 
    [constantSymbol], [specificSymbol], [variableSymbol]
) VALUES 
-- Transaction 1 - Credit to test account
(1000.00, 'CZK', 'TXN001', 'BR001', 'TRX001', 
 '2024-01-15', '2024-01-15', 'CRDT', '2002222222', 1001, 
 'Payment received', 'From customer', 'Invoice #12345', 'Reference: REF001', 
 'PBR001', 1000, 1000, '0008', '123456', '789012'),

-- Transaction 2 - Debit from test account  
(250.00, 'CZK', 'TXN002', 'BR002', 'TRX002', 
 '2024-01-16', '2024-01-16', 'DBIT', '2002222222', 1001, 
 'Payment sent', 'To supplier', 'Invoice #67890', 'Reference: REF002', 
 'PBR002', 1000, 1000, '0008', '654321', '210987'),

-- Transaction 3 - Another credit to test account
(500.00, 'CZK', 'TXN003', 'BR003', 'TRX003', 
 '2024-01-17', '2024-01-17', 'CRDT', '2002222222', 1002, 
 'Salary payment', 'From employer', 'Salary Jan 2024', 'Reference: SAL001', 
 'PBR003', 1001, 1000, '0008', '111111', '333333');
