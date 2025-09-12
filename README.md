# Challenge 1
## Assumtpions 
1. TODO UPDATE: ta_database.sql - 'GO' statements are batch separators used by client - probalby MS SQL Server client, ignoring this part of definition for the task. 
2. Financial transaction processing application is likely security sensitive - therefore I'm not adding more functionality than requested.
3. 'transaction' table name was updated to 'transactions' due to 'transaction' being reserved word of MS SQL. Theoretically [] can be used to avoid conflict, but changing the name will avoid issues. Transaction name in general should be changed - to something like FinancialTransaction (or similar) - the name can cause confusion on many places - java code, logs, other systems.
## Proposals
1. If possible, change db tables/columns naming to snake_case - then default naming strategy of Spring/Jakarta can be used 
## Setup
### Local Dev Run
### Local Integration Run
## Run
### Local Dev Run
### Local Integration Run
## Technology
- Spring boot
- Flyway Migration
- - automatically applies .sql scripts and checks if particular script is already applied or not (thru migration metadata table)
Spring boot project
## Testing
TODO unit tests using Testcointainers