@echo off

@REM docker run --name my-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres

psql -h localhost -U postgres -d postgres -f create_tables.sql
psql -h localhost -U postgres -d postgres -f insert_data.sql

echo Database setup complete