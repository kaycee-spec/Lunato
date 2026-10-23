# =====================================
# PROGRAM 1: BANK ACCOUNT
# =====================================
class BankAccount:  # "class" creates a blueprint for objects
    def __init__(self):  # __init__ is the constructor, runs when an object is created
        self.balance = 0.0  # self.balance is an attribute (variable) of the object

    def run(self):  # a method (function inside a class); self refers to this object
        print("\n===== PROGRAM 1: BANK ACCOUNT =====")  # print() shows text on screen
        self.balance = float(input("Enter your balance: "))  # input() reads text, float() converts to decimal

        choice = 0  # starting value so the loop can begin
        while choice != 3:  # loop repeats while the condition is True
            print("\nSelect an option:")
            print("1. Withdraw Amount")
            print("2. Deposit Amount")
            print("3. Exit")
            choice = int(input("Enter your choice: "))  # int() converts text to a whole number

            if choice == 1:  # "if" checks a condition
                print("How much amount you want to withdraw from your account?")
                withdraw = float(input("Amount: "))

                if withdraw > 0 and withdraw <= self.balance:  # "and" means both must be True
                    self.balance = self.balance - withdraw  # subtract the amount
                    print("Your new balance is:", self.balance)  # a comma prints values separated by a space
                else:  # runs when the "if" condition is False
                    print("Invalid amount or insufficient balance!")

            elif choice == 2:  # "elif" means "else if", another condition to check
                print("How much amount you want to deposit in your account?")
                deposit = float(input("Amount: "))

                if deposit > 0:
                    self.balance = self.balance + deposit  # add the amount
                    print("Your new balance is:", self.balance)
                else:
                    print("Invalid deposit amount!")

            elif choice == 3:
                print("Thank you for using the system!")

            else:  # runs when none of the choices above match
                print("Invalid option!")


# =====================================
# PROGRAM 2: HOSPITAL PATIENT DATABASE
# =====================================

# Class for date
class PatientDate:
    def __init__(self):
        self.year = 0  # attributes start with default values
        self.month = 0
        self.day = 0

    def input_date(self):  # named input_date because "input" is a built-in Python function
        self.year = int(input("Enter year: "))
        self.month = int(input("Enter month: "))
        self.day = int(input("Enter day: "))

    def display(self):
        # f-string: {value:02d} prints a number with at least 2 digits (adds leading zero)
        print(f"{self.day:02d}/{self.month:02d}/{self.year:04d}", end="")  # end="" stops the new line


# Base class
class Patient:
    def __init__(self):
        self.name = ""
        self.admission_date = PatientDate()  # an object inside another object (composition)
        self.disease = ""
        self.discharge_date = PatientDate()

    def input_data(self):
        self.name = input("Enter patient's name: ")  # input() already returns text, no conversion needed

        print("Enter date of admission:")
        self.admission_date.input_date()  # call the method of the date object

        self.disease = input("Enter disease: ")

        print("Enter date of discharge:")
        self.discharge_date.input_date()

    def display(self):
        print("Name:", self.name)

        print("Date of admission: ", end="")
        self.admission_date.display()
        print()  # empty print() just moves to a new line

        print("Disease:", self.disease)

        print("Date of discharge: ", end="")
        self.discharge_date.display()
        print()


# Derived class
class HospitalPatient(Patient):  # (Patient) means this class inherits from Patient
    def __init__(self):
        super().__init__()  # super() calls the parent class, here its constructor
        self.age = 0

    def input_data(self):
        super().input_data()  # run the parent's version first
        self.age = int(input("Enter age: "))  # then add the extra input for age

    def display(self):
        super().display()  # run the parent's display first
        print("Age:", self.age)
        print("-------------------------")


# Hospital menu
class HospitalDatabase:
    def __init__(self):
        self.patients = []  # an empty list; it grows automatically (no fixed size needed)
        self.max_patients = 100  # keeps the same limit of 100 as the Java version

    def run(self):
        choice = 0
        while choice != 4:
            print("\n===== PROGRAM 2: HOSPITAL DATABASE =====")
            print("1. Insert New Patient")
            print("2. Display All Patients")
            print("3. Display Pediatric Patients")
            print("4. Exit")
            choice = int(input("Enter your choice: "))

            if choice == 1:
                if len(self.patients) < self.max_patients:  # len() gives the number of items in the list
                    patient = HospitalPatient()  # create a new patient object
                    patient.input_data()
                    self.patients.append(patient)  # append() adds the item to the end of the list
                    print("Patient added successfully!")
                else:
                    print("Patient database is full.")

            elif choice == 2:
                if len(self.patients) == 0:
                    print("No patient records found.")
                else:
                    print("\n===== ALL PATIENTS =====")
                    for patient in self.patients:  # "for" goes through each item in the list
                        patient.display()

            elif choice == 3:
                found = False  # a flag to remember if we found any pediatric patient

                print("\n===== PEDIATRIC PATIENTS (UNDER 12) =====")

                for patient in self.patients:
                    if patient.age < 12:  # pediatric means younger than 12
                        patient.display()
                        found = True

                if not found:  # "not" reverses True/False
                    print("No pediatric patients found.")

            elif choice == 4:
                print("Returning to main menu...")

            else:
                print("Invalid choice!")


# =====================================
# PROGRAM 3: PROFESSOR, DEAN, EXECUTIVE
# =====================================

# Base class
class Professor:
    def __init__(self, name, salary):  # the constructor receives values as parameters
        self.name = name  # store the parameter in the object
        self.salary = salary


# Dean class
class Deans(Professor):  # Deans inherits name and salary from Professor
    def __init__(self, name, department, salary):
        super().__init__(name, salary)  # pass name and salary to the parent constructor
        self.department = department

    def __str__(self):  # __str__ is like Java's toString(); it defines how the object prints as text
        return ("Name: " + self.name
                + "\nDepartment: " + self.department
                + "\nSalary: " + str(self.salary))  # str() converts a number to text so it can be joined


# Executive class
class Executive(Deans):  # Executive inherits from Deans (so it also gets Professor's attributes)
    def __init__(self, name, department, salary):
        super().__init__(name, department, salary)

    def __str__(self):
        return "Executive\n" + super().__str__()  # add "Executive" before the Deans text


# Program 3 input and display
class ProfessorProgram:
    def run(self):
        print("\n===== PROGRAM 3: PROFESSOR AND EXECUTIVE =====")

        print("\nEnter Dean's Information")
        dean_name = input("Name: ")
        dean_department = input("Department: ")
        dean_salary = float(input("Salary: "))

        dean = Deans(dean_name, dean_department, dean_salary)  # create a Deans object

        print("\nEnter Executive's Information")
        executive_name = input("Name: ")
        executive_department = input("Department: ")
        executive_salary = float(input("Salary: "))

        executive = Executive(executive_name, executive_department, executive_salary)

        print("\nStatus")
        print("Rank: Dean")
        print(dean)  # print() automatically uses __str__

        print("\nStatus")
        print("Rank: " + str(executive))  # str() calls __str__ to get the text


# =====================================
# MAIN PROGRAM
# =====================================
def main():  # a function that holds the main menu
    bank = BankAccount()  # create an object of each class
    hospital = HospitalDatabase()
    professor = ProfessorProgram()

    choice = 0
    while choice != 4:
        print("\n==============================")
        print("          MAIN MENU")
        print("==============================")
        print("1. Program 1 - Bank Account")
        print("2. Program 2 - Hospital Database")
        print("3. Program 3 - Professor and Executive")
        print("4. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            bank.run()  # call the run method of the object
        elif choice == 2:
            hospital.run()
        elif choice == 3:
            professor.run()
        elif choice == 4:
            print("Thank you for using the programs!")
        else:
            print("Invalid choice!")


# This makes main() run only when the file is run directly (like Java's main method)
if __name__ == "__main__":
    main()