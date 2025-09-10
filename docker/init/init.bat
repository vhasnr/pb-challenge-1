echo "Initializing database for Challenge 1"
sqlcmd.exe -S localhost:1433 -U sa -P 83edb36d-f757-4f0d-9ed3-d31299b993dc -d master -i ./init.sql
echo "All done!"