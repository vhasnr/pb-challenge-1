USE challenge1;

-- Clear all data from tables in reverse dependency order
-- (child tables first, then parent tables)

-- Clear transactions table (has foreign keys to other tables)
DELETE FROM [transactions];
DBCC CHECKIDENT ('[transactions]', RESEED, 999);

-- Clear transactionType table
DELETE FROM [transactionType];
DBCC CHECKIDENT ('[transactionType]', RESEED, 999);

-- Clear statement table
DELETE FROM [statement];
DBCC CHECKIDENT ('[statement]', RESEED, 999);

-- Clear account table
DELETE FROM [account];
DBCC CHECKIDENT ('[account]', RESEED, 999);