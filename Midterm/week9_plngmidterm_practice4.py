from datetime import datetime  # Lets us work with dates

def read_whole_number(prompt, error_checks):
    # Keeps asking until the user enters a valid whole number
    while True:
        raw = input(prompt).strip()  # Get input and remove extra spaces
        try:
            value = int(raw)  # Try to convert the input to a whole number
        except ValueError:
            # Runs if the input is a letter or decimal
            print("[Error] Decimals and letters are not allowed. Please enter a whole number.")
            continue  # Ask again

        error = error_checks(value)  # Check for other rules (negative, zero, etc.)
        if error:
            print(error)  # Show the error message
            continue  # Ask again
        return value  # Input is valid, send it back

def parse_date(text):
    # Convert text like "08 1, 21" into a real date
    return datetime.strptime(text.strip(), "%m %d, %y").date()

def main():
    name = input("Enter your Name: ")  # Ask for the user's name
    print(f"\nWELCOME {name.upper()}")  # Show the name in capital letters

    while True:  # Main loop, repeats until the user says no
        try:
            # 1. Total pages
            def check_pages(n):
                if n < 0:
                    return "[Error] Negative numbers are not allowed."  # No negatives
                if n == 0:
                    return "[Error] A book must have at least 1 page."  # No zero
                return None  # No error

            pages = read_whole_number("\nHow many pages does the book have?\n", check_pages)

            # 2. Pages read
            def check_read(n):
                if n < 0:
                    return "[Error] Negative numbers are not allowed."  # No negatives
                if n > pages:
                    # Can't read more than the total pages
                    return f"[Error] You cannot read more pages than the book actually has ({pages})."
                return None  # No error

            read = read_whole_number("\nHow many pages have you read?\n", check_read)

            # 3. Dates
            issue_date = parse_date(
                input("\nIssue date (Format: MM DD, YY, e.g., 08 1, 21):\n")  # Ask for issue date
            )
            due_date = parse_date(
                input("\nDue Date (Format: MM DD, YY, e.g., 08 15, 21):\n")  # Ask for due date
            )

            # Percentage read
            percent = (read / pages) * 100  # Pages read divided by total pages
            print(f"\nYou have read {percent:.2f}% of the book.")  # Show with 2 decimals

            # Days remaining or overdue
            days = (due_date - issue_date).days  # Number of days between the two dates
            if days < 0:
                # Due date is before issue date, so it's overdue
                print(f"The book is overdue by {abs(days)} day(s) and you have to return the book.")
            else:
                print(f"You have {days} days remaining to return the book.")

            # Pages left and pages per day
            pages_left = pages - read  # Pages not yet read
            left_per_day = 0  # Default value
            if days > 0:
                left_per_day = -(-pages_left // days)  # Divide and round up

            print(f"You still have {pages_left} page(s) left and you should read {left_per_day} pages a day.")

        except ValueError:
            # Runs if the date format is wrong
            print("\n[Error] Invalid date format typed. Please write it exactly like: 08 1, 21")
        except Exception:
            # Runs for any other unexpected error
            print("\n[Error] An unexpected calculation or input error occurred.")

        choice = input("\nDo you want to continue? (YES/NO): ").strip().upper()  # Ask to repeat
        if choice not in ("YES", "Y"):
            break  # Stop the loop if the answer is not yes

    print("\nThank you for using the Library System! Goodbye.")  # Goodbye message

if __name__ == "__main__":
    main()  # Start the program