# Implementing-a-Date-lass-in-Java-Objective
How I Developed the Program
I created the Date class to work with calendar dates easily. Here's what I implemented:
Date Validation through the isValidDate() method, which checks:
Different number of days in months (including February in leap years)
Correct ranges for months (1-12) and days
Main Functions:
Updating dates (updateDate())
Getting the day of the week (getDayOfWeek())
Comparing dates (compareTo())
Calculating the difference between dates (getDifference())
Code Simplicity:
Used clear names for methods and variables
Avoided complex optimizations for better readability
Added comments for tricky parts (like Zeller's algorithm)
Problems I Faced
1) Date Validation:
At first, I forgot about leap years
Solution: Created the daysInMonth array and isLeapYear() method
2) Day of Week Algorithm:
Zeller's formula gave wrong results initially
Got confused with day numbering
Solution: Tested thoroughly with known dates
3) Date Comparison:
Didn't understand how to implement Comparable at first
Solution: Made step-by-step comparison (year - month - day)
_____
Sample inputs
**5**
**1 1 1111**

**2 2 2222**

**3 3 3333**

**4 4 444**

**5 5 5555**
________
Sample output
![Снимок экрана (111)](https://github.com/user-attachments/assets/d074b690-c0f1-4844-ae6c-94525294499d)
![Снимок экрана (112)](https://github.com/user-attachments/assets/78194ac1-7194-4f2e-b7ea-1b7591028d4f)

_________
Input
**2**

**11 9 2006**
**11 12 2024**
Output
____
![image](https://github.com/user-attachments/assets/d81bb50f-0d1f-46e4-a5db-c5f84160530f)


