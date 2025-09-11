echo "Filling transaction data for Challenge 1"
sqlcmd.exe -S localhost:1433 -U chal1 -P 0e0e6bcb-db71-4256-b2a4-a7719f52e263 -d challenge1 -i ./fillData.sql
echo "Data inserted!"