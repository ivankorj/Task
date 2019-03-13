package by.epam.learn.logics;

import java.util.ArrayList;
import java.util.Scanner;

public class Content {

    private static Scanner in = new Scanner(System.in);

    public static ArrayList<String> enterItems(){
        ArrayList<String> fileContents = new ArrayList<>();

        System.out.print("Enter count of array: ");
        String input;
        while ((!(input = in.nextLine()).matches("\\p{Digit}+")) || (Integer.parseInt(input) == 0)) {
            System.out.print("Please enter a positive Integer: ");
        }
        for (int i = 0; i < Integer.parseInt(input); i++) {
            System.out.print("Enter text or numbers: ");
            if (Integer.parseInt(input) != (i + 1)) {
                fileContents.add(in.nextLine() + ";");
            } else {
                fileContents.add(in.nextLine());
            }
        }
        return fileContents;
    }
}
