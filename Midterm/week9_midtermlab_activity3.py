def get_input(prompt):
    # Keep asking until the user types something (empty input is not accepted)
    while True:
        text = input(prompt + ": ").strip()
        if text != "":
            return text
        print("Input cannot be empty. Please try again.")


def program_1():
    # ---------- PROGRAM #1: Encode and Edit a Secret Message ----------
    # The user types the message
    message = get_input("Enter your message")
    print()

    # Task 1: encode the string into a bytes object using UTF-8
    message_bytes = message.encode("utf-8")
    print("1. Bytes object:", message_bytes)

    # Task 2: decode the bytes object back into a normal string
    decoded = message_bytes.decode("utf-8")
    print("2. Bytes to string:", decoded)

    # Task 3: convert the bytes object into a hexadecimal string
    hex_string = message_bytes.hex()
    print("3. Bytes to hex:", hex_string)

    # Task 4: convert the hexadecimal string back into bytes
    from_hex = bytes.fromhex(hex_string)
    print("4. Hex to bytes:", from_hex)

    # Task 5: create a bytearray directly from the string (encoding is required)
    new_bytearray = bytearray(message, "utf-8")
    print("5. New bytearray:", new_bytearray)

    # Task 6: convert the bytes object from Task 1 into a separate bytearray
    converted = bytearray(message_bytes)
    print("6. Bytes to bytearray:", converted)

    # Task 7: slice the original bytes object to get the word after the first space
    # find(" ") gives the space position, +1 moves to the start of the next word
    start = message.find(" ") + 1  # if there is no space, this becomes 0 (whole message)
    sliced = message_bytes[start:]
    print("7. Sliced bytes:", sliced)

    # Task 8: change the first byte to lowercase, then decode it
    # converted[0] is a number; chr() turns it into a letter, .lower() makes it
    # lowercase, and ord() turns it back into a number
    converted[0] = ord(chr(converted[0]).lower())
    print("8. Modified message:", converted.decode("utf-8"))

    # Reflection answer
    print("\nReflection: A bytearray is mutable, so its bytes can be changed in")
    print("place (converted[0] = ...). A bytes object is immutable, so its")
    print("contents cannot be changed after it is created.")


def program_2():
    # ---------- PROGRAM #2: Strings ----------
    # Task 1: the user types the names, then we print them
    first_name = get_input("Enter first name")
    last_name = get_input("Enter last name")
    print()
    print("First name:", first_name)
    print("Last name:", last_name)

    # Task 2: concatenate (join) the names with a space in between
    full_name = first_name + " " + last_name
    print("Full name:", full_name)

    # Task 3: access characters using indexing (0 = first, -1 = last)
    print("First character:", first_name[0])
    print("Last character:", full_name[-1])

    # Task 4: show immutability - assigning to an index raises TypeError
    try:
        first_name[0] = "D"  # this line causes the error
    except TypeError:
        print("Strings are immutable; individual characters")
        print("cannot be changed directly.")

    # Task 5: build a NEW string; the original stays unchanged
    new_name = "D" + first_name[1:]  # "D" + everything after the first character
    print("New name:", new_name)
    print("Original name:", first_name)

    # Task 6: traverse the string with a for loop (the space prints as a blank line)
    print("Characters in the full name:")
    for char in full_name:
        print(char)

    # Task 7: slice the full name to get each part
    end_first = len(first_name)  # where the first name ends
    print("Sliced first name:", full_name[0:end_first])
    print("Sliced last name:", full_name[end_first + 1:])  # +1 skips the space

    # Task 8: search for a character entered by the user
    while True:
        search = input("Enter one character to search: ")
        if len(search) == 1:  # validate: exactly one character
            break
        print("Invalid input. Please enter only ONE character.")

    if search in full_name:  # 'in' checks if the character exists (case-sensitive)
        # find() returns the index of the first match
        print("Character found at index:", full_name.find(search))
    else:
        print("Character not found.")

    # Reflection answer
    print("\nReflection: first_name[0] = 'D' fails because strings are immutable,")
    print("so a character cannot be changed in place. 'D' + first_name[1:]")
    print("succeeds because it does not change the original; it creates a")
    print("brand-new string.")


def main():
    # Main loop: keeps running until the user answers N
    while True:
        print("\n===== MIDTERM LAB ACTIVITY #3 =====")
        print("1. Program #1 - Encode and Edit a Secret Message")
        print("2. Program #2 - Strings")
        choice = input("Choose a program (1 or 2): ").strip()

        print()  # blank line for spacing
        if choice == "1":
            program_1()
        elif choice == "2":
            program_2()
        else:
            print("Invalid choice. Please enter 1 or 2.")
            continue  # go back to the menu

        # Ask the user whether to continue; repeat until a valid Y or N is typed
        while True:
            again = input("\nDo you want to continue? Y/N: ").strip().upper()
            if again in ("Y", "N"):
                break
            print("Please enter Y or N only.")

        if again == "N":
            print("Program ended. Goodbye!")
            break  # exit the main loop


# Run main() only when this file is executed directly
if __name__ == "__main__":
    main()