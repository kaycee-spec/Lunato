package com.mycompany.week10_ooprmidterm_machineprob_activity4;

import java.util.Scanner;   // import lets us use the Scanner class (for keyboard input)

// A class is the container of all Java code. The class name must match the file name.
public class Week10_ooprmidterm_machineprob_activity4 {

    // 'static' = belongs to the class itself (no object needed). 'final' = value can never change.
    // One shared Scanner reads from the keyboard (System.in) for the whole program.
    static final Scanner sc = new Scanner(System.in);
    static final int W = 52;    // W = width (in characters) of the receipts and lines

    // =====================================================
    //                    INPUT HELPERS
    // =====================================================

    // Shows a prompt and returns what the user typed as text (String).
    static String str(String p) {
        System.out.print(p + ": ");      // print() shows text without moving to a new line
        return sc.nextLine().trim();     // nextLine() reads a full line; trim() removes extra spaces
    }

    // Asks for a decimal number (double). Repeats until the input is valid.
    static double dbl(String p) {
        while (true) {                   // infinite loop; we leave it using 'return'
            try {                        // try = attempt code that might fail
                // remove % and commas so "10%" or "1,500" still work
                String s = str(p).replace("%", "").replace(",", "");
                return Double.parseDouble(s);   // convert text to a double number
            } catch (NumberFormatException e) { // runs only if the text was not a number
                System.out.println("  Invalid number. Try again.");
            }
        }
    }

    // Asks for a whole number (int). Repeats until the input is valid.
    static int integer(String p) {
        while (true) {
            try {
                return Integer.parseInt(str(p));  // convert text to an int
            } catch (NumberFormatException e) {
                System.out.println("  Invalid whole number. Try again.");
            }
        }
    }

    // Reads a time like "08:30" and returns it as total minutes since midnight (08:30 -> 510).
    static int minutes(String p) {
        while (true) {
            try {
                String[] t = str(p).split(":");          // split "08:30" into {"08","30"}
                int h = Integer.parseInt(t[0].trim());   // hours part
                int m = Integer.parseInt(t[1].trim());   // minutes part
                // check that the time is valid (hours 0-23, minutes 0-59); && means AND
                if (h >= 0 && h < 24 && m >= 0 && m < 60) return h * 60 + m;
            } catch (Exception e) { }                    // ignore any error, we show a message below
            System.out.println("  Invalid time. Use HH:MM (24-hour).");
        }
    }

    // =====================================================
    //                    OUTPUT HELPERS
    // =====================================================

    // Prints a line made of W copies of the character c (like ----- or =====).
    static void line(char c) {
        StringBuilder sb = new StringBuilder();          // StringBuilder builds text efficiently
        for (int i = 0; i < W; i++) sb.append(c);        // for loop: repeat W times
        System.out.println(sb);                          // println() prints and moves to next line
    }

    // Prints a centered title between two lines of stars.
    static void title(String t) {
        System.out.println();                            // blank line
        line('*');
        int pad = Math.max(0, (W - t.length()) / 2);     // spaces needed to center the title
        System.out.println(" ".repeat(pad) + t);         // repeat() makes 'pad' spaces; + joins text
        line('*');
    }

    // Prints a section heading with a dashed line under it.
    static void section(String s) {
        System.out.println(s);
        line('-');
    }

    // Prints a label on the left and a text value aligned on the right.
    // printf uses format codes: %-24s = left-aligned text, 24 wide; %27s = right-aligned, 27 wide;
    // %n = new line.
    static void text(String label, String value) {
        System.out.printf("%-24s %27s%n", label, value);
    }

    // Prints a label and a money value with 2 decimals.
    // %,.2f = number with comma separators and 2 decimal places.
    static void money(String label, double v) {
        System.out.printf("%-24s %27s%n", label, String.format("%,.2f", v));
    }

    // Prints a label and a percent value. %% prints a real % sign.
    static void pct(String label, double v) {
        System.out.printf("%-24s %26.2f%%%n", label, v);
    }

    // Prints the table header for item lists (Item Name, Qty, Price, Total).
    static void itemsHeader() {
        System.out.printf("%-20s %5s %12s %12s%n", "Item Name", "Qty", "Price", "Total");
        line('-');
    }

    // Prints one item row in the table. %5d = whole number, 5 wide.
    static void itemRow(String n, int q, double p) {
        if (n.length() > 20) n = n.substring(0, 20);     // cut long names so columns stay aligned
        System.out.printf("%-20s %5d %,12.2f %,12.2f%n", n, q, p, q * p);
    }

    // Asks how many items; keeps asking until the user enters 3 or more.
    static int readItemCount() {
        int n;
        do {                                              // do-while: runs at least once
            n = integer("Number of items (at least 3)");
            if (n < 3) System.out.println("  Please enter at least 3 items.");
        } while (n < 3);                                  // repeat while the answer is too small
        return n;
    }

    // =====================================================
    //                      MAIN MENU
    // =====================================================

    // main is where every Java program starts running.
    public static void main(String[] args) {
        String again;                                     // stores the Y/N answer
        do {                                              // the whole menu repeats while the user says Y
            System.out.println();
            System.out.println("Choose the program you want to run");
            System.out.println();
            System.out.println("Number 1  - Programming 18: Smart Payslip Generator");
            System.out.println("Number 2  - Programming 19: Student Tuition Fee Billing System");
            System.out.println("Number 3  - Programming 20: Customer Purchase Order with Receipt");
            System.out.println("Number 4  - Programming 21: Simple Ticketing System");
            System.out.println("Number 5  - Programming 22: Simple Reservation and Billing System");
            System.out.println("Number 6  - Programming 23: Simple CRS - Car Rental System");
            System.out.println("Number 7  - Programming 24: Simple ROS - Restaurant Ordering System");
            System.out.println("Number 8  - Programming 25: Flower Reservation with Billing");
            System.out.println("Number 9  - Programming 26: KMART Korean Noodles Purchase Order");
            System.out.println("Number 10 - Programming 27: Car and Motor Parking Billing");
            System.out.println();
            int choice = integer("Enter number (1-10)");
            System.out.println();

            // switch picks one block of code depending on the value of 'choice'
            switch (choice) {
                case 1: payslip(); break;        // 'break' stops the switch after running a case
                case 2: tuition(); break;
                case 3: receipt(); break;
                case 4: ticket(); break;
                case 5: reservation(); break;
                case 6: carRental(); break;
                case 7: restaurant(); break;
                case 8: flower(); break;
                case 9: kmart(); break;
                case 10: parking(); break;
                default: System.out.println("Invalid choice. Please pick 1 to 10."); // any other number
            }

            System.out.println();
            do {
                again = str("Do you want to continue ? Y/N").toUpperCase(); // convert to capital letters
            } while (!again.equals("Y") && !again.equals("N"));  // ! means NOT; keep asking until Y or N
        } while (again.equals("Y"));                      // .equals() compares text; Y = run the menu again
        System.out.println("Thank you! Program ended.");
    }

    // =====================================================
    //   PROGRAMMING 18: SMART PAYSLIP GENERATOR
    // =====================================================
    static void payslip() {
        System.out.println("=== Programming 18: Smart Payslip Generator ===");

        // ----- inputs (String = text, double = decimal number) -----
        String name = str("Employee Name");
        String id = str("Employee ID");
        String dept = str("Department");
        double salary = dbl("Basic Monthly Salary");
        String start = str("Payroll Start Date (YYYY-MM-DD)");
        String end = str("Payroll End Date (YYYY-MM-DD)");
        String payout = str("Payout Date (YYYY-MM-DD)");
        double regHrs = dbl("Total Regular Hours Worked");
        double otHrs = dbl("Overtime Hours Worked");
        double absent = dbl("Number of Absent Days");
        double rice = dbl("Rice Allowance");
        double trans = dbl("Transportation Allowance");
        double comm = dbl("Communication Allowance");
        double sss = dbl("SSS Contribution");
        double phil = dbl("PhilHealth Contribution");
        double pagibig = dbl("PAG-IBIG Contribution");
        double tax = dbl("Withholding Tax");
        double other = dbl("Other Deductions");

        // ----- computations (/ divide, * multiply, + add, - subtract) -----
        double hourly = salary / 160;                     // hourly rate
        double daily = salary / 20;                       // daily rate
        double regularPay = regHrs * hourly;
        double otPay = otHrs * (hourly * 1.25);           // overtime is paid 25% higher
        double absDed = absent * daily;                   // deduction for absences
        double totalAllow = rice + trans + comm;
        double gross = regularPay + otPay + totalAllow;
        double totalDed = sss + phil + pagibig + tax + other + absDed;
        double net = gross - totalDed;                    // take-home pay

        // ----- output -----
        title("*** Smart Employee Payslip ***");
        section("Employee Details");
        text("Name", name);
        text("Employee ID", id);
        text("Department", dept);
        line('-');
        section("Payroll Summary");
        text("Pay Period", start + " to " + end);
        text("Payout Date", payout);
        line('-');
        section("Earnings");
        money("Regular Pay", regularPay);
        money("Overtime Pay", otPay);
        money("Total Allowances", totalAllow);
        money("GROSS PAY", gross);
        line('-');
        section("Allowances Breakdown");
        money("Rice Allowance", rice);
        money("Transportation", trans);
        money("Communication", comm);
        line('-');
        section("Deductions");
        money("SSS", sss);
        money("PhilHealth", phil);
        money("PAG-IBIG", pagibig);
        money("Withholding Tax", tax);
        money("Absence Deduction", absDed);
        money("Other Deductions", other);
        money("TOTAL DEDUCTIONS", totalDed);
        line('=');
        money("NET PAY", net);
        line('=');
    }

    // =====================================================
    //   PROGRAMMING 19: STUDENT TUITION FEE BILLING
    // =====================================================
    static void tuition() {
        System.out.println("=== Programming 19: Student Tuition Fee Billing System ===");

        String name = str("Student Name");
        String id = str("Student ID");
        String course = str("Course/Program (e.g., BSIT)");
        String year = str("Year Level");
        int units = integer("Number of Units Enrolled");  // int = whole number
        double perUnit = dbl("Tuition Fee per Unit");
        double misc = dbl("Miscellaneous Fee");
        double lab = dbl("Laboratory Fee");
        double lib = dbl("Library Fee");
        double otherFees = dbl("Other Fees");
        double down = dbl("Down Payment");
        double scholarship = dbl("Scholarship Discount (amount, 0 if none)");

        double tuitionTotal = units * perUnit;            // units x fee per unit
        double addFees = lab + lib + otherFees;           // total additional fees
        double gross = tuitionTotal + misc + addFees;
        double net = gross - scholarship;                 // discount is a fixed amount, not a percent
        double balance = net - down;

        title("*** STUDENT TUITION BILLING SYSTEM ***");
        section("Student Details");
        text("Name", name);
        text("Student ID", id);
        text("Course", course);
        text("Year Level", year);
        line('-');
        section("Enrollment Summary");
        text("Units Enrolled", String.valueOf(units));    // valueOf converts a number to text
        money("Tuition per Unit", perUnit);
        money("Tuition Fee Total", tuitionTotal);
        line('-');
        section("Fees Breakdown");
        money("Miscellaneous Fee", misc);
        money("Laboratory Fee", lab);
        money("Library Fee", lib);
        money("Other Fees", otherFees);
        money("GROSS TOTAL FEE", gross);
        line('-');
        section("Payment Summary");
        money("Scholarship Discount", scholarship);
        money("NET TOTAL FEE", net);
        money("Down Payment", down);
        line('=');
        money("REMAINING BALANCE", balance);
        line('=');
    }

    // =====================================================
    //   PROGRAMMING 20: CUSTOMER PURCHASE ORDER WITH RECEIPT
    // =====================================================
    static void receipt() {
        System.out.println("=== Programming 20: Customer Purchase Order with Receipt ===");

        String name = str("Customer Name");
        String id = str("Customer ID");
        int n = readItemCount();                          // how many items (3 or more)

        // Arrays store many values of the same type. Size n = one slot per item.
        String[] names = new String[n];
        int[] qty = new int[n];
        double[] price = new double[n];
        double subtotal = 0;                              // running total, starts at 0

        // for loop: i goes 0,1,2,... until n-1 (array positions start at 0)
        for (int i = 0; i < n; i++) {
            System.out.println("Item " + (i + 1) + ":");
            names[i] = str("  Item Name");
            qty[i] = integer("  Quantity");
            price[i] = dbl("  Price per Item");
            subtotal += qty[i] * price[i];                // += adds the item total to subtotal
        }
        double disc = dbl("Discount (%)");
        double tendered = dbl("Amount Tendered");

        double discAmt = subtotal * (disc / 100);         // percent -> amount
        double due = subtotal - discAmt;
        double change = tendered - due;

        title("******** CUSTOMER RECEIPT ********");
        section("Customer Details");
        text("Name", name);
        text("Customer ID", id);
        line('-');
        section("Purchased Items");
        itemsHeader();
        for (int i = 0; i < n; i++) itemRow(names[i], qty[i], price[i]);  // print every item
        line('-');
        section("Payment Summary");
        money("Subtotal", subtotal);
        pct("Discount (%)", disc);
        money("Discount Amount", discAmt);
        money("TOTAL AMOUNT DUE", due);
        money("Amount Tendered", tendered);
        // if-else: show Change if enough money was given, otherwise show how much is missing
        if (change >= 0) money("Change", change);
        else money("Insufficient (Short by)", -change);
        line('=');
    }

    // =====================================================
    //   PROGRAMMING 21: SIMPLE TICKETING SYSTEM
    // =====================================================
    static void ticket() {
        System.out.println("=== Programming 21: Simple Ticketing System ===");

        String name = str("Customer Name");
        String id = str("Customer ID");
        String event = str("Event Name");
        String type = str("Ticket Type (Regular/VIP)");
        double price = dbl("Ticket Price");
        int qty = integer("Number of Tickets");
        double disc = dbl("Discount (%) (0 if none)");
        double tendered = dbl("Amount Tendered");

        double total = price * qty;
        double discAmt = total * (disc / 100);
        double due = total - discAmt;
        double change = tendered - due;

        title("******** EVENT TICKET ********");
        section("Customer Details");
        text("Name", name);
        text("Customer ID", id);
        line('-');
        section("Ticket Information");
        text("Event Name", event);
        text("Ticket Type", type);
        money("Ticket Price", price);
        text("Number of Tickets", String.valueOf(qty));
        money("Total Ticket Cost", total);
        line('-');
        section("Payment Summary");
        pct("Discount (%)", disc);
        money("Discount Amount", discAmt);
        money("FINAL AMOUNT DUE", due);
        money("Amount Tendered", tendered);
        if (change >= 0) money("Change", change);
        else money("Insufficient (Short by)", -change);
        line('=');
    }

    // =====================================================
    //   PROGRAMMING 22: SIMPLE RESERVATION AND BILLING
    // =====================================================
    static void reservation() {
        System.out.println("=== Programming 22: Simple Reservation and Billing System ===");

        String name = str("Customer Name");
        String id = str("Customer ID");
        String type = str("Reservation Type (Room/Cottage/Table)");
        double dur = dbl("Number of Days/Hours Reserved");
        double rate = dbl("Rate per Day/Hour");
        double food = dbl("Food Charges");
        double service = dbl("Service Charges");
        double other = dbl("Other Charges");
        double disc = dbl("Discount (%)");
        double down = dbl("Down Payment");

        double resCost = dur * rate;
        double addCharges = food + service + other;
        double subtotal = resCost + addCharges;
        double discAmt = subtotal * (disc / 100);
        double total = subtotal - discAmt;
        double balance = total - down;

        title("******** RESERVATION BILLING ********");
        section("Customer Details");
        text("Name", name);
        text("Customer ID", id);
        line('-');
        section("Reservation Details");
        text("Reservation Type", type);
        text("Duration (Days/Hours)", String.format("%.2f", dur));  // String.format builds formatted text
        money("Rate", rate);
        money("Reservation Cost", resCost);
        line('-');
        section("Charges Breakdown");
        money("Food Charges", food);
        money("Service Charges", service);
        money("Other Charges", other);
        money("SUBTOTAL", subtotal);
        line('-');
        section("Payment Summary");
        pct("Discount (%)", disc);
        money("Discount Amount", discAmt);
        money("TOTAL BILL", total);
        money("Down Payment", down);
        line('=');
        money("REMAINING BALANCE", balance);
        line('=');
    }

    // =====================================================
    //   PROGRAMMING 23: SIMPLE CRS - CAR RENTAL SYSTEM
    // =====================================================
    static void carRental() {
        System.out.println("=== Programming 23: Simple CRS - Car Rental System ===");

        String name = str("Customer Name");
        String id = str("Customer ID");
        String lic = str("Driver's License Number");
        String vType = str("Vehicle Type (Sedan/SUV/Van)");
        String model = str("Vehicle Model");
        double rate = dbl("Rental Rate per Day");
        int days = integer("Number of Rental Days");
        String pickup = str("Pickup Date (YYYY-MM-DD)");
        String ret = str("Return Date (YYYY-MM-DD)");
        double ins = dbl("Insurance Fee");
        double fuel = dbl("Fuel Charge");
        double other = dbl("Other Charges");
        double disc = dbl("Discount (%)");
        double paid = dbl("Amount Paid");

        double rentalCost = rate * days;
        double addCharges = ins + fuel + other;
        double subtotal = rentalCost + addCharges;
        double discAmt = subtotal * (disc / 100);
        double due = subtotal - discAmt;

        title("******** CAR RENTAL RECEIPT ********");
        section("Customer Details");
        text("Name", name);
        text("Customer ID", id);
        text("Driver's License No.", lic);
        line('-');
        section("Vehicle Information");
        text("Vehicle Type", vType);
        text("Vehicle Model", model);
        money("Rate per Day", rate);
        line('-');
        section("Rental Summary");
        text("Pickup Date", pickup);
        text("Return Date", ret);
        text("Number of Days", String.valueOf(days));
        money("Rental Cost", rentalCost);
        line('-');
        section("Charges Breakdown");
        money("Insurance Fee", ins);
        money("Fuel Charge", fuel);
        money("Other Charges", other);
        money("SUBTOTAL", subtotal);
        line('-');
        section("Payment Summary");
        pct("Discount (%)", disc);
        money("Discount Amount", discAmt);
        money("TOTAL AMOUNT DUE", due);
        money("Amount Paid", paid);
        // if paid enough -> show Change, else -> show Remaining Balance
        if (paid >= due) money("Change", paid - due);
        else money("Remaining Balance", due - paid);
        line('=');
    }

    // =====================================================
    //   PROGRAMMING 24: SIMPLE ROS - RESTAURANT ORDERING
    // =====================================================
    static void restaurant() {
        System.out.println("=== Programming 24: Simple ROS - Restaurant Ordering System ===");

        String name = str("Customer Name");
        String type;
        while (true) {                                    // keep asking until a valid order type is typed
            type = str("Order Type (Dine-In or Takeout)");
            // equalsIgnoreCase compares text ignoring capital/small letters; || means OR
            if (type.equalsIgnoreCase("Dine-In") || type.equalsIgnoreCase("DineIn")) { type = "Dine-In"; break; }
            if (type.equalsIgnoreCase("Takeout") || type.equalsIgnoreCase("Take-out")) { type = "Takeout"; break; }
            System.out.println("  Please enter Dine-In or Takeout.");
        }
        boolean dineIn = type.equals("Dine-In");          // boolean = true or false

        int n = readItemCount();
        String[] names = new String[n];
        int[] qty = new int[n];
        double[] price = new double[n];
        double subtotal = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Item " + (i + 1) + ":");
            names[i] = str("  Item Name");
            qty[i] = integer("  Quantity");
            price[i] = dbl("  Price per Item");
            subtotal += qty[i] * price[i];
        }
        double serviceCharge = dbl("Service Charge (0 if Takeout)");
        double packaging = dbl("Packaging Fee (0 if Dine-In)");
        double disc = dbl("Discount (%)");
        double tendered = dbl("Amount Tendered");

        // ternary operator: condition ? valueIfTrue : valueIfFalse
        double charge = dineIn ? serviceCharge : packaging;
        double before = subtotal + charge;                // total before discount
        double discAmt = before * (disc / 100);
        double due = before - discAmt;
        double change = tendered - due;

        title("******** RESTAURANT RECEIPT ********");
        section("Customer Details");
        text("Name", name);
        text("Order Type", type);
        line('-');
        section("Order Summary");
        itemsHeader();
        for (int i = 0; i < n; i++) itemRow(names[i], qty[i], price[i]);
        line('-');
        section("Billing Summary");
        money("Subtotal", subtotal);
        money(dineIn ? "Service Charge" : "Packaging Fee", charge);  // label depends on order type
        money("Total Before Discount", before);
        pct("Discount (%)", disc);
        money("Discount Amount", discAmt);
        money("TOTAL AMOUNT DUE", due);
        money("Amount Tendered", tendered);
        if (change >= 0) money("Change", change);
        else money("Insufficient (Short by)", -change);
        line('=');
    }

    // =====================================================
    //   PROGRAMMING 25: FLOWER RESERVATION WITH BILLING
    // =====================================================
    static void flower() {
        System.out.println("=== Programming 25: Flower Reservation with Billing ===");

        String name = str("Customer Name");
        String id = str("Customer ID");
        String contact = str("Contact Number");
        String flower = str("Flower Type (Roses/Tulips/Sunflowers)");
        String arr = str("Arrangement Type (Bouquet/Vase/Box)");
        double price = dbl("Price per Arrangement");
        int qty = integer("Quantity");
        String resDate = str("Reservation Date (YYYY-MM-DD)");
        String delDate = str("Pickup/Delivery Date (YYYY-MM-DD)");
        double delivery = dbl("Delivery Fee");
        double custom = dbl("Customization Fee");
        double other = dbl("Other Charges");
        double disc = dbl("Discount (%)");
        double down = dbl("Down Payment");

        double resCost = price * qty;
        double addCharges = delivery + custom + other;
        double subtotal = resCost + addCharges;
        double discAmt = subtotal * (disc / 100);
        double total = subtotal - discAmt;
        double balance = total - down;

        title("**** FLOWER RESERVATION RECEIPT ****");
        section("Customer Details");
        text("Name", name);
        text("Customer ID", id);
        text("Contact Number", contact);
        line('-');
        section("Reservation Summary");
        text("Flower Type", flower);
        text("Arrangement Type", arr);
        text("Quantity", String.valueOf(qty));
        money("Price per Arrangement", price);
        money("Reservation Cost", resCost);
        text("Reservation Date", resDate);
        text("Pickup/Delivery Date", delDate);
        line('-');
        section("Charges Breakdown");
        money("Delivery Fee", delivery);
        money("Customization Fee", custom);
        money("Other Charges", other);
        money("SUBTOTAL", subtotal);
        line('-');
        section("Payment Summary");
        pct("Discount (%)", disc);
        money("Discount Amount", discAmt);
        money("TOTAL BILL", total);
        money("Down Payment", down);
        line('=');
        money("REMAINING BALANCE", balance);
        line('=');
    }

    // =====================================================
    //   PROGRAMMING 26: KMART KOREAN NOODLES PURCHASE ORDER
    // =====================================================
    static void kmart() {
        System.out.println("=== Programming 26: KMART Korean Noodles Purchase Order ===");

        String name = str("Customer Name");
        String id = str("Customer ID");
        String contact = str("Contact Number");
        String product = str("Product Name (e.g., Shin Ramyun)");
        String brand = str("Brand");
        double price = dbl("Price per Pack");
        int qty = integer("Quantity");
        double pack = dbl("Packaging Fee");
        double delivery = dbl("Delivery Fee (0 if none)");
        double disc = dbl("Discount (%)");
        double cash = dbl("Cash Payment");

        double productCost = price * qty;
        double subtotal = productCost + pack + delivery;
        double discAmt = subtotal * (disc / 100);
        double total = subtotal - discAmt;

        title("**** KMART PURCHASE RECEIPT ****");
        section("Customer Details");
        text("Name", name);
        text("Customer ID", id);
        text("Contact Number", contact);
        line('-');
        section("Order Summary");
        text("Product Name", product);
        text("Brand", brand);
        money("Price per Pack", price);
        text("Quantity", String.valueOf(qty));
        money("Total Product Cost", productCost);
        line('-');
        section("Charges");
        money("Packaging Fee", pack);
        money("Delivery Fee", delivery);
        money("SUBTOTAL", subtotal);
        line('-');
        section("Payment Summary");
        pct("Discount (%)", disc);
        money("Discount Amount", discAmt);
        money("TOTAL BILL", total);
        money("Cash Payment", cash);
        if (cash >= total) money("Change", cash - total);
        else money("Remaining Balance", total - cash);
        line('=');
    }

    // =====================================================
    //   PROGRAMMING 27: CAR AND MOTOR PARKING BILLING
    // =====================================================
    static void parking() {
        System.out.println("=== Programming 27: Car and Motor Parking Billing System ===");

        String name = str("Customer Name");
        String id = str("Customer ID");
        String contact = str("Contact Number");
        String vType = str("Vehicle Type (Car or Motorcycle)");
        String plate = str("Plate Number");
        int entry = minutes("Entry Time (HH:MM)");        // stored as minutes since midnight
        int exit = minutes("Exit Time (HH:MM)");
        double rate = dbl("Hourly Rate");
        double resFee = dbl("Reservation Fee");
        double overnight = dbl("Overnight Fee (0 if none)");
        double penalty = dbl("Penalty Fee (0 if none)");
        double disc = dbl("Discount (%)");
        double cash = dbl("Cash Payment");

        int diff = exit - entry;                          // minutes parked
        if (diff < 0) diff += 24 * 60;                    // negative = exit is the next day, add 24 hours
        double hours = diff / 60.0;                       // 60.0 (not 60) keeps the decimals, e.g. 4.5 hours
        double parkingFee = hours * rate;
        double subtotal = parkingFee + resFee + overnight + penalty;
        double discAmt = subtotal * (disc / 100);
        double total = subtotal - discAmt;

        title("******** PARKING RECEIPT ********");
        section("Customer Details");
        text("Name", name);
        text("Customer ID", id);
        text("Contact Number", contact);
        line('-');
        section("Vehicle Details");
        text("Vehicle Type", vType);
        text("Plate Number", plate);
        line('-');
        section("Parking Summary");
        // %02d = whole number padded with a leading zero (8 -> 08); / gives hours, % gives leftover minutes
        text("Entry Time", String.format("%02d:%02d", entry / 60, entry % 60));
        text("Exit Time", String.format("%02d:%02d", exit / 60, exit % 60));
        text("Total Hours", String.format("%d hr %02d min (%.2f)", diff / 60, diff % 60, hours));
        money("Hourly Rate", rate);
        money("Parking Fee", parkingFee);
        line('-');
        section("Charges Breakdown");
        money("Reservation Fee", resFee);
        money("Overnight Fee", overnight);
        money("Penalty Fee", penalty);
        money("SUBTOTAL", subtotal);
        line('-');
        section("Payment Summary");
        pct("Discount (%)", disc);
        money("Discount Amount", discAmt);
        money("TOTAL BILL", total);
        money("Cash Payment", cash);
        if (cash >= total) money("Change", cash - total);
        else money("Remaining Balance", total - cash);
        line('=');
    }
}