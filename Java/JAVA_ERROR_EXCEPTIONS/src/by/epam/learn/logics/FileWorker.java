package by.epam.learn.logics;

import java.io.*;
import java.util.ArrayList;

public class FileWorker {

    public static void write(String fileName, ArrayList<String> text) {
        try {
            File file = new File(fileName);
            try {
                if(!file.exists()) {
                    file.createNewFile();
                }
                try (PrintWriter printWriter = new PrintWriter(file)) {
                    for (String str : text) {
                        printWriter.write(str);
                    }
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }


    static String read(String fileName) throws FileNotFoundException {

        StringBuilder strBuilder = new StringBuilder();
        File file = new File(fileName);
        exists(fileName);
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    strBuilder.append(str);
                    strBuilder.append("\n");
                }
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return strBuilder.toString();
    }


    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }
}