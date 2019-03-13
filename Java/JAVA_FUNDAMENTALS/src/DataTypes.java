import java.util.*;
import java.lang.*;
import java.util.Arrays;

class DataTypes {

    private Scanner in = new Scanner(System.in);

    private int enterNumbers() {
        System.out.print("Enter the number of numbers(n): ");
        String input;
        while (!(input = in.next()).matches("\\p{Digit}+")) {
            System.out.print("Please enter a positive Integer: ");
        }
        return Integer.parseInt(input);
    }


    private int[] getArray() {
        int[] numbers = new int[enterNumbers()];
        System.out.print("Enter the integers separated by a space and press <Enter>: ");
        for (int i = 0; i < numbers.length; i++) {
            while (!in.hasNextInt()) {
                System.out.println("This is not a number!");
                in.next();
            }
            numbers[i] = in.nextInt();
        }
        return numbers;
    }


    private int[] getCharsOfInteger(int number) {
        int[] elements = new int[(int)Math.ceil(Math.log10(number + 0.5))];
        for (int i = 0; i < elements.length ; i++) {
            elements[elements.length - i - 1] =  number % 10;
            number /= 10;
        }
        return elements;
    }


    private int[] getAbsArray(int[] number) {
        int[] arrayAbsNum = new int[number.length];
        for (int i = 0; i < arrayAbsNum.length; i++) {
            arrayAbsNum[i] = number[i] < 0 ? number[i] * (-1) : number[i];
        }
        return arrayAbsNum;
    }


    private List<Integer> getSortList(int[] number) {
        List<Integer> numbersList = new ArrayList<>();
        for (int num : number) {
            numbersList.add(num);
        }
        numbersList.sort(Comparator.comparingInt(Math::abs));
        return numbersList;
    }


    //1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    private void findShortestAndLongestNumber() {
        int[] numbers = getArray();
        List<Integer> numbersList = getSortList(numbers);
        System.out.println("Longest number: " + numbersList.get(numbersList.size() - 1)
                + ", length: " + String.valueOf(Math.abs(numbersList.get(numbersList.size() - 1))).length());
        System.out.println("Shortest number: " + numbersList.get(0)
                + ", number length: " + String.valueOf(Math.abs(numbersList.get(0))).length());
    }


    //2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
    private void sortAndDisplayNumbersAscendingAndDescendingLength() {
        int[] numbers = getArray();
        List<Integer> numbersList = getSortList(numbers);
        System.out.print("Sort Ascending: ");
        for (int number : numbersList) {
            System.out.print(number + " ");
        }
        System.out.print("\n" + "Sort descending: ");
        for (int i = numbersList.size() - 1 ; i >= 0; i--) {
            System.out.print(numbersList.get(i) + " ");
        }
    }


    //3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.
    private void printNumbersSmallerAndLongerThanAverageLength() {
        int[] numbers = getArray();
        int[] arrayAbsNum = getAbsArray(numbers);
        double[] countCharInNumbers = new double[arrayAbsNum.length];
        for (int i = 0; i < arrayAbsNum.length; i++) {
            countCharInNumbers[i] = Math.ceil(Math.log10(arrayAbsNum[i] + 0.5));
        }
        double sum = 0;
        for (double countCharInNumber : countCharInNumbers) {
            sum += countCharInNumber;
        }
        double average = Math.round((sum / countCharInNumbers.length) * 100.0) / 100.0;
        System.out.print("numbers with length less than (" + average + "): ");
        for (int i = 0; i < countCharInNumbers.length; i++){
            if (countCharInNumbers[i] < average){
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.print("\n" + "numbers with length more than (" + average + "): ");
        for (int i = 0; i < countCharInNumbers.length; i++){
            if (countCharInNumbers[i] > average){
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();
    }


    //4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
    private void findNumberWithMinimumOfDifferentNumbers() {
        int[] numbers = getArray();
        int[] arrayAbsNum = getAbsArray(numbers);
        int[] countArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            int[] numberElements = getCharsOfInteger(arrayAbsNum[i]);
            for (int j = 0; j < numberElements.length; j++) {
                for (int k = j + 1; k < numberElements.length ; k++) {
                    if(numberElements[j] == numberElements[k]) {
                        count++;
                    }
                }
            }
            countArray[i] = count;
        }
        int maxValueOfDifferentDigitsIndex = 0;
        int maxValueOfDifferentDigits = 0;
        for (int i = 0; i < countArray.length; i++) {
            if(countArray[i] > maxValueOfDifferentDigits) {
                maxValueOfDifferentDigitsIndex = i;
                maxValueOfDifferentDigits = countArray[i];
            }
        }
        System.out.println("Number with a minimum of different numbers: " + numbers[maxValueOfDifferentDigitsIndex]);
    }


    //5. Найти количество чисел, содержащих только четные цифры, а среди них — количество чисел с равным числом четных и нечетных цифр.
    private void findNumberOfEvenNumberedNumbers() {
        int[] numbers = getArray();
        int countEqualNum = 0;
        int countOnlyEven = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] < 0)
                numbers[i] *= (-1);
        }
        for (int number : numbers) {
            int countEvenNumbers = 0;
            int countOddNumbers = 0;
            int[] numberElements = getCharsOfInteger(number);
            for (int numberElement : numberElements) {
                if (numberElement % 2 == 0) {
                    countEvenNumbers++;
                } else {
                    countOddNumbers++;
                }
            }
            if ((countEvenNumbers == countOddNumbers) && !(number == 0)) {
                countEqualNum++;
            }
            if (countOddNumbers == 0) {
                countOnlyEven++;
            }
        }
        System.out.println("The number of numbers with an equal number of even and odd numbers: " + countEqualNum);
        System.out.println("Number of numbers containing even numbers only: " + countOnlyEven);
    }


    //6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
    private void findNumbersWithAscendingNumbers() {
        int[] numbers = getArray();
        int[] arrayAbsNum = getAbsArray(numbers);
        int index = 0;
        for(int number : arrayAbsNum) {
            int[] numbersArray = getCharsOfInteger(number);
            int[] sampleArray = Arrays.copyOfRange(numbersArray, 0, numbersArray.length);
            Arrays.sort(sampleArray);
            if (Arrays.equals(sampleArray, numbersArray)) {
                break;
            }
            index++;
        }
        System.out.println("The first number with numbers ascending: " + numbers[index]);
    }


    //7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
    private void findNumbersOnlyFromDifferentNumbers() {
        int[] numbers = getArray();
        int[] arrayAbsNum = getAbsArray(numbers);
        int index = 0;
        boolean find = false;
        for (int number : arrayAbsNum) {
            List<Integer> listNumber = new ArrayList<>();
            for (int num : getCharsOfInteger(number)) {
                listNumber.add(num);
            }
            List<String> strList = new ArrayList<>();
            for (int num : listNumber) {
                strList.add(String.valueOf(num));
            }
            Set<String> listWithoutDuplicates = new HashSet<>();
            for (String num : strList) {
                listWithoutDuplicates.add(num);
            }
            if (strList.size() == listWithoutDuplicates.size()) {
                find = true;
                break;
            }
            index++;
        }
        if (find) {
            System.out.println("A number consisting of different numbers only: " + numbers[index]);
        }
    }


    //8. Среди чисел найти число-палиндром. Если таких чисел больше одного, найти второе.
    private void findNumberPalindrome() {
        int[] numbers = getArray();
        int[] arrayAbsNum = getAbsArray(numbers);
        int count = 0;
        int index = 0;
        int indexForFirst = 0;
        for(int number : arrayAbsNum) {
            String stringNumbers = String.valueOf(number);
            StringBuilder stringBuffer = new StringBuilder(stringNumbers);
            String reverseString = stringBuffer.reverse().toString();
            if (stringNumbers.equals(reverseString)) {
                count++;
                if (count == 1)
                    indexForFirst = index;
                if (count == 2){
                    break;
                }
            }
            index++;
        }
        if (count == 1) {
            System.out.println("Palindrome number: " + numbers[indexForFirst]);
        } else if (count == 2) {
            System.out.println("Palindrome number: " + numbers[index]);
        } else {
            System.out.println("missing number - palindrome");
        }
    }


    void startDataTypes() {

        findShortestAndLongestNumber();
        sortAndDisplayNumbersAscendingAndDescendingLength();
        printNumbersSmallerAndLongerThanAverageLength();
        findNumberWithMinimumOfDifferentNumbers();
        findNumberOfEvenNumberedNumbers();
        findNumbersWithAscendingNumbers();
        findNumbersOnlyFromDifferentNumbers();
        findNumberPalindrome();
    }
}