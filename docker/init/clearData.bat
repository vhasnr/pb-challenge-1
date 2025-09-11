echo "Clearing all data from challenge1 database..."
sqlcmd.exe -S localhost:1433 -U chal1 -P 0e0e6bcb-db71-4256-b2a4-a7719f52e263 -d challenge1 -i ./clearData.sql
echo "Data cleared successfully!"
