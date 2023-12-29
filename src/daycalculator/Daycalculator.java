package daycalculator;

import java.util.Scanner;

public class Daycalculator {

    public static int month;
    public static int year;
    public static int day;
    public static int sumDay = 0;
    public static int specificDay;
    static Scanner input = new Scanner(System.in);
    static String specificDayString;

    public static void input() {
        System.out.println("Enter the year(0-current year):");
        year = input.nextInt();
        if (year < 0) {
            System.out.println("Give a valid input.Year should be between 0-current year.");
            System.exit(0);
        }
        System.out.println("Enter the month(1-12):");
        month = input.nextInt();
        if (month > 12 || month < 1) {
            System.out.println("Give a valid input.Day should be between 1-12.");
            System.exit(0);
        }
        System.out.println("Enter the day(1-31):");
        day = input.nextInt();
        if (day < 1 || day > 31) {
            System.out.println("Give a valid input.Day should be between 1-31.");
            System.exit(0);
        }
        calculator();
    }

    public static void calculator() {

        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                sumDay += 31;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                sumDay += 30;
            } else {
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    sumDay += 29;

                } else {
                    sumDay += 28;
                }
            }
        }

        sumDay = sumDay + day;
        specificDay = ((((year - 1900) * 365) + (year - 1904) / 4 + sumDay) + 1) % 7;
        switch (specificDay) {
            case 0:
                specificDayString = " Sunday ";
                break;
            case 1:
                specificDayString = " Monday ";
                break;
            case 2:
                specificDayString = " Tuesday ";
                break;
            case 3:
                specificDayString = " Wednesday ";
                break;
            case 4:
                specificDayString = " Thursday ";
                break;
            case 5:
                specificDayString = " Friday ";
                break;
            case 6:
                specificDayString = " Saturday ";
                break;

        }
        System.out.println(day + "/" + month + "/" + year + specificDayString + sumDay + ". day.");
    }

    public static void main(String[] args) {
        input();
    }

}
