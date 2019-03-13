package by.epam.learn.main;

import by.epam.learn.logics.FileWorker;
import by.epam.learn.logics.Content;
import by.epam.learn.logics.Maths;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "C://data//Java//JAVA_ERROR_EXCEPTIONS//file.txt";

        FileWorker.write(fileName, Content.enterItems());

        String[] array = Maths.getArrayFromFile();

        Maths.sum(array);
        Maths.divide(array);
        Maths.findSquareRoot(array);
    }
}