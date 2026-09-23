while True:
    
    print("\nARITHMETIC CALCULATOR")
    print("1. Addition          2. Subtraction       3. Multiplication")
    print("4. Division          5. Modulus           6. Increment")
    print("7. Decrement\n")
    
    choice = input("Select an arithmetic operation: ")
    
    if choice in ["1", "2", "3", "4", "5", "6", "7"]:
        
        if choice in ["1", "2", "3", "4", "5"]:
            x = float(input("Enter the value of x: "))
            y = float(input("Enter the value of y: "))
            print(f"\nVariable Values: x = {x}, y = {y}")
            
            if choice == "1":
                result = x + y
                print(f"Addition: x + y = {result}")
                
            elif choice == "2":
                result = x - y
                print(f"Subtraction: x - y = {result}")
                
            elif choice == "3":
                result = x * y
                print(f"Multiplication: x * y = {result}")
                
            elif choice == "4":
               
                if y == 0:
                    print("Error: Division by zero is not allowed.")
                else:
                    result = x / y
                    print(f"Division: x ÷ y = {result}")
                    
            elif choice == "5":
                if y == 0:
                    print("Error: Modulus by zero is not allowed.")
                else:
                    result = x % y
                    print(f"Modulus: x % y = {result}")
        
        elif choice in ["6", "7"]:
            x = float(input("Enter the value of x: "))
            print(f"\nVariable Values: x = {x}")
            
            if choice == "6":
                result = x + 1
                print(f"Increment: x + 1 = {result}")
                
            elif choice == "7":
                result = x - 1
                print(f"Decrement: x - 1 = {result}")
                
    else:
        print("Error: Invalid menu option selected.")

    user_response = input("\nDo you want to continue? (YES/NO): ").strip().upper()
    
    if user_response == "NO":
        print("Program terminated. Thank you!")
        break