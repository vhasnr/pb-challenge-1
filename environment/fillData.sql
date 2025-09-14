USE challenge1;

IF NOT EXISTS (SELECT 1 FROM [account])
BEGIN

-- Insert test data for account table
INSERT INTO [account] ([name], [number], [code]) VALUES
('John Doe Personal Account', '1234567890123456', 'CZK'),
('Jane Smith Business Account', '9876543210987654', 'EUR'),
('Bob Johnson Savings Account', '5555444433332222', 'USD'),
('Alice Brown Checking Account', '1111222233334444', 'CZK'),
('Charlie Wilson Investment Account', '7777888899990000', 'EUR'),
('PPF BANKA A.S.', '0000009504010019', '6000'),
('PPF BANKA A.S.', '0000009505020008', '6000'),
('PPF BANKA A.S.', '0000009503010009', '6000'),
('Test Account 2002222222', '2002222222', 'CZK');

-- Insert test data for transactionType table
INSERT INTO [transactionType] ([type], [code]) VALUES
('Transfer', 1001),
('Payment', 1002),
('Deposit', 1003),
('Withdrawal', 1004),
('Fee', 1005),
('Interest', 1006),
('Refund', 1007),
('DPO', 1012209),
('DPO', 0);

-- Insert test data for statement table
INSERT INTO [statement] ([number], [period], [description]) VALUES
('STMT-2024-001', '2024-01', 'January 2024 Statement'),
('STMT-2024-002', '2024-02', 'February 2024 Statement'),
('STMT-2024-003', '2024-03', 'March 2024 Statement'),
('STMT-2024-004', '2024-04', 'April 2024 Statement'),
('STMT-2024-005', '2024-05', 'May 2024 Statement'),
('196', '2022', 'Statement 196 for 2022'),
('195', '2022', 'Statement 195 for 2022');

-- Insert test data for transactions table
INSERT INTO [transactions] (
    [amount], [currency], [id], [bankref], [transactionId], 
    [bookingDate], [postingDate], [creditDebitIndicator], 
    [ownAccountNumber], [counterPartyAccount], 
    [detail1], [detail2], [detail3], [detail4], 
    [productBankRef], [transactionType], [statement], 
    [constantSymbol], [specificSymbol], [variableSymbol]
) VALUES
-- Transactions for account 1000 (John Doe)
(1500.00, 'CZK', 'TXN001', 'BR001', 'TXN-2024-001', 
 '2024-01-15', '2024-01-15', 'CRDT', '1234567890123456', 1001, 
 'Salary payment', 'Monthly salary', 'Employer Corp', 'HR Department', 
 'PROD-001', 1000, 1000, '0308', '123456', '2024001'),

(250.50, 'CZK', 'TXN002', 'BR002', 'TXN-2024-002', 
 '2024-01-16', '2024-01-16', 'DBIT', '1234567890123456', 1002, 
 'Grocery store payment', 'Supermarket ABC', 'Card payment', 'POS terminal', 
 'PROD-002', 1001, 1000, '0308', '123457', '2024002'),

(1200.00, 'CZK', 'TXN003', 'BR003', 'TXN-2024-003', 
 '2024-01-20', '2024-01-20', 'DBIT', '1234567890123456', 1003, 
 'Rent payment', 'Monthly rent', 'Landlord', 'Property management', 
 'PROD-003', 1001, 1000, '0308', '123458', '2024003'),

-- Transactions for account 1001 (Jane Smith)
(5000.00, 'EUR', 'TXN004', 'BR004', 'TXN-2024-004', 
 '2024-01-10', '2024-01-10', 'CRDT', '9876543210987654', 1000, 
 'Client payment', 'Invoice #INV-001', 'Client ABC Ltd', 'Business payment', 
 'PROD-004', 1000, 1001, '0308', '123459', '2024004'),

(150.75, 'EUR', 'TXN005', 'BR005', 'TXN-2024-005', 
 '2024-01-12', '2024-01-12', 'DBIT', '9876543210987654', 1004, 
 'Office supplies', 'Stationery purchase', 'Office Depot', 'Business expense', 
 'PROD-005', 1001, 1001, '0308', '123460', '2024005'),

(25.00, 'EUR', 'TXN006', 'BR006', 'TXN-2024-006', 
 '2024-01-15', '2024-01-15', 'DBIT', '9876543210987654', 1000, 
 'Bank fee', 'Monthly account fee', 'Bank charges', 'Service fee', 
 'PROD-006', 1004, 1001, '0308', '123461', '2024006'),

-- Transactions for account 1002 (Bob Johnson)
(2000.00, 'USD', 'TXN007', 'BR007', 'TXN-2024-007', 
 '2024-01-05', '2024-01-05', 'CRDT', '5555444433332222', 1000, 
 'Initial deposit', 'Account opening', 'Bank transfer', 'New account', 
 'PROD-007', 1002, 1002, '0308', '123462', '2024007'),

(500.00, 'USD', 'TXN008', 'BR008', 'TXN-2024-008', 
 '2024-01-18', '2024-01-18', 'CRDT', '5555444433332222', 1000, 
 'Interest payment', 'Monthly interest', 'Savings interest', 'Interest earned', 
 'PROD-008', 1005, 1002, '0308', '123463', '2024008'),

(100.00, 'USD', 'TXN009', 'BR009', 'TXN-2024-009', 
 '2024-01-25', '2024-01-25', 'DBIT', '5555444433332222', 1003, 
 'ATM withdrawal', 'Cash withdrawal', 'ATM transaction', 'Branch ATM', 
 'PROD-009', 1003, 1002, '0308', '123464', '2024009'),

-- Transactions for account 1003 (Alice Brown)
(3000.00, 'CZK', 'TXN010', 'BR010', 'TXN-2024-010', 
 '2024-01-08', '2024-01-08', 'CRDT', '1111222233334444', 1000, 
 'Freelance payment', 'Project completion', 'Client XYZ', 'Web development', 
 'PROD-010', 1000, 1003, '0308', '123465', '2024010'),

(75.30, 'CZK', 'TXN011', 'BR011', 'TXN-2024-011', 
 '2024-01-14', '2024-01-14', 'DBIT', '1111222233334444', 1002, 
 'Online purchase', 'Amazon order', 'Electronics', 'Online shopping', 
 'PROD-011', 1001, 1003, '0308', '123466', '2024011'),

(200.00, 'CZK', 'TXN012', 'BR012', 'TXN-2024-012', 
 '2024-01-22', '2024-01-22', 'CRDT', '1111222233334444', 1000, 
 'Refund', 'Product return', 'Store refund', 'Customer service', 
 'PROD-012', 1006, 1003, '0308', '123467', '2024012'),

-- Transactions for account 1004 (Charlie Wilson)
(10000.00, 'EUR', 'TXN013', 'BR013', 'TXN-2024-013', 
 '2024-01-03', '2024-01-03', 'CRDT', '7777888899990000', 1000, 
 'Investment deposit', 'Portfolio funding', 'Investment account', 'Capital injection', 
 'PROD-013', 1002, 1004, '0308', '123468', '2024013'),

(150.00, 'EUR', 'TXN014', 'BR014', 'TXN-2024-014', 
 '2024-01-28', '2024-01-28', 'CRDT', '7777888899990000', 1000, 
 'Dividend payment', 'Stock dividend', 'Investment income', 'Portfolio dividend', 
 'PROD-014', 1005, 1004, '0308', '123469', '2024014'),

(50.00, 'EUR', 'TXN015', 'BR015', 'TXN-2024-015', 
 '2024-01-30', '2024-01-30', 'DBIT', '7777888899990000', 1000, 
 'Management fee', 'Portfolio management', 'Investment fees', 'Advisory fee', 
 'PROD-015', 1004, 1004, '0308', '123470', '2024015'),

-- Transactions for account 2002222222 (from example response)
(1500.00, 'CZK', '20221019:0000000219', 'PS221019SO314822', '4831716', 
 '2022-10-19', '2022-10-19', 'CRDT', '2002222222', 1005, 
 'Posílám peníze', null, null, null, 
 'PS221019SO314822', 1007, 1005, '', '12', '12'),

(1999.00, 'CZK', '20221019:0000000220', 'PS221019SO314822', '4831701', 
 '2022-10-19', '2022-10-19', 'CRDT', '2002222222', 1006, 
 'Trvalý příkaz 8', null, null, null, 
 'PS221019SO314822', 1008, 1005, '', '12', '12'),

(2000.00, 'CZK', '20221019:0000000221', 'PS221019SO314823', '4831700', 
 '2022-10-19', '2022-10-19', 'CRDT', '2002222222', 1007, 
 'Na dárky', null, null, null, 
 'PS221019SO314823', 1007, 1005, '', '61', '61'),

(100.00, 'CZK', '20221018:0000003607', 'PS221018SO314645', '4831425', 
 '2022-10-18', '2022-10-18', 'CRDT', '2002222222', 1005, 
 'Příspěvek', null, null, null, 
 'PS221018SO314645', 1007, 1006, '', '12', '12'),

(1594.00, 'CZK', '20221018:0000003608', 'PS221018SO314645', '4831381', 
 '2022-10-18', '2022-10-18', 'DBIT', '2002222222', 1006, 
 'Platba elektřiny', null, null, null, 
 'PS221018SO314645', 1008, 1006, '', '12', '12');
END