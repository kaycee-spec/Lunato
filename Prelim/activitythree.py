num = int(input("Enter a multiple of 5 between 1 and 100: "))

if 1 <= num <= 100 and num % 5 == 0:
    print("Valid number")
else:
    print("Invalid number")
    