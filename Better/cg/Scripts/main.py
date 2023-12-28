import pandas as pd
import sqlite3

# Load data from the CSV file
csv_file = 'C:/Users/medam/Desktop/cg/Scripts/daily_sales_data_0.csv'
df = pd.read_csv(csv_file)

# Connect to an SQLite database (create one if it doesn't exist)
db_file = 'data.db'
conn = sqlite3.connect(db_file)

# Write the data to an SQLite table
table_name = 'my_table'
df.to_sql(table_name, conn, if_exists='replace', index=False)

# Close the database connection
conn.close()

print(f'Data from {csv_file} has been imported into {db_file} as {table_name}')
