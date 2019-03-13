package by.epam.learn.logics;

import java.io.FileNotFoundException;

public class Maths {

    public static String[] getArrayFromFile() throws FileNotFoundException {
        String fileName = "C://data//Java//JAVA_ERROR_EXCEPTIONS//file.txt";
        String textFromFile = FileWorker.read(fileName);
        return textFromFile.split(";");
    }


    public static void sum(String[] array) {
        System.out.println("\nSum: ");
        int sum = 0;
        for (String str : array) {
            try {
                System.out.println(sum += Integer.parseInt(str.trim()));
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }
    }


    public static void divide(String[] array) {
        System.out.println("\nDivision: ");
        int denominator;
        for (int i = 0; i < array.length; i++) {
            try {
                denominator = Integer.parseInt(array[i].trim());
                try {
                    System.out.println("Division by denominator №" + i + " = " + 1000 / denominator);
                } catch (ArithmeticException e) {
                    System.err.println(e);
                }
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }
    }


    public static void findSquareRoot(String[] array) {
        System.out.println("\nSquare root: ");
        int number;
        for (int i = 0; i < array.length; i++) {
            try {
                number = Integer.parseInt(array[i].trim());
                try {
                    System.out.println("Square root number №" + i + " = " + Math.sqrt(number));
                } catch (ArithmeticException e) {
                    System.err.println(e);
                }
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }
    }
}
