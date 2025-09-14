# Challenge 1
## Assumtpions 
1. Given ta_database.sql expectes MS SQL Server, that is also indicated by 'GO' statements, those are batch separators used by MS SQL Server client. Keeping use of MS SQL Server as rule. Provided creation script is in _V0.1.1_createSchema.sql_ file used by Flyway.
2. Financial transaction processing application is likely security sensitive - therefore I'm not adding more functionality than requested - no APIs to create accounts/transactions etc. Local data can be inserted by .sql script.
3. 'transaction' table name was updated to 'transactions' due to 'transaction' being reserved word of MS SQL. Theoretically [] can be used to avoid conflict, but changing the name will avoid issues. Transaction name in geneal should be changed - to something like FinancialTransaction (or similar) - the name can cause confusion on many places - java code, logs, other systems.
## Local run and challange test
### Prerequisities
- Windows system, with cmd, PowerShell or other windows terminal, no WSL needed
- Docker daemon running
- MS SQL 'sqlcmd' cmdline tool installed 
### Steps to run (local-integration profile with MS SQL)
1. From _environment/_ folder, run `docker-compose.exe up -d`, this will download and start basic MS SQL Server docker in docker. 
2. Run `.\createDbAndUser.bat` script, it will create _challenge1_ db, and _chal1_ user - both used by the application.
3. Run the application for the first time - let Flyway create DB sctucture. From project root run `./gradlew bootRun` command, spring profile _local-integration_ is harcoded in _application.properties_ as it is only one currently working.
4. As DB strcuture is initiated by initial run of application, with unchanged configuration you should be able to check created tables in app's db running following command: `sqlcmd -S localhost:1433 -U SA -P 83edb36d-f757-4f0d-9ed3-d31299b993dc -Q 'use challenge1; select name from sys.tables'`, you should see result similar to following:
```
Changed database context to 'challenge1'.
name
--------------------------------------------------------------------------------------------------------------------------------
flyway_schema_history
transactions
transactionType
statement
account

(5 rows affected)
```
5. Now lets insert test data into the DB. From _environment/_ folder, run following command `.\fillData.bat`. Result should contain following statements:
```
(9 rows affected)
(9 rows affected)
(7 rows affected)
(20 rows affected)
...
"Data inserted!"
```
6. Now running application should provide expected result from API. Call following API request: `curl.exe --location 'localhost:8089/accounts/2002222222/transactions'`, alternatively one of following account numbers can be used: 1234567890123456, 9876543210987654, 5555444433332222, 1111222233334444, 7777888899990000, 2002222222. Returned response for 2002222222 starts as follows:
```
[
    {
        "amount": {
            "currency": "CZK",
            "value": 1500
        },
        "bankref": "PS221019SO314822",
        "bookingDate": "2022-10-19",
        "counterPartyAccount": {
            "accountName": "PPF BANKA A.S.",
            "accountNumber": "0000009504010019",
            "bankCode": "6000"
        },
        "creditDebitIndicator": "CRDT",
        "details": {
            "detail1": "Posílám peníze"
        },
        "id": "20221019:0000000219",
        "ownAccountNumber": "2002222222",
        "postingDate": "2022-10-19",
        "productBankRef": "PS221019SO314822",
        "specificSymbol": "12",
        "statementNumber": "196",
        "statementPeriod": "2022",
        "transactionId": "4831716",
        "transactionType": "DPO",
        "transactionTypeCode": 1012209,
        "variableSymbol": "12"
    },...
```
## Proposals
1. If possible, change db tables/columns naming to snake_case - then default naming strategy of Spring/Jakarta can be used 
## Technology
- Docker - run MS SQL DB using compose script
- Spring boot
- Flyway Migration
  - automatically applies .sql scripts and checks if particular script is already applied or not (thru migration metadata table)
- Lombok - generates boilerplate java code as getters/setters, loggers etc.
## Testing
TODO unit tests using Testcointainers