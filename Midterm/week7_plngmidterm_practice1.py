# 'def' creates a custom reusable block of code called a function
def program1():
    # [] creates an empty list to store multiple items
    nums = []
    
    # 'for i in range(10)' repeats the code inside exactly 10 times (from 0 to 9)
    for i in range(10):
        # 'input()' reads user text, 'float()' converts it into a decimal number, and '.append()' adds it to our list
        nums.append(float(input(f"Enter real number {i + 1}: ")))

    # Loop 1: sum and average of positive numbers
    total = 0
    pos_count = 0
    
    # This loop goes through every single number ('n') stored inside the 'nums' list
    for n in nums:
        # 'if' checks a condition; here it checks if the number is greater than 0
        if n > 0:
            total += n         # Adds the number to our running total
            pos_count += 1     # Increases our count of positive numbers by 1

    # Checks if we found at least one positive number to avoid dividing by zero
    if pos_count > 0:
        # 'print()' displays text and variables on the screen
        print("Sum of positive numbers: ", total)
        print("Average of positive numbers: ", total / pos_count) # '/' performs standard division
    else:
        # 'else' runs only if the 'if' condition above was false
        print("There are no positive numbers.")

    # Loop 2: count negative numbers
    neg_count = 0
    for n in nums:
        if n < 0:
            neg_count += 1     # Adds 1 to our count if the number is less than 0
    print("Count of negative numbers: ", neg_count)

    # Loop 3: minimum value
    # 'nums[0]' grabs the very first item in the list to use as a starting guess
    minimum = nums[0]
    for n in nums:
        # If the current number is smaller than our lowest guess, update our lowest guess
        if n < minimum:
            minimum = n
    print("Minimum value: ", minimum)


def program2():
    arr = []
    for i in range(8):
        # 'int()' converts the user's text input into a whole number (integer)
        arr.append(int(input(f"Enter integer {i + 1}: ")))

    # Remove duplicates (keeps original order)
    unique = []
    for n in arr:
        # 'not in' checks if the number is missing from our 'unique' list
        if n not in unique:
            unique.append(n)
    print("Array without duplicates: ", unique)

    # 'len()' counts how many items are currently inside the list
    if len(unique) < 2:
        print("Not enough distinct elements for second largest/smallest.")
        # 'return' immediately exits the current function early
        return

    # 'sorted()' rearranges the numbers in order from smallest to largest
    ordered = sorted(unique)
    
    # '[-2]' reads the list backward to get the 2nd item from the end (second largest)
    print("Second largest element: ", ordered[-2])
    # '[1]' grabs the item at index 1, which is the 2nd item from the start (second smallest)
    print("Second smallest element: ", ordered[1])


def program3():
    # '.split()' cuts a single line of text into a list of separate words/items using spaces
    arr = input("Enter Data in Array: ").split()
    
    # '" ".join()' glues a list of text strings back together into one line, separated by spaces
    print("Stored Data in Array: ", " ".join(arr))
    
    pos = int(input("Enter poss. of Element to Delete: "))
    
    # Checks if the user's choice falls safely within the boundaries of the list length
    if 1 <= pos <= len(arr):
        # '.pop()' removes an item from the list at a specific index position
        arr.pop(pos - 1) # Subtract 1 because Python lists start counting at 0, not 1
        print("New data in Array: ", " ".join(arr))
    else:
        print("Invalid position!")


def program4():
    size = int(input("Enter Size of Array: "))
    
    # '[:size]' is a slice that cuts off the list, keeping only up to the requested 'size' items
    arr = input(f"Enter any {size} elements in Array:\n ").split()[:size]
    
    # This is a List Comprehension: a shorthand way to convert every text item ('x') in 'arr' into an integer
    nums = [int(x) for x in arr]
    
    # '% 2 == 0' checks if a number is even (leaves a remainder of 0 when divided by 2)
    evens = [str(n) for n in nums if n % 2 == 0]
    
    # '% 2 != 0' checks if a number is odd (leaves a remainder that is not 0)
    odds = [str(n) for n in nums if n % 2 != 0]
    
    print("Even Elements: ", " ".join(evens))
    print("Odd Elements: ", " ".join(odds))


def program5():
    rows = 4
    for i in range(rows):
        # Starts with an initial '*', then repeats 'A*' exactly 'i' times
        print("*" + "A*" * i)


def program6():
    print("--- Salary Calculator ---")
    # 'float(input())' prompts the user for information and converts their text response into a decimal number
    basic = float(input("Enter Basic Salary: "))
    hra = float(input("Enter HRA Allowance: "))
    ta = float(input("Enter TA Allowance: "))
    others = float(input("Enter Other Allowances: "))
    
    # DA, PF, and IT are dynamically calculated as percentages based on the user's input Basic Salary
    da = 0.12 * basic       
    pf = 0.14 * basic
    it = 0.15 * basic
    
    # Calculates final net pay by summing basic pay/allowances and subtracting mandatory deductions
    net = basic + da + hra + ta + others - (pf + it)
    
    print("\n--- Salary Breakdown ---")
    # ':.2f' formatting dynamically manages rounding to enforce exactly two numeric decimal places
    print(f"Basic Salary: ${basic:.2f}")
    print(f"DA (12%):     ${da:.2f}")
    print(f"HRA:          ${hra:.2f}")
    print(f"TA:           ${ta:.2f}")
    print(f"Others:       ${others:.2f}")
    print(f"PF (14%):     ${pf:.2f}")
    print(f"IT (15%):     ${it:.2f}")
    print(f"Net Salary:   ${net:.2f}")


def main():
    # '{}' creates a dictionary, which pairs lookup keys (like 1) directly with actions (like program1)
    programs = {1: program1, 2: program2, 3: program3, 4: program4, 5: program5, 6: program6}
    
    # 'while True' creates an infinite loop that keeps repeating until a 'break' command is triggered
    while True:
        # '\n' prints a blank newline space before the text
        print("\nChoose the program you want to run")
        for i in range(1, 7):
            print(f"Program #{i}")
            
        # 'try/except' protects the script; if the user types letters instead of a number, it won't crash
        try:
            choice = int(input("Your choice: "))
        except ValueError:
            # If an error happens during input conversion, reset the choice to 0
            choice = 0
            
        # 'in' checks if the user's choice is a valid option key inside our dictionary
        if choice in programs:
            print()
            # Grabs the specific function from our dictionary maps and executes it using '()'
            programs[choice]()
        else:
            print("Invalid choice, please pick 1-6.")
            
        # '.strip()' clears accidental spaces; '.upper()' forces the text to capitals so 'y' or 'Y' work
        again = input("\nDo you want to continue ? Y/N: ").strip().upper()
        
        # '!= ' checks if two values are not equal to each other
        if again != 'Y':
            print("Goodbye!")
            # 'break' immediately stops and exits the 'while' loop
            break

# Calls the 'main' function to start running the entire file layout
main()