while True:
    java_score = float(input("Java Programming Score: "))
    c_score = float(input("C Programming Score: "))
    db_score = float(input("Database Handling Score: "))
    
    average = (java_score + c_score + db_score) / 3
    
    if average >= 90:
        grade = "A"
        reason = "between 90 and 100"
    elif average >= 80:
        grade = "B"
        reason = "between 80 and 89"
    elif average >= 75:
        grade = "C"
        reason = "between 75 and 79"
    else:
        grade = "F"
        reason = "below 75"
        
    print(f"Average: {round(average, 2)}   |   Grade: {grade} because the average is {reason}")
    
    user_response = input("Do you want to continue? (YES/NO): ").upper()
    if user_response == "NO":
        print("Program terminated. Thank you!")
        break
