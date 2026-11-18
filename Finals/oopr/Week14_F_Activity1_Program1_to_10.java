package com.mycompany.week14_f_activity1_program1_to_10;

import java.util.Scanner;

public class Week14_F_Activity1_Program1_to_10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            printMenu();
            int choice = getValidInt(sc, "Choose a program (1-10): ", 1, 10);

            switch (choice) {
                case 1: runProgram1(sc); break;
                case 2: runProgram2(sc); break;
                case 3: runProgram3(sc); break;
                case 4: runProgram4(sc); break;
                case 5: runProgram5(sc); break;
                case 6: runProgram6(sc); break;
                case 7: runProgram7(sc); break;
                case 8: runProgram8(sc); break;
                case 9: runProgram9(sc); break;
                case 10: runProgram10(sc); break;
            }

            keepRunning = askToContinue(sc);
        }

        System.out.println("Program terminated. Goodbye!");
        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n==========================================");
        System.out.println("   WEEK 14 - JAVA ARRAYS ACTIVITY MENU");
        System.out.println("==========================================");
        System.out.println(" 1. Program 1: Exam Score Statistics");
        System.out.println(" 2. Program 2: Store Stock Reorder Report");
        System.out.println(" 3. Program 3: Branch Sales Matrix");
        System.out.println(" 4. Program 4: Classroom Seat Booking");
        System.out.println(" 5. Program 5: Temperature Monitoring");
        System.out.println(" 6. Program 6: Shopping Cart and Checkout");
        System.out.println(" 7. Program 7: Warehouse Stock Transfers");
        System.out.println(" 8. Program 8: Student Performance Analyzer");
        System.out.println(" 9. Program 9: Consecutive Theater Reservations");
        System.out.println("10. Program 10: Weekly Inventory and Lost Sales");
        System.out.println("==========================================");
    }

    // =========================================================================
    // SHARED HELPER METHODS
    // =========================================================================
    public static int getValidInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                if (val >= min && val <= max) {
                    return val;
                }
            } else {
                sc.next();
            }
            System.out.println("Invalid input. Must be between " + min + " and " + max + ".");
        }
    }

    public static boolean askToContinue(Scanner sc) {
        while (true) {
            System.out.print("\nDo you want to continue? (Y/N): ");
            String input = sc.next().trim().toUpperCase();
            if (input.equals("Y") || input.equals("YES")) {
                return true;
            } else if (input.equals("N") || input.equals("NO")) {
                return false;
            }
            System.out.println("Invalid choice. Please enter Y or N.");
        }
    }

    /** Prints a 2D int array, one row per line, values separated by single spaces. */
    private static void printMatrix(int[][] grid) {
        for (int[] row : grid) {
            StringBuilder line = new StringBuilder();
            for (int c = 0; c < row.length; c++) {
                if (c > 0) line.append(' ');
                line.append(row[c]);
            }
            System.out.println(line);
        }
    }

    /** Counts how many cells in a 2D int array are zero. */
    private static int countZeros(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 0) count++;
            }
        }
        return count;
    }

    // =========================================================================
    // PROGRAM 1: EXAM SCORE STATISTICS
    // =========================================================================
    public static void runProgram1(Scanner sc) {
        System.out.println("\n--- Program 1: Exam Score Statistics ---");
        int n = getValidInt(sc, "Students: ", 1, 50);
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = getValidInt(sc, "Score " + (i + 1) + ": ", 0, 100);
        }

        int sum = 0;
        int highest = scores[0];
        int lowest = scores[0];
        int passCount = 0;
        int failCount = 0;

        for (int s : scores) {
            sum += s;
            if (s > highest) highest = s;
            if (s < lowest) lowest = s;
            if (s >= 75) passCount++;
            else failCount++;
        }

        System.out.printf("Average: %.2f%n", (double) sum / n);
        System.out.println("Highest: " + highest + " Lowest: " + lowest);
        System.out.println("Passed: " + passCount + " Failed: " + failCount);

        System.out.print("Top student numbers:");
        for (int i = 0; i < n; i++) {
            if (scores[i] == highest) System.out.print(" " + (i + 1));
        }
        System.out.println();
    }

    // =========================================================================
    // PROGRAM 2: STORE STOCK REORDER REPORT
    // =========================================================================
    public static void runProgram2(Scanner sc) {
        System.out.println("\n--- Program 2: Store Stock Reorder Report ---");
        String[] names = {"Notebook", "Pen", "Folder", "USB"};
        int[] reorder = {5, 10, 5, 2};
        int[] target = {20, 30, 20, 10};
        int[] stock = new int[names.length];

        for (int i = 0; i < names.length; i++) {
            stock[i] = getValidInt(sc, names[i] + " stock: ", 0, 10000);
        }

        int totalStock = 0;
        int totalSuggestedOrder = 0;
        for (int i = 0; i < names.length; i++) {
            int orderQty = (stock[i] <= reorder[i]) ? target[i] - stock[i] : 0;
            totalStock += stock[i];
            totalSuggestedOrder += orderQty;
            System.out.println(names[i] + " stock=" + stock[i] + " order=" + orderQty);
        }

        System.out.println("Total stock: " + totalStock);
        System.out.println("Total suggested order: " + totalSuggestedOrder);
    }

    // =========================================================================
    // PROGRAM 3: BRANCH SALES MATRIX
    // =========================================================================
    public static void runProgram3(Scanner sc) {
        System.out.println("\n--- Program 3: Branch Sales Matrix ---");
        final int BRANCHES = 3;
        final int DAYS = 5;
        int[][] sales = new int[BRANCHES][DAYS];

        for (int b = 0; b < BRANCHES; b++) {
            for (int d = 0; d < DAYS; d++) {
                sales[b][d] = getValidInt(sc, "Branch " + (b + 1) + " day " + (d + 1) + ": ", 0, 1000000);
            }
        }

        int[] branchTotals = new int[BRANCHES];
        int[] dayTotals = new int[DAYS];
        int grandTotal = 0;

        for (int b = 0; b < BRANCHES; b++) {
            for (int d = 0; d < DAYS; d++) {
                branchTotals[b] += sales[b][d];
                dayTotals[d] += sales[b][d];
                grandTotal += sales[b][d];
            }
        }

        int maxBranchTotal = branchTotals[0];
        for (int b = 1; b < BRANCHES; b++) {
            if (branchTotals[b] > maxBranchTotal) maxBranchTotal = branchTotals[b];
        }

        for (int b = 0; b < BRANCHES; b++) {
            System.out.println("Branch " + (b + 1) + " PHP " + branchTotals[b]);
        }
        for (int d = 0; d < DAYS; d++) {
            System.out.println("Day " + (d + 1) + " PHP " + dayTotals[d]);
        }
        System.out.println("Grand total PHP " + grandTotal);

        System.out.print("Top branch:");
        for (int b = 0; b < BRANCHES; b++) {
            if (branchTotals[b] == maxBranchTotal) System.out.print(" " + (b + 1));
        }
        System.out.println();
    }

    // =========================================================================
    // PROGRAM 4: CLASSROOM SEAT BOOKING
    // =========================================================================
    public static void runProgram4(Scanner sc) {
        System.out.println("\n--- Program 4: Classroom Seat Booking ---");
        int[][] seats = new int[4][5];

        while (true) {
            System.out.println("1 Book 2 Cancel 3 Display 0 Exit");
            int choice = getValidInt(sc, "Choice: ", 0, 3);

            if (choice == 0) {
                break;
            }
            if (choice == 3) {
                displayClassroomSeats(seats);
                continue;
            }

            int r = getValidInt(sc, "Row: ", 1, 4) - 1;
            int c = getValidInt(sc, "Column: ", 1, 5) - 1;
            String label = "Seat (" + (r + 1) + "," + (c + 1) + ")";

            if (choice == 1) {
                if (seats[r][c] == 1) {
                    System.out.println("Error: " + label + " is already booked.");
                } else {
                    seats[r][c] = 1;
                }
            } else {
                if (seats[r][c] == 0) {
                    System.out.println("Error: " + label + " is already empty.");
                } else {
                    seats[r][c] = 0;
                }
            }
            displayClassroomSeats(seats);
        }
    }

    private static void displayClassroomSeats(int[][] seats) {
        printMatrix(seats);
        System.out.println("Available: " + countZeros(seats));
    }

    // =========================================================================
    // PROGRAM 5: TEMPERATURE MONITORING
    // =========================================================================
    public static void runProgram5(Scanner sc) {
        System.out.println("\n--- Program 5: Temperature Monitoring ---");
        final int SENSORS = 3;
        final int PERIODS = 4;
        int[][] temperatures = new int[SENSORS][PERIODS];
        int maxTemp = Integer.MIN_VALUE;

        for (int s = 0; s < SENSORS; s++) {
            int sum = 0;
            for (int p = 0; p < PERIODS; p++) {
                temperatures[s][p] = getValidInt(sc, "Sensor " + (s + 1) + " period " + (p + 1) + ": ", -20, 60);
                sum += temperatures[s][p];
                if (temperatures[s][p] > maxTemp) maxTemp = temperatures[s][p];
            }
            System.out.printf("Sensor %d average: %.2f%n", (s + 1), (double) sum / PERIODS);
        }

        System.out.println("Maximum temperature: " + maxTemp);

        boolean anyAlert = false;
        for (int s = 0; s < SENSORS; s++) {
            for (int p = 0; p < PERIODS; p++) {
                if (temperatures[s][p] > 35) {
                    System.out.println("ALERT sensor " + (s + 1) + " period " + (p + 1)
                            + " temperature " + temperatures[s][p]);
                    anyAlert = true;
                }
            }
        }
        if (!anyAlert) System.out.println("No alerts.");

        for (int s = 0; s < SENSORS; s++) {
            for (int p = 0; p < PERIODS; p++) {
                if (temperatures[s][p] == maxTemp) {
                    System.out.println("Maximum at sensor " + (s + 1) + " period " + (p + 1));
                }
            }
        }
    }

    // =========================================================================
    // PROGRAM 6: SHOPPING CART AND CHECKOUT
    // =========================================================================
    public static void runProgram6(Scanner sc) {
        System.out.println("\n--- Program 6: Shopping Cart and Checkout ---");
        String[] names = {"USB", "Notebook", "Pen", "Folder"};
        int[] prices = {350, 200, 20, 15};
        int[] stock = {10, 10, 20, 20};
        int[] cart = new int[names.length];

        while (true) {
            showProducts(names, prices, stock, cart);
            System.out.println("1 Add 2 Remove 3 View 4 Pay 0 Cancel");
            int choice = getValidInt(sc, "Choice: ", 0, 4);

            if (choice == 0) {
                System.out.println("Order cancelled. Stock unchanged.");
                break;

            } else if (choice == 1) {
                int idx = getValidInt(sc, "Product number: ", 1, 4) - 1;
                int availableToAdd = stock[idx] - cart[idx];
                if (availableToAdd <= 0) {
                    System.out.println("No additional stock available for " + names[idx] + ".");
                    continue;
                }
                int qty = getValidInt(sc, "Quantity: ", 1, availableToAdd);
                cart[idx] += qty;

            } else if (choice == 2) {
                int idx = getValidInt(sc, "Product number: ", 1, 4) - 1;
                if (cart[idx] == 0) {
                    System.out.println("Item is not in the cart.");
                    continue;
                }
                int qty = getValidInt(sc, "Quantity: ", 1, cart[idx]);
                cart[idx] -= qty;

            } else if (choice == 3) {
                System.out.println("Cart subtotal PHP " + calculateSubtotal(prices, cart));

            } else {
                int subtotalPesos = calculateSubtotal(prices, cart);
                if (subtotalPesos == 0) {
                    System.out.println("Cart is empty. Cannot checkout.");
                    continue;
                }

                // Work in centavos to avoid floating-point rounding errors
                long subtotalCentavos = subtotalPesos * 100L;
                long discountCentavos = (subtotalPesos >= 1000) ? (subtotalCentavos * 10 + 50) / 100 : 0;
                long totalCentavos = subtotalCentavos - discountCentavos;

                System.out.printf("Subtotal PHP %.2f Discount PHP %.2f Total PHP %.2f%n",
                        subtotalCentavos / 100.0, discountCentavos / 100.0, totalCentavos / 100.0);

                int cashPesos = getValidInt(sc, "Cash payment in whole pesos: ", 0, 1000000);
                long cashCentavos = cashPesos * 100L;

                if (cashCentavos < totalCentavos) {
                    System.out.println("Insufficient payment. Cart and stock remain unchanged.");
                    continue;
                }

                for (int i = 0; i < names.length; i++) stock[i] -= cart[i];

                System.out.println("RECEIPT");
                for (int i = 0; i < names.length; i++) {
                    if (cart[i] > 0) {
                        System.out.println(names[i] + " x " + cart[i] + " remaining stock=" + stock[i]);
                    }
                }
                System.out.printf("Paid PHP %.2f Change PHP %.2f%n",
                        cashCentavos / 100.0, (cashCentavos - totalCentavos) / 100.0);
                break;
            }
        }
    }

    private static void showProducts(String[] names, int[] prices, int[] stock, int[] cart) {
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + " " + names[i] + " PHP " + prices[i]
                    + " stock=" + stock[i] + " cart=" + cart[i]);
        }
    }

    private static int calculateSubtotal(int[] prices, int[] cart) {
        int sum = 0;
        for (int i = 0; i < prices.length; i++) sum += prices[i] * cart[i];
        return sum;
    }

    // =========================================================================
    // PROGRAM 7: WAREHOUSE STOCK TRANSFERS
    // =========================================================================
    public static void runProgram7(Scanner sc) {
        System.out.println("\n--- Program 7: Warehouse Stock Transfers ---");
        final int MAX_HISTORY = 50;
        int[][] stock = {
            {20, 30, 40, 50},
            {15, 25, 35, 45},
            {10, 20, 30, 40}
        };
        final int initialTotal = sumAll(stock);

        // Each record: [source, destination, product, quantity]
        int[][] history = new int[MAX_HISTORY][4];
        int historyCount = 0;

        while (true) {
            System.out.println("1 Transfer 2 Stock 3 History 0 Exit");
            int choice = getValidInt(sc, "Choice: ", 0, 3);

            if (choice == 0) {
                break;

            } else if (choice == 1) {
                if (historyCount >= MAX_HISTORY) {
                    System.out.println("Transfer rejected: history log is full (50 records max).");
                    continue;
                }

                int src = getValidInt(sc, "Source warehouse: ", 1, 3) - 1;
                int dst = getValidInt(sc, "Destination warehouse: ", 1, 3) - 1;
                int prod = getValidInt(sc, "Product: ", 1, 4) - 1;
                int qty = getValidInt(sc, "Quantity: ", 1, 1000);

                if (src == dst) {
                    System.out.println("Transfer rejected: source and destination must be different.");
                } else if (qty > stock[src][prod]) {
                    System.out.println("Transfer rejected: insufficient source stock (available "
                            + stock[src][prod] + ").");
                } else if (stock[dst][prod] + qty > 1000) {
                    System.out.println("Transfer rejected: destination capacity (1000) exceeded.");
                } else {
                    stock[src][prod] -= qty;
                    stock[dst][prod] += qty;
                    history[historyCount][0] = src + 1;
                    history[historyCount][1] = dst + 1;
                    history[historyCount][2] = prod + 1;
                    history[historyCount][3] = qty;
                    historyCount++;
                    System.out.println("Transfer recorded.");
                    printConserved(stock, initialTotal);
                }

            } else if (choice == 2) {
                int[] productTotals = new int[4];
                for (int w = 0; w < stock.length; w++) {
                    StringBuilder line = new StringBuilder("Warehouse " + (w + 1) + ":");
                    for (int p = 0; p < productTotals.length; p++) {
                        line.append(' ').append(stock[w][p]);
                        productTotals[p] += stock[w][p];
                    }
                    System.out.println(line);
                }
                for (int p = 0; p < productTotals.length; p++) {
                    System.out.println("Product " + (p + 1) + " total=" + productTotals[p]);
                }
                printConserved(stock, initialTotal);

            } else {
                for (int i = 0; i < historyCount; i++) {
                    System.out.println((i + 1) + " from=" + history[i][0] + " to=" + history[i][1]
                            + " product=" + history[i][2] + " quantity=" + history[i][3]);
                }
                printConserved(stock, initialTotal);
            }
        }
    }

    private static int sumAll(int[][] grid) {
        int sum = 0;
        for (int[] row : grid) {
            for (int v : row) sum += v;
        }
        return sum;
    }

    private static void printConserved(int[][] stock, int initialTotal) {
        int total = sumAll(stock);
        System.out.println("Stock conserved: " + (total == initialTotal) + " total=" + total);
    }

    // =========================================================================
    // PROGRAM 8: STUDENT PERFORMANCE ANALYZER
    // =========================================================================
    public static void runProgram8(Scanner sc) {
        System.out.println("\n--- Program 8: Student Performance Analyzer ---");
        final int SUBJECTS = 4;
        int n = getValidInt(sc, "Students: ", 2, 10);

        int[][] marks = new int[n][SUBJECTS];
        double[] average = new double[n];
        boolean[] qualified = new boolean[n];
        int[] order = new int[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
            int sum = 0;
            boolean allSubjectsPassed = true;

            for (int s = 0; s < SUBJECTS; s++) {
                marks[i][s] = getValidInt(sc, "Student " + (i + 1) + " subject " + (s + 1) + ": ", 0, 100);
                sum += marks[i][s];
                if (marks[i][s] < 60) allSubjectsPassed = false;
            }

            average[i] = (double) sum / SUBJECTS;
            qualified[i] = (average[i] >= 75.0) && allSubjectsPassed;
        }

        // Stable insertion sort of student indices by average (descending),
        // so tied students keep their original order
        for (int i = 1; i < n; i++) {
            int key = order[i];
            int j = i - 1;
            while (j >= 0 && average[order[j]] < average[key] - 1e-9) {
                order[j + 1] = order[j];
                j--;
            }
            order[j + 1] = key;
        }

        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && Math.abs(average[order[i]] - average[order[i - 1]]) > 1e-9) rank = i + 1;
            int idx = order[i];
            System.out.printf("Rank %d Student %d Average %.2f %s%n",
                    rank, (idx + 1), average[idx],
                    qualified[idx] ? "Qualified" : "Not Qualified");
        }

        double[] subjAvg = new double[SUBJECTS];
        for (int s = 0; s < SUBJECTS; s++) {
            int sum = 0;
            for (int i = 0; i < n; i++) sum += marks[i][s];
            subjAvg[s] = (double) sum / n;
            System.out.printf("Subject %d average %.2f%n", (s + 1), subjAvg[s]);
        }

        double minAvg = subjAvg[0];
        for (int s = 1; s < SUBJECTS; s++) {
            if (subjAvg[s] < minAvg) minAvg = subjAvg[s];
        }

        System.out.print("Lowest average subject:");
        for (int s = 0; s < SUBJECTS; s++) {
            if (Math.abs(subjAvg[s] - minAvg) < 1e-9) System.out.print(" " + (s + 1));
        }
        System.out.println();
    }

    // =========================================================================
    // PROGRAM 9: CONSECUTIVE THEATER RESERVATIONS
    // =========================================================================
    public static void runProgram9(Scanner sc) {
        System.out.println("\n--- Program 9: Consecutive Theater Reservations ---");
        final int ROWS = 5;
        final int COLS = 8;
        int[][] seats = new int[ROWS][COLS];
        int nextBookingId = 1;

        while (true) {
            System.out.println("1 Book group 2 Cancel ID 3 Display 0 Exit");
            int choice = getValidInt(sc, "Choice: ", 0, 3);

            if (choice == 0) {
                break;

            } else if (choice == 1) {
                int groupSize = getValidInt(sc, "Group size: ", 1, 8);
                boolean booked = false;

                for (int r = 0; r < ROWS && !booked; r++) {
                    int consecutive = 0;
                    for (int c = 0; c < COLS; c++) {
                        if (seats[r][c] == 0) {
                            consecutive++;
                            if (consecutive == groupSize) {
                                int first = c - groupSize + 1;
                                for (int k = first; k <= c; k++) seats[r][k] = nextBookingId;
                                System.out.println("Booking " + nextBookingId + " row " + (r + 1)
                                        + " seats " + (first + 1) + " to " + (c + 1));
                                nextBookingId++;
                                booked = true;
                                break;
                            }
                        } else {
                            consecutive = 0;
                        }
                    }
                }

                if (!booked) {
                    System.out.println("Booking failed: no contiguous block of " + groupSize + " seats available.");
                }
                displayTheaterSeats(seats);

            } else if (choice == 2) {
                int id = getValidInt(sc, "Booking ID: ", 1, 10000);
                int cancelled = 0;

                for (int r = 0; r < ROWS; r++) {
                    for (int c = 0; c < COLS; c++) {
                        if (seats[r][c] == id) {
                            seats[r][c] = 0;
                            cancelled++;
                        }
                    }
                }

                if (cancelled > 0) {
                    System.out.println("Cancelled seats: " + cancelled);
                } else {
                    System.out.println("Cancellation rejected: Booking ID " + id + " not found or already cancelled.");
                }
                displayTheaterSeats(seats);

            } else {
                displayTheaterSeats(seats);
            }
        }
    }

    private static void displayTheaterSeats(int[][] seats) {
        printMatrix(seats);
        System.out.println("Available seats: " + countZeros(seats));
    }

    // =========================================================================
    // PROGRAM 10: WEEKLY INVENTORY AND LOST SALES
    // =========================================================================
    public static void runProgram10(Scanner sc) {
        System.out.println("\n--- Program 10: Weekly Inventory and Lost Sales ---");
        final int PRODUCTS = 3;
        final int DAYS = 7;

        int[] openingStock = {10, 15, 20};
        int[] stock = {10, 15, 20};
        int[] reorder = {5, 5, 5};
        int[] price = {100, 50, 25};

        int[][] received = new int[PRODUCTS][DAYS];
        int[][] demand = new int[PRODUCTS][DAYS];
        int[][] sold = new int[PRODUCTS][DAYS];
        int[][] lost = new int[PRODUCTS][DAYS];
        int[][] closing = new int[PRODUCTS][DAYS];

        for (int d = 0; d < DAYS; d++) {
            for (int p = 0; p < PRODUCTS; p++) {
                System.out.println("Day " + (d + 1) + " product " + (p + 1));
                received[p][d] = getValidInt(sc, "Delivery: ", 0, 1000);
                demand[p][d] = getValidInt(sc, "Demand: ", 0, 1000);

                int available = stock[p] + received[p][d];
                int actualSold = Math.min(demand[p][d], available);

                sold[p][d] = actualSold;
                lost[p][d] = demand[p][d] - actualSold;
                closing[p][d] = available - actualSold;
                stock[p] = closing[p][d];

                System.out.println("Sold=" + sold[p][d] + " Lost=" + lost[p][d] + " Closing=" + closing[p][d]);
            }
        }

        for (int p = 0; p < PRODUCTS; p++) {
            int totalRec = 0;
            int totalSold = 0;
            int totalLost = 0;

            for (int d = 0; d < DAYS; d++) {
                totalRec += received[p][d];
                totalSold += sold[p][d];
                totalLost += lost[p][d];
            }

            int revenue = totalSold * price[p];
            boolean balanced = (openingStock[p] + totalRec - totalSold == stock[p])
                    && (stock[p] == closing[p][DAYS - 1]);

            System.out.println("Product " + (p + 1) + " sold=" + totalSold + " lost=" + totalLost
                    + " revenue PHP " + revenue + " final=" + stock[p] + " balanced=" + balanced);
            if (stock[p] <= reorder[p]) {
                System.out.println("LOW STOCK product " + (p + 1));
            }
        }
    }
}