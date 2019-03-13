import java.util.*;

class Operators {

    private Scanner in = new Scanner(System.in);

    private int enterNumbers() {
        while (!in.hasNextInt()) {
            System.out.println("This is not a number!");
            in.next();
        }
        return in.nextInt();
    }


    //1. Определить принадлежность некоторого значения k интервалам (n, m], [n, m), (n, m), [n, m].
    private void determineIntervalHasNumber() {
        System.out.print("Enter the number (k): ");
        int number = enterNumbers();
        System.out.print("Enter the lower limit of the interval (n): ");
        int lower = enterNumbers();
        System.out.print("Enter the upper limit of the interval (m): ");
        int upper = enterNumbers();
        if (lower > upper) {
            lower += upper;
            upper -= lower;
            upper = -upper;
            lower -= upper;
        }
        if ((number > lower) && (number < upper)) {
            System.out.println(number + " is included in the intervals " + "(" + lower + ", " + upper + "], "
                    + "[" + lower + ", " + upper + "), " + "(" + lower + ", " + upper + "] and "
                    + "[" + lower + ", " + upper + "]");
        } else if ((number == lower) && (number < upper)) {
            System.out.println(number + " is included in the interval " + "[" + lower + ", " + upper + ") and "
                    + "[" + lower + ", " + upper + "]");
        } else if ((number > lower) && (number == upper)) {
            System.out.println(number + " included in intervals " + "(" + lower + ", " + upper + "] and "
                    + "[" + lower + ", " + upper + "]");
        } else if ((number == lower) && (number == upper)) {
            System.out.println("One number is not an interval");
        } else {
            System.out.println("Number " + number + " is out of range");
        }
    }


    //2. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
    private void displayTheNameOfTheMonth() {
        int num;
        do{
            System.out.print("Enter a number from 1 to 12: ");
            num = enterNumbers();
        } while ((num < 1) || (num > 12));
        String[] monthArray = {"January", "February", "February", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        System.out.println(monthArray[num - 1]);

    }


    void startOperators() {

        determineIntervalHasNumber();
        displayTheNameOfTheMonth();
    }
}