import java.util.*;

class FirstApp {

    private Scanner in = new Scanner(System.in);

    //1. Приветствовать любого пользователя при вводе его имени через командную строку.
    private void greetByName() {
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        System.out.println("Hello " + name + "!");
    }


    //2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
    private void showArgumentsInReverse(String[] args) {
        for (int i = args.length - 1 ; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }


    //3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.
    private void printNumbersWithAndWithoutNewLine() {
        int[] randomNumbers = new int[5];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = ((int)(Math.random() * 100));
        }
        System.out.println("Output with the transition to a new line:");
        for (int randomNumber : randomNumbers) {
            System.out.println(randomNumber);
        }
        System.out.println("Output without moving to a new line:");
        for (int randomNumber : randomNumbers) {
            System.out.print(randomNumber + " ");
        }
    }


    //4. Ввести пароль из командной строки и сравнить его со строкой-образцом.
    private void checkPassword() {
        System.out.print("\n" + "Enter password: ");
        System.out.println(in.nextLine().equals("12345678") ? "Password is correct" : "Wrong password");
    }


    //5. Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) и вывести результат на консоль.
    private void sumAndMultiplyArguments(String[] args) {
        int sumOfNumbers = 0;
        int productOfNumbers = 1;
        for (String argument : args) {
            try {
                int number = Integer.parseInt(argument);
                sumOfNumbers += number;
                productOfNumbers *= number;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer");
                System.exit(1);
            }
        }
        System.out.println("Sum of command line numbers = " + sumOfNumbers);
        System.out.println("The product of command line numbers = " + productOfNumbers);
    }


    //6. Вывести фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания.
    private void printDeveloperLastNameAndDate() {
        System.out.println("Developer: Ivan Karotky");
        System.out.println("Date and time of receipt of the task: Sat Feb 02 18:09:00 MSK 2019");
        Date date = new Date();
        System.out.println("The current date: " + date.toString());
    }


    void startFirstApp(String[] args) {

        greetByName();
        showArgumentsInReverse(args);
        printNumbersWithAndWithoutNewLine();
        checkPassword();
        sumAndMultiplyArguments(args);
        printDeveloperLastNameAndDate();
    }
}