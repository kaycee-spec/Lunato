#PROGRAM #1
class Book:
    #constructor method to initialized the variables
    def __init__(self, title, author, price): 
        self.title = title #store the book title
        self.author = author
        self.price = float(price) 
    #method to control show the object look when printed
    def __str__(self):
        return f"Book: {self.title} | Author: {self.author}\nPrice: PHP {self.price:.2f}"
class EBook(Book): #child class that inherit from parent
    def __init__(self, title, author, price, file_size_mb):
        super().__init__(title, author, price) #super(),this one send the shared variable up to parent
        self.file_size_mb = file_size_mb #store th file
    def __str__(self):
        return (f"EBook: {self.title} | Author: {self.author}\n"
                f"Price: PHP {self.price:.2f} | File size: {self.file_size_mb} MB")
#PROGRAM #3
class Student: #parent
    def __init__(self, name, student_id, tuition_fee): #constructor method to initialized the variables
        self.name = name #store the name
        self.student_id = student_id
        self.tuition_fee = float(tuition_fee)
#method to control show the object look when printed
    def __str__(self): 
        return f"Name: {self.name} | Student ID: {self.student_id}\nTuition fee: PHP {self.tuition_fee:.2f}"
class ScholarStudent(Student): #child class
    def __init__(self, name, student_id, tuition_fee, scholarship_percentage):
        super().__init__(name, student_id, tuition_fee)
        if not (0 <= scholarship_percentage <= 100): #check if the number is valid
            #the execution will stop if bad numbers are entered
            raise ValueError("Scholarship percentage must be between 0 and 100.")
        self.scholarship_percentage = scholarship_percentage 
#formula to calculate the final price
    def calculate_payable_fee(self):
        #return thr original fee to calculate the discount 
        return self.tuition_fee - (self.tuition_fee * (self.scholarship_percentage / 100))
#method to add calculation result
    def __str__(self):
        payable = self.calculate_payable_fee()
        #return all information
        return (f"Name: {self.name} | Student ID: {self.student_id}\n"
                f"Tuition fee: PHP {self.tuition_fee:.2f}\n"
                f"Scholarship: {self.scholarship_percentage}%\n"
                f"Payable fee: PHP {payable:.2f}")
def main():
    # Program 1 Output 
    print("PROGRAM #1")
    book1 = Book("Python Basics", "Maria Santos", 450.00)
    ebook1 = EBook("Learning OOP", "Ana Cruz", 300.00, 5)
    
    print(book1)
    print()
    print(ebook1)
    
    print("\n" + "-"*40 + "\n")
    
    # Program 3 Output 
    print("PROGRAM #3")
    scholar1 = ScholarStudent("Carlo Reyes", "2026-001", 40000.00, 50)
    
    print(scholar1)
if __name__ == "__main__":
    main()