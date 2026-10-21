package com.mycompany.week8_javaprogramspractice;

import java.util.Scanner;
import java.util.HashMap;

public class Week8_javaprogramspractice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== JAVA PROGRAMS MENU =====");
            System.out.println("1. Display Odd Numbers 1‑100");
            System.out.println("2. Sum of Odd Numbers 1‑100");
            System.out.println("3. Total Count of Odd Numbers 1‑100");
            System.out.println("4. Sum of First N Numbers (n=10)");
            System.out.println("5. Sum of Digits of a Number");
            System.out.println("6. Calculate Electricity Bill");
            System.out.println("7. Check Armstrong Number (153)");
            System.out.println("8. Print Armstrong Numbers 1‑1000");
            System.out.println("9. Convert Number to Words (simplified)");
            System.out.println("10. Check Palindrome Number");
            System.out.println("11. Print Palindrome Numbers Up To Limit (50)");
            System.out.println("12. Print Prime Numbers Up To 100 + Sum & Avg");
            System.out.println("13. Pattern 1: * (4 rows)");
            System.out.println("14. Pattern 2: Pyramid Stars");
            System.out.println("15. Different Star Pattern (enter n)");
            System.out.println("16. Floyd’s Triangle");
            System.out.println("17. Number Sequence Pattern");
            System.out.println("18. Number Pyramid 121 Style");
            System.out.println("19. Number Pyramid Sequential");
            System.out.println("20. Simple Number Pyramid");
            System.out.println("21. Arrow Number Pyramid");
            System.out.println("22. Reverse Number Pyramid");
            System.out.println("23. Descending Star Pattern");
            System.out.println("24. Star Pattern 3");
            System.out.println("25. Diamond Star Pattern");
            System.out.println("26. Largest Number in Array");
            System.out.println("27. Second Largest in Array");
            System.out.println("28. Largest & Smallest in Array");
            System.out.println("29. Largest & Second Largest in Array");
            System.out.println("30. Index of Largest Number");
            System.out.println("31. Index of Smallest Number");
            System.out.println("32. Remove Duplicates from Array");
            System.out.println("33. Odd & Even Numbers from Array");
            System.out.println("34. Matrix Addition");
            System.out.println("35. Check Null Matrix");
            System.out.println("36. Check Diagonal Matrix");
            System.out.println("37. Linear Search");
            System.out.println("38. Binary Search");
            System.out.println("39. Find HCF & LCM");
            System.out.println("40. Volume of Cube");
            System.out.println("41. Reverse a Number");
            System.out.println("42. Integer to Roman");
            System.out.println("43. Count Words in String");
            System.out.println("44. Count Duplicate Words");
            System.out.println("45. Remove Duplicate Words");
            System.out.println("46. Count Each Word & Total Words");
            System.out.println("47. Reverse String & Check Palindrome");
            System.out.println("48. Delete Vowels in String");
            System.out.println("49. Capitalize First Letter of Each Word");
            System.out.println("50. Split Comma Separated String");
            System.out.println("51. ASCII Value to Character");
            System.out.println("52. Replace Vowels with Star");
            System.out.println("53. Character Position Count");
            System.out.println("54. Reverse String by Words");
            System.out.println("55. Reverse Entire Text");
            System.out.println("56. Difference Between Min & Max in Array");
            System.out.println("57. Count Occurrences of Each Character");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> displayOdd1to100();
                case 2 -> sumOdd1to100();
                case 3 -> countOdd1to100();
                case 4 -> sumFirstN(10);
                case 5 -> sumDigits(251025);
                case 6 -> calculateElectricBill(123);
                case 7 -> checkArmstrong(153);
                case 8 -> printArmstrong1to1000();
                case 9 -> numberToWords(28);
                case 10 -> checkPalindromeNum(121);
                case 11 -> printPalindromeUpTo(50);
                case 12 -> primesUpTo100();
                case 13 -> patternStar1(4);
                case 14 -> patternStar2(5);
                case 15 -> patternDiff1(sc);
                case 16 -> floydTriangle(sc);
                case 17 -> numberSequence();
                case 18 -> numberPyramid121(sc);
                case 19 -> numberPyramidSeq();
                case 20 -> simpleNumPyramid(sc);
                case 21 -> arrowNumPyramid(sc);
                case 22 -> revNumPyramid(sc);
                case 23 -> starDescending(sc);
                case 24 -> starPattern3();
                case 25 -> diamondStar();
                case 26 -> largestInArray();
                case 27 -> secondLargestArray();
                case 28 -> largestSmallestArray();
                case 29 -> largestSecondLargestArray();
                case 30 -> indexLargestArray();
                case 31 -> indexSmallestArray();
                case 32 -> removeDuplicateArray();
                case 33 -> oddEvenArray();
                case 34 -> matrixAddition();
                case 35 -> checkNullMatrix();
                case 36 -> checkDiagonalMatrix();
                case 37 -> linearSearch(sc);
                case 38 -> binarySearch(sc);
                case 39 -> hcfLcm(6,10);
                case 40 -> cubeVolume(5);
                case 41 -> reverseNumber(1234);
                case 42 -> intToRoman(sc);
                case 43 -> countWordsString("welcome to candid java tutorial");
                case 44 -> countDuplicateWords("Welcome to Java Session Session Session");
                case 45 -> removeDuplicateWords("Welcome to Java Session Java Session Session Java");
                case 46 -> countEachWord("apple banana apple fruit fruit apple hello hi hi hello hi");
                case 47 -> stringPalindrome("AMMA");
                case 48 -> removeVowels("Welcome to Candid Java Programming");
                case 49 -> capitalizeWords("welcome to candid java program");
                case 50 -> splitComma("Welcome,to,Java,Session,Session,Session");
                case 51 -> asciiToChar();
                case 52 -> vowelsToStar("Welcome to Candid Java Programming");
                case 53 -> charPositionCount("CANDIDJAVA");
                case 54 -> reverseByWord("Welcome to Java Session");
                case 55 -> reverseText("Welcome to Java Programming and Dotnet Programming");
                case 56 -> minMaxDiffArray(sc);
                case 57 -> countCharOccurrence(sc);
                case 0 -> { System.out.println("Exiting program..."); sc.close(); return; }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // 1. Display odd numbers 1‑100
    static void displayOdd1to100() {
        System.out.print("The Odd Numbers are: ");
        for(int i=1; i<=100; i++){
            if(i%2!=0) System.out.print(i+" ");
        }
        System.out.println();
    }

    //2. Sum odd numbers 1‑100
    static void sumOdd1to100() {
        int sum=0;
        for(int i=1; i<=100; i++) if(i%2!=0) sum+=i;
        System.out.println("The Sum Of Odd Numbers from 1‑100 is: "+sum);
    }

    //3. Total odd numbers 1‑100
    static void countOdd1to100() {
        int count=0;
        for(int i=1; i<=100; i++) if(i%2!=0) count++;
        System.out.println("The Count Of Odd Numbers from1‑100 is: "+count);
    }

    //4. Sum first n numbers
    static void sumFirstN(int n) {
        int sum=0;
        for(int i=1; i<=n; i++) sum+=i;
        System.out.println("The Sum Of "+n+" Numbers are: "+sum);
    }

    //5. Sum digits
    static void sumDigits(int num) {
        int temp=num, rem=0, sum=0;
        while(num>0){ rem=num%10; sum+=rem; num/=10; }
        System.out.println("Sum of Digits of "+temp+" is "+sum);
    }

    //6. Electricity bill (fixed original logic)
    static void calculateElectricBill(int units) {
        int bill=0;
        if(units<=100) bill=units*5;
        else if(units<=200) bill=units*6;
        else bill=units*8;
        System.out.println("CHENNAI ELECTRICITY LTD, CHENNAI");
        System.out.println("Units Consumed: "+units);
        System.out.println("Total Bill : "+bill);
    }

    //7. Check Armstrong (3‑digit)
    static void checkArmstrong(int n) {
        int arg=n, sum=0, r;
        while(n>0){ r=n%10; sum+=r*r*r; n/=10; }
        if(arg==sum) System.out.println(arg+" is armstrong number");
        else System.out.println(arg+" is not armstrong number");
    }

    //8. Armstrong 1‑1000
    static void printArmstrong1to1000() {
        System.out.print("Armstrong numbers from 1 to 1000: ");
        for(int i=1; i<=1000; i++){
            int num=i, sum=0;
            while(num>0){ int rem=num%10; sum+=rem*rem*rem; num/=10; }
            if(sum==i) System.out.print(i+" ");
        }
        System.out.println();
    }

    //9. Number to Words (simplified 0‑99 only – original incomplete)
    static void pw(int n, String ch) {
        String one[] = {"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String ten[]={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if(n>19){ System.out.print(ten[n/10]+" "+one[n%10]); }
        else System.out.print(one[n]);
        if(n>0) System.out.print(" "+ch+" ");
    }
    static void numberToWords(int n) {
        if(n<=0) System.out.println("Enter numbers greater than 0");
        else { System.out.print(n+" = "); pw(n,""); System.out.println(); }
    }

    //10. Palindrome number
    static void checkPalindromeNum(int n) {
        int pal=n, r, rev=0;
        while(n>0){ r=n%10; rev=rev*10+r; n/=10; }
        if(rev==pal) System.out.println(pal+" is palindrome");
        else System.out.println(pal+" is not palindrome");
    }

    //11. Palindrome up to N
    static void printPalindromeUpTo(int limit) {
        System.out.print("Palindrome numbers from1 to "+limit+": ");
        for(int i=1; i<=limit; i++){
            int n=i, rev=0;
            while(n>0){ int b=n%10; rev=rev*10+b; n/=10; }
            if(rev==i) System.out.print(i+" ");
        }
        System.out.println();
    }

    //12. Primes up to100 sum & avg
    static void primesUpTo100() {
        System.out.print("Prime numbers from1 to100 are: ");
        int sum=0, count=0;
        for(int i=1; i<=100; i++){
            int counter=0;
            for(int num=i; num>=1; num--) if(i%num==0) counter++;
            if(counter==2){ System.out.print(i+" "); sum+=i; count++; }
        }
        System.out.println("\nSum: "+sum+" | Count: "+count+" | Avg: "+(double)sum/count);
    }

    //13. Pattern 1: *
    static void patternStar1(int n) {
        for(int i=0;i<n;i++){ for(int j=0;j<=i;j++) System.out.print("*"); System.out.println(); }
    }

    //14. Pattern2 pyramid stars
    static void patternStar2(int n) {
        int k=8;
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++) System.out.print(" ");
            k-=2;
            for(int j=0;j<=i;j++) System.out.print("*");
            System.out.println();
        }
    }

    //15. Different pattern1
    static void patternDiff1(Scanner sc) {
        System.out.print("Enter n value: "); int n=sc.nextInt();
        int p=n, q=n;
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++) System.out.print("*");
            for(int k=p*2;k<n*2-1;k++) System.out.print(" ");
            for(int l=i;l!=0;l--){ if(l!=n) System.out.print("*"); }
            p--; System.out.println();
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++) System.out.print("*");
            for(int k=q*2-2;k>1;k--) System.out.print(" ");
            for(int m=i;m!=0;m--){ if(m!=n) System.out.print("*"); }
            q--; System.out.println();
        }
    }

    //16. Floyd triangle
    static void floydTriangle(Scanner sc) {
        System.out.print("Enter number of rows: "); int rows=sc.nextInt();
        System.out.println("Floyd's Triangle Generated"); int count=1;
        for(int i=1;i<=rows;i++){ for(int j=1;j<=i;j++){ System.out.print(count+" "); count++; } System.out.println(); }
    }

    //17. Number sequence
    static void numberSequence() {
        int a=3,b=4,n=8;
        for(int i=1;i<=n;i++){ int c=a+b; System.out.println(a+" "+b+" "+c); a=c; b++; }
    }

    //18. Pyramid 121
    static void numberPyramid121(Scanner sc) {
        System.out.print("Enter N value: "); int n=sc.nextInt(); int s=1;
        for(int i=1;i<=n;i++){
            while(s<=i){ System.out.print(s); s++; } s--;
            while(s>1){ System.out.print(--s); }
            System.out.println();
        }
    }

    //19. Number pyramid sequential
    static void numberPyramidSeq() {
        int n=1; for(int i=0;i<5;i++){ for(int j=0;j<=i;j++){ System.out.print(n+" "); n++; } System.out.println(); }
    }

    //20. Simple num pyramid
    static void simpleNumPyramid(Scanner sc) {
        System.out.print("Enter Row value n: "); int n=sc.nextInt();
        for(int i=1;i<=n;i++){ for(int j=1;j<=i;j++) System.out.print(j+" "); System.out.println(); }
    }

    //21. Arrow num pyramid
    static void arrowNumPyramid(Scanner sc) {
        System.out.print("Enter value: "); int n=sc.nextInt();
        for(int i=1;i<=n;i++){ for(int j=1;j<=i;j++) System.out.print(j+" "); System.out.println(); }
        for(int i=n-1;i>=1;i--){ for(int j=1;j<=i;j++) System.out.print(j+" "); System.out.println(); }
    }

    //22. Reverse num pyramid
    static void revNumPyramid(Scanner sc) {
        System.out.print("Enter n value: "); int n=sc.nextInt(); int a=n;
        for(int i=1;i<=n;i++){
            for(int j=a;j>1;j--) System.out.print(" ");
            for(int k=i;k!=0;k--) System.out.print(k);
            a--;
            for(int l=2;l<=i;l++) System.out.print(l);
            System.out.println();
        }
    }

    //23. Descending star
    static void starDescending(Scanner sc) {
        System.out.print("How many rows you want: "); int t=sc.nextInt();
        for(int j=0;j<t;j++){ for(int i=t-1;i>=j;i--) System.out.print("*"); System.out.println(); }
    }

    //24. Star pattern3
    static void starPattern3() {
        int i,j,k,n=3;
        for(i=0;i<n;i++){
            for(j=0;j<=i;j++) System.out.print("*");
            for(j=(n-i);j>=2;j--) System.out.print(" ");
            for(k=i;k>=0;k--) System.out.print("*");
            System.out.println();
        }
    }

    //25. Diamond star
    static void diamondStar() {
        int i,j,k;
        for(i=1;i<=5;i++){ for(j=i;j<5;j++) System.out.print(" "); for(k=1;k<(i*2);k++) System.out.print("*"); System.out.println(); }
        for(i=4;i>=1;i--){ for(j=5;j>i;j--) System.out.print(" "); for(k=1;k<(i*2);k++) System.out.print("*"); System.out.println(); }
    }

    //26. Largest array
    static void largestInArray() {
        int[] a={20,30,50,4,71,100}; int max=a[0];
        for(int i=1;i<a.length;i++) if(a[i]>max) max=a[i];
        System.out.print("Array Elements: "); for(int x:a) System.out.print(x+" ");
        System.out.println("\nLargest Number: "+max);
    }

    //27. Second largest array
    static void secondLargestArray() {
        int arr[]={14,46,47,86,92,52,48,36,66,85};
        int largest=arr[0], secondLargest=arr[0];
        System.out.print("Given array: "); for(int x:arr) System.out.print(x+"\t");
        for(int i=0;i<arr.length;i++){ if(arr[i]>largest){ secondLargest=largest; largest=arr[i]; } else if(arr[i]>secondLargest) secondLargest=arr[i]; }
        System.out.println("\nSecond largest number is: "+secondLargest);
    }

    //28. Largest & smallest array
    static void largestSmallestArray() {
        int a[]={23,34,13,64,72,90,10,15,9,27}; int min=a[0],max=a[0];
        for(int i=1;i<a.length;i++){ if(a[i]>max) max=a[i]; if(a[i]<min) min=a[i]; }
        System.out.println("Largest Number: "+max+" | Smallest Number: "+min);
    }

    //29. Largest & second largest v2
    static void largestSecondLargestArray() {
        int nums[]={5,34,78,2,45,1,99,23}; int maxOne=0,maxTwo=0;
        for(int i=0;i<nums.length;i++){ if(maxOne<nums[i]){ maxTwo=maxOne; maxOne=nums[i]; } else if(maxTwo<nums[i]) maxTwo=nums[i]; }
        System.out.println("Largest Number: "+maxOne+" | Second Largest: "+maxTwo);
    }

    //30. Index largest
    static void indexLargestArray() {
        int a[]={12,44,23,56,23,78,13}; int max=a[0],index=0;
        for(int i=0;i<a.length;i++){ if(max<a[i]){ max=a[i]; index=i; } }
        System.out.println("Index position of Maximum value: "+index);
    }

    //31. Index smallest
    static void indexSmallestArray() {
        int a[]={12,44,23,56,9,23,78,13}; int min=a[0],index=0;
        for(int i=0;i<a.length;i++){ if(min>a[i]){ min=a[i]; index=i; } }
        System.out.println("Index position of Smallest value: "+index);
    }

    //32. Remove duplicates array (needs sorted input!)
    static int[] removeDuplicates(int[] input) {
        if(input.length<2) return input;
        int j=0; for(int i=1;i<input.length;i++){ if(input[i]!=input[j]) input[++j]=input[i]; }
        int[] output=new int[j+1]; for(int k=0;k<output.length;k++) output[k]=input[k]; return output;
    }
    static void removeDuplicateArray() {
        int[] input1={2,3,6,6,8,9,10,10,10,12,12};
        int[] output=removeDuplicates(input1);
        System.out.print("Input Elements: "); for(int x:input1) System.out.print(x+" ");
        System.out.print("\nOutput Elements: "); for(int x:output) System.out.print(x+" "); System.out.println();
    }

    //33. Odd even array
    static void oddEvenArray() {
        int[] a={33,2,4,71,88,92,9,1};
        //sort
        for(int i=0;i<a.length;i++) for(int j=i+1;j<a.length;j++) if(a[i]>a[j]){ int s=a[i]; a[i]=a[j]; a[j]=s; }
        System.out.print("Input numbers: "); for(int x:a) System.out.print(x+" ");
        System.out.print("\nOdd numbers: "); for(int x:a) if(x%2!=0) System.out.print(x+" ");
        System.out.print("\nEven numbers: "); for(int x:a) if(x%2==0) System.out.print(x+" "); System.out.println();
    }

    //34. Matrix addition
    static void matrixAddition() {
        int[][] a={{1,2,3},{4,5,6},{7,8,9}}; int[][] b={{10,11,12},{13,14,15},{16,17,18}}; int[][] c=new int[3][3];
        if(a.length==b.length && a[0].length==b[0].length){
            for(int i=0;i<a.length;i++) for(int j=0;j<a[i].length;j++) c[i][j]=a[i][j]+b[i][j];
        }else{ System.out.println("A and B Matrix are not SAME"); return; }
        System.out.println("Matrix A:"); for(int i=0;i<a.length;i++){ for(int j=0;j<a[i].length;j++) System.out.print(a[i][j]+" "); System.out.println(); }
        System.out.println("Matrix B:"); for(int i=0;i<b.length;i++){ for(int j=0;j<b[i].length;j++) System.out.print(b[i][j]+" "); System.out.println(); }
        System.out.println("Addition Matrix:"); for(int i=0;i<c.length;i++){ for(int j=0;j<c[i].length;j++) System.out.print(c[i][j]+" "); System.out.println(); }
    }

    //35. Null matrix
    static void checkNullMatrix() {
        int[][] a={{0,0,0},{0,0,1},{0,0,0}}; boolean isNull=true;
        abc:for(int i=0;i<a.length;i++) for(int j=0;j<a[i].length;j++) if(a[i][j]!=0){ isNull=false; break abc; }
        System.out.println("Given Matrix:"); for(int i=0;i<a.length;i++){ for(int j=0;j<a[i].length;j++) System.out.print(a[i][j]+" "); System.out.println(); }
        if(isNull) System.out.println("The Given Matrix is a Null Matrix"); else System.out.println("The Given Matrix is not a Null Matrix");
    }

    //36. Diagonal matrix
    static void checkDiagonalMatrix() {
        int[][] a={{1,0,0},{0,3,0},{0,0,3}}; boolean isDiag=true;
        abc:for(int i=0;i<a.length;i++) for(int j=0;j<a[i].length;j++){ if(i==j){ if(a[i][j]==0) isDiag=false; } else if(a[i][j]!=0) isDiag=false; }
        System.out.println("Given Matrix:"); for(int i=0;i<a.length;i++){ for(int j=0;j<a[i].length;j++) System.out.print(a[i][j]+" "); System.out.println(); }
        if(isDiag) System.out.println("The Given Matrix is a Diagonal Matrix"); else System.out.println("The Given Matrix is not a Diagonal Matrix");
    }

    //37. Linear search
    static void linearSearch(Scanner sc) {
        System.out.print("Enter number of elements: "); int num=sc.nextInt(); int array[]=new int[num];
        System.out.print("Enter "+num+" integers: "); for(int i=0;i<num;i++) array[i]=sc.nextInt();
        System.out.print("Enter search value: "); int searchval=sc.nextInt();
        int i; for(i=0;i<num;i++) if(array[i]==searchval){ System.out.println(searchval+" is present at location "+(i+1)); break; }
        if(i==num) System.out.println(searchval+" is not exist in array.");
    }

    //38. Binary search (requires sorted array!)
    static void binarySearch(Scanner sc) {
        System.out.print("Enter number of elements: "); int num=sc.nextInt(); int array[]=new int[num];
        System.out.print("Enter "+num+" sorted integers: "); for(int counter=0;counter<num;counter++) array[counter]=sc.nextInt();
        System.out.print("Enter search value: "); int item=sc.nextInt();
        int first=0,last=num-1,middle;
        while(first<=last){
            middle=(first+last)/2;
            if(array[middle]<item) first=middle+1;
            else if(array[middle]==item){ System.out.println(item+" found at location "+(middle+1)+"."); return; }
            else last=middle-1;
        }
        System.out.println(item+" is not found.\n");
    }

    //39. HCF LCM
    static void hcfLcm(int x,int y) {
        int a=x,b=y,t; while(b!=0){ t=b; b=a%b; a=t; } int hcf=a; int lcm=(x*y)/hcf;
        System.out.println("HCF of "+x+" and "+y+" = "+hcf+" | LCM = "+lcm);
    }

    //40. Cube volume
    static void cubeVolume(int side) { float volume=side*side*side; System.out.println("Volume of Cube: "+volume); }

    //41. Reverse number
    static void reverseNumber(int num) { int rev=0, no=num; while(num>0){ int rem=num%10; rev=rem+(rev*10); num/=10; } System.out.println("Number = "+no+" | Reverse = "+rev); }

    //42. Int to Roman
    static final int[] bases={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static HashMap<Integer,String> map=new HashMap<>();
    static void setup(){ map.put(1,"I");map.put(4,"IV");map.put(5,"V");map.put(9,"IX");map.put(10,"X");map.put(40,"XL");map.put(50,"L");map.put(90,"XC");map.put(100,"C");map.put(400,"CD");map.put(500,"D");map.put(900,"CM");map.put(1000,"M"); }
    static String intToRoman(int num){ setup(); String res=""; for(int i:bases){ while(num>=i){ res+=map.get(i); num-=i; } } return res; }
    static void intToRoman(Scanner sc){ System.out.print("Enter number: "); int no=sc.nextInt(); System.out.println(no+" ---> "+intToRoman(no)); }

    //43. Count words
    static void countWordsString(String s) {
        if(s.trim().isEmpty()){ System.out.println("0 words"); return; }
        int count=1; for(int i=0;i<s.length()-1;i++) if(s.charAt(i)==' ' && s.charAt(i+1)!=' ') count++;
        System.out.println("Number of words in string = "+count);
    }

    //44. Count duplicate words
    static void countDuplicateWords(String input) {
        String[] words=input.split(" ");
        for(int i=0;i<words.length;i++){ int wrc=1; for(int j=i+1;j<words.length;j++) if(words[i].equals(words[j])){ wrc++; words[j]="0"; } if(!words[i].equals("0")) System.out.println(words[i]+" -- "+wrc); }
    }

    //45. Remove duplicate words
    static void removeDuplicateWords(String input) {
        String[] words=input.split(" ");
        for(int i=0;i<words.length;i++) if(words[i]!=null) for(int j=i+1;j<words.length;j++) if(words[i].equals(words[j])) words[j]=null;
        for(int k=0;k<words.length;k++) if(words[k]!=null) System.out.println(words[k]);
    }

    //46. Count each word
    static void countEachWord(String st) {
        String[] words=st.split("\\s"); int[] fr=new int[words.length]; for(int i=0;i<fr.length;i++) fr[i]=0;
        for(int i=0;i<words.length;i++) for(int j=0;j<words.length;j++) if(words[i].equals(words[j])) fr[i]++;
        for(int i=0;i<words.length;i++) for(int j=0;j<words.length;j++) if(words[i].equals(words[j]) && i!=j) words[i]="";
        int total=0; System.out.println("Words and counts:"); for(int i=0;i<words.length;i++) if(!words[i].equals("")){ System.out.println(words[i]+" = "+fr[i]); total+=fr[i]; }
        System.out.println("Total words counted: "+total);
    }

    //47. String palindrome
    static void stringPalindrome(String inpstr) {
        char[] inpArray=inpstr.toCharArray(); char[] revArray=new char[inpArray.length]; int j=0;
        for(int i=inpArray.length-1;i>=0;i--) revArray[j++]=inpArray[i];
        String revstr=String.valueOf(revArray); if(inpstr.equals(revstr)) System.out.println(inpstr+" is Palindrome"); else System.out.println(inpstr+" is not Palindrome");
    }

    //48. Remove vowels
    static void removeVowels(String s){ System.out.println("Input String: "+s); System.out.println(s.replaceAll("[AaEeIiOoUu]","")); }

    //49. Capitalize words
    static void capitalizeWords(String str){ StringBuilder sb=new StringBuilder(); String[] words=str.split(" "); for(String w:words) if(!w.isEmpty()) sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" "); System.out.println(sb); }

    //50. Split comma
    static void splitComma(String input){ String[] words=input.split(","); for(String w:words) System.out.println(w); }

    //51. ASCII to char
    static void asciiToChar(){ char c; for(int i=65;i<=90;i++){ c=(char)i; System.out.println(i+" = "+c); } }

    //52. Vowels to star
    static void vowelsToStar(String s){ System.out.println("Input String: "+s); System.out.println(s.replaceAll("[AaEeIiOoUu]","*")); }

    //53. Char position
    static void charPositionCount(String s){ char[] a=s.toCharArray(); int i=1; for(char output:a) System.out.print(output+" = "+i+" "); System.out.println(); }

    //54. Reverse by word
    static void reverseByWord(String input){ String[] words=input.split(" "); String[] revwords=new String[words.length]; int j=0; for(int i=words.length-1;i>=0;i--) revwords[j++]=words[i]; for(String w:revwords) System.out.print(w+" "); System.out.println(); }

    //55. Reverse text (word order)
    static void reverseText(String string){ String[] words=string.split(" "); System.out.println("Given String: "+string+"\nAfter Reverse:"); for(int i=words.length;i>0;i--) System.out.print(words[i-1]+" "); System.out.println(); }

    //56. Min Max Diff Array
    static int getMax(int[] arr){ int m=arr[0]; for(int i=1;i<arr.length;i++) if(arr[i]>m) m=arr[i]; return m; }
    static int getMin(int[] arr){ int m=arr[0]; for(int i=1;i<arr.length;i++) if(arr[i]<m) m=arr[i]; return m; }
    static void minMaxDiffArray(Scanner sc){ System.out.print("Enter number of elements: "); int n=sc.nextInt(); int arr[]=new int[n]; for(int i=0;i<arr.length;i++){ System.out.print("Enter ["+(i+1)+"] element: "); arr[i]=sc.nextInt(); } int max=getMax(arr),min=getMin(arr); System.out.println("Max: "+max+" Min: "+min+" Difference: "+(max-min)); }

    //57. Count char occurrence
    static final int MAX_CHAR=256;
    static void getOccuringChar(String str){ int count[]=new int[MAX_CHAR]; int len=str.length(); for(int i=0;i<len;i++) count[str.charAt(i)]++; char ch[]=new char[str.length()]; for(int i=0;i<len;i++){ ch[i]=str.charAt(i); int find=0; for(int j=0;j<=i;j++) if(str.charAt(i)==ch[j]) find++; if(find==1) System.out.println("Number of Occurrence of '"+str.charAt(i)+"' is: "+count[str.charAt(i)]); } }
    static void countCharOccurrence(Scanner sc){ System.out.print("Enter string: "); sc.nextLine(); String str=sc.nextLine(); getOccuringChar(str); }
}
