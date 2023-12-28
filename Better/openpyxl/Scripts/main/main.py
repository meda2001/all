try:
    # Open the Excel file in binary mode
    with open('example.xlsx', 'rb') as file:
        # Read the binary data from the file
        data = file.read()

        # Process the binary data (this part depends on the Excel file format)
        # You would need to manually parse the Excel file format, which is quite complex
        # This approach is not recommended for practical use with real-world Excel files

        # Example: Print the first 100 bytes of the binary data
        print(data[:100])

except FileNotFoundError:
    print("File 'example.xlsx' not found.")
except Exception as e:
    print("An error occurred:", str(e))
