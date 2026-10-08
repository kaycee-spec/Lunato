print("PROGRAM 1")
print("Hello World")
print(" ")

print("PROGRAM 2")
usertext = input("What is your name? ")
print("Hello"), usertext 
print(" ")

print("PROGRAM 3")
num1 = input('Enter first number: ')
num2 = input('Enter second number: ')
sum = float(num1) + float(num2)
print('The sum of {0} and {1} is {2}'.format(num1, num2, sum))
print(" ")

print("PROGRAM 4")
num1 = input('Enter first number: ')
num2 = input('Enter second number: ')
average =(int(num1) + int(num2))
print('average:{0} '.format(average))
print(" ")

print("PROGRAM 5")
visagrade = input('enter your visa grade : ')
finalgrade = input('enter your final grade : ')
average =(float(visagrade)*0.3)+(float(finalgrade)*0.7)
print("average :{0} ".format(average))
print(" ")

print("PROGRAM 6")
firstexam = input('your first exam : ')
secondexam = input('your second exam : ')
thirdexam = input('your third exam : ')
average =(float(firstexam)+float(secondexam)+float(thirdexam))/3
print("average :{0} ".format(average))
print(" ")

print("PROGRAM 7")
average = input('enter average : ')
if(int(average)>=50):
    print("Passed")
else:
    print("Failed")
print(" ")

print("PROGRAM 8")
num = int(input("Enter a number: "))
if (num % 2) == 0:
    print("{0} is Even".format(num))
else:
    print("{0} is Odd".format(num))
print(" ")

print("PROGRAM 9")
num = float(input("Enter a number: "))
if num > 0:
    print("Positive number")
elif num == 0:
    print("Zero")
else:
    print("Negative number")
print(" ")

print("PROGRAM 10")
print("body mass index calculation program")
height = float(input("enter height (m):"))
weight = int(input("enter weight (kg):"))
index = weight/(height*height)
if index <=18:
    print("\n underweight BMİ:{}".format(index))
elif index > 18 and index <=25 :
    print("\n overweight BMİ:{}".format(index))
elif index > 25 and index <=30:
    print("\n obese BMİ:{}".format(index))
elif index > 30:
        print("\n severely obese BMİ:{}".format(index))
print(" ")

print("PROGRAM 11")
age = input('enter age : ')
if(int(age)<18):
    print("Your Age Is Not Eligible To Get A Driver's License")
else:
    print("Your Age Is Eligible To Get Your License")
print(" ")

print("PROGRAM 12")
for i in range(1,101):
    print(i)
print(" ")

print("PROGRAM 13")
for i in range(1, 101):
    if i % 2 == 0:
        print(i)
print(" ")

print("PROGRAM 14")
for i in range(1, 101):
    if i % 2 != 0:
        print(i)
print(" ")

print("PROGRAM 15")
for i in range(1, 101):
    if i % 3 == 0 or i % 5 == 0:
        print(i)
print(" ")

print("PROGRAM 16")
num = input('enter number : ')
for i in range(1,int(num)+1):
    print(i)
print(" ")

print("PROGRAM 17")
short = input('Enter short side : ')
tall = input('Enter tall side : ')
area = int(short)*int(tall)
perimeter =2*(int(short)+int(tall))
print("area: {0}".format(alan))
print("perimeter: {0}".format(cevre))
print(" ")

print("PROGRAM 18")
word = 'mrhuseyin'
for char in word:
    print(char)
print(" ")

print("PROGRAM 19")
sumofnumbers = 0
num1 = input("first number: ")
num2 = input("second number: ")
# FIX: Replaced non-existent variables 'sayi1' and 'sayi2' with 'num1' and 'num2', and corrected indentation
for i in range(int(num1) + 1, int(num2)):
    sumofnumbers += i
print("Sum of numbers between {0} and {1} : {2}".format(num1, num2, sumofnumbers))
print(" ")

print("PROGRAM 20")
selection = input("Press (1) for Cinema, (2) for Theater : ")
student = input("Are you student(Y/N) : ")
price = 0
# FIX: Fixed indentation across the entire logic tree
if selection == "1":
    price = 10
elif selection == "2":
    price = 5

if student == "Y" or student == "y":
    price = price / 2
print(" The fee you have to pay :{}".format(price))
print(" ")

print("PROGRAM 21")
num = int(input("Enter a number: "))
if num > 1:
    # FIX: Fixed indentation for prime calculation loops
    for i in range(2, num):
        if (num % i) == 0:
            print(num, "is not a prime number")
            print(i, "times", num // i, "is", num)
            break
    else:
        print(num, "is a prime number")
else:
    print(num, "is not a prime number")
print(" ")

print("PROGRAM 22")
NumList = []
Even_Sum = 0
Odd_Sum = 0
Number = int(input("Please enter the Total Number of List Elements: "))
for i in range(1, Number + 1):
    # FIX: Corrected indentation inside list insertion
    value = int(input("Please enter the Value of %d Element : " % i))
    NumList.append(value)
for j in range(Number):
    if NumList[j] % 2 == 0:
        Even_Sum = Even_Sum + NumList[j]
    else:
        Odd_Sum = Odd_Sum + NumList[j]
print("\nThe Sum of Even Numbers in this List = ", Even_Sum)
print("The Sum of Odd Numbers in this List = ", Odd_Sum)
print(" ")

print("PROGRAM 23")
newsalary = 0
salary = input("enter new salary : ")
# FIX: Avoided SyntaxError by changing the restricted keyword variable 'raise' to 'raise_rate'
raise_rate = input("salary raise rate(%) : ")
newsalary = int(salary) + (int(salary) * int(raise_rate) / 100)
print("increased salary :", newsalary)
print(" ")

# ==========================================
print("PROGRAM 24")


# FIX: Corrected function scopes with proper indentation block sizes
def find_Diameter(radius):
    return 2 * radius


def find_Circumference(radius):
    return 2 * math.pi * radius


def find_Area(radius):
    return math.pi * radius * radius


r = float(input(" Please Enter the radius of a circle: "))
diameter = find_Diameter(r)
circumference = find_Circumference(r)
area = find_Area(r)
print("\n Diameter Of a Circle = %.2f" % diameter)
print(" Circumference Of a Circle = %.2f" % circumference)
print(" Area Of a Circle = %.2f" % area)
print(" ")

# ==========================================
print("PROGRAM 25")


def areaRectangle(a, b):
    return a * b


def perimeterRectangle(a, b):
    return 2 * (a + b)


a = 5
b = 6
print("Area = ", areaRectangle(a, b))
print("Perimeter = ", perimeterRectangle(a, b))
print(" ")

# ==========================================
print("PROGRAM 26")
lower = int(input("Enter Lower bound:- "))
upper = int(input("Enter Upper bound:- "))
x = random.randint(lower, upper)
print(
    "\n\tYou've only ",
    round(math.log(upper - lower + 1, 2)),
    " chances to guess the integer!\n",
)
count = 0
# FIX: Re-indented inner control flow statements safely inside while statement
while count < math.log(upper - lower + 1, 2):
    count += 1
    guess = int(input("Guess a number:- "))
    if x == guess:
        print("Congratulations you did it in ", count, " try")
        break
    elif x > guess:
        print("You guessed too small!")
    elif x < guess:
        print("You Guessed too high!")

if count >= math.log(upper - lower + 1, 2) and x != guess:
    print("\nThe number is %d" % x)
    print("\tBetter Luck Next time!")
print(" ")

# ==========================================
print("PROGRAM 27")
date = str(input("Enter the date(for example:09 02 2019):"))
day_name = [
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday",
]
day = datetime.datetime.strptime(date, "%d %m %Y").weekday()
print(day_name[day])
print(" ")

# ==========================================
print("PROGRAM 28")


def find_missing(lst):
    return [x for x in range(lst[0], lst[-1] + 1) if x not in lst]


lst = [1, 2, 4, 6, 7, 9, 10]
print(find_missing(lst))
print(" ")

# ==========================================
print("PROGRAM 29")
char_list = ["a", "b", "c"]
string = "abcd"
matched_list = [characters in char_list for characters in string]
print(matched_list)
string_contains_chars = all(matched_list)
print(string_contains_chars)
print(" ")

print("PROGRAM 30")
total = 0
evenSums = 0
oddSums = 0
evenCount = 0
oddCount = 0
done = False

while not done:
    user_in = input("Give me an integer or type 'done' to be done: ")
    if user_in.lower() == "done":
        done = True
    else:
        val = int(user_in)
        total += val
        if val % 2 == 0:
            evenSums += val
            evenCount += 1
        else:
            oddSums += val
            oddCount += 1

evenAverage = evenSums / evenCount if evenCount > 0 else 0
oddAverage = oddSums / oddCount if oddCount > 0 else 0

print(f"Total: {total}")
print(f"Even Average: {evenAverage}")