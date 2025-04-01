import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Date implements Comparable<Date> {
    int day;
    int month;
    int year;

    Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date entered!");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        int daysinMonth[] = {0, 31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return day <= daysinMonth[month];
    }

    boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    void updateDate(int d, int m, int y) {
        if (isValidDate(d, m, y)) {
            this.day = d;
            this.month = m;
            this.year = y;
        } else {
            System.out.println("Invalid date");
        }
    }

    String weekday() {
        int d = this.day;
        int m = this.month;
        int y = this.year;

        if (m < 3) {
            m += 12;
            y--;
        }
        int k = y % 100;
        int j = y / 100;
        int h = (d + (13 * (m + 1)) / 5 + k + k/4 + j/4 + 5*j) % 7;
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return days[h];
    }

    int calculateDiff(Date otherDate) {
        int totalDays1 = countDays(this);
        int totalDays2 = countDays(otherDate);
        return Math.abs(totalDays1 - totalDays2);
    }

    int countDays(Date date) {
        int days = date.day;

        for (int i = 1; i < date.month; i++) {
            days += daysInMonth(i, date.year);
        }

        for (int y = 1; y < date.year; y++) {
            if (isLeapYear(y)) {
                days += 366;
            } else {
                days += 365;
            }
        }

        return days;
    }

    int daysInMonth(int month, int year) {
        int[] daysinMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysinMonth[month];
    }

    void printDate() {
        String[] month = {"", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        System.out.println(month[this.month] + " " + this.day + ", " + this.year);
    }

    public int compareTo(Date other) {
        if (this.year != other.year) {
            return this.year - other.year;
        }
        if (this.month != other.month) {
            return this.month - other.month;
        }
        return this.day - other.day;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Date> dates = new ArrayList<>();

        System.out.println("Welcome to Date Program!");
        System.out.print("Enter number of dates: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter day, month, year (separated by spaces): ");
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();

            try {
                dates.add(new Date(day, month, year));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                i--; // retry this input
            }
        }

        System.out.println("\nAll entered dates:");
        for (Date d : dates) {
            d.printDate();
            System.out.println("Day of week: " + d.weekday());
        }

        Collections.sort(dates);
        System.out.println("\nSorted dates:");
        for (Date d : dates) {
            d.printDate();
        }

        if (dates.size() > 1) {
            System.out.println("\nDifferences between dates:");
            for (int i = 0; i < dates.size(); i++) {
                for (int j = i + 1; j < dates.size(); j++) {
                    Date d1 = dates.get(i);
                    Date d2 = dates.get(j);
                    System.out.println(d1.day + "/" + d1.month + "/" + d1.year +
                            " and " + d2.day + "/" + d2.month + "/" + d2.year +
                            ": " + d1.calculateDiff(d2) + " days difference");
                }
            }
        }

        scanner.close();
    }
}
