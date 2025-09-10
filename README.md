# Challenge 1
## Assumtpions 
1. ta_database.sql - 'GO' statements are batch separators used by client - probalby MS SQL Server client, ignoring this part of definition for the task. 
2. Financial transaction processing application is likely security sensitive - therefore I'm not adding more functionality than requested.
## Setup
### Local Dev Run
### Local Integration Run
## Technology
- Spring boot
- Flyway Migration
- - automatically applies .sql scripts and checks if particular script is already applied or not (thru migration metadata table)
Spring boot project
## Testing
TODO unit tests using Testcointainers