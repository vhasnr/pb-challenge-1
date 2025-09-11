# Challenge 1
## Assumtpions 
1. ta_database.sql - 'GO' statements are batch separators used by client - probalby MS SQL Server client, ignoring this part of definition for the task. 
2. Financial transaction processing application is likely security sensitive - therefore I'm not adding more functionality than requested.
3. 'transaction' table name was updated to 'transactions' due to 'transaction' being reserved word of MS SQL. Theoretically [] can be used to avoid conflict, but changing the name will avoid issues. 
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