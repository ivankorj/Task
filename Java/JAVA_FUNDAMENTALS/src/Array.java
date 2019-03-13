import java.util.*;
import java.lang.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

class Array {

    private Scanner in = new Scanner(System.in);

    private int enterNumbers() {
        String input;
        while (!(input = in.next()).matches("\\p{Digit}+")) {
            System.out.print("Please enter a positive Integer: ");
        }
        return Integer.parseInt(input);
    }

    private void outputMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row)
                System.out.print(String.format("%3d", col));
            System.out.println();
        }
    }

    private void outputMatrixPlusOne(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length - 1; i++) {
                System.out.print(String.format("%3d", row[i]));
            }
            System.out.println();
        }
    }


    //Ввести с консоли n-размерность матрицы a[n][n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью генератора случайных чисел.
    private int[][] getMatrix() {
        System.out.print("enter matrix size (n): ");
        int size = enterNumbers();
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ThreadLocalRandom.current().nextInt( -size, size + 1);
            }
        }
        outputMatrix(array);
        return array;
    }


    //1. Упорядочить строки матрицы в порядке возрастания значений элементов k-го столбца.
    private void sortMatrixRowsInAscendingOrder() {
        int[][] matrix = getMatrix();
        System.out.print("enter column number (k): ");
        final int k = enterNumbers();
        Arrays.sort(matrix, Comparator.comparingInt(x -> x[k]));
        outputMatrix(matrix);
    }


    //2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).
    private void performCircularShiftMatrix() {
        int[][] matrix = getMatrix();
        System.out.print("enter the number of shifts (k): ");
        final int shiftOn = enterNumbers();
        System.out.println("right shift");
        shiftRight(copyMatrix(matrix), shiftOn);
        System.out.println("left shift");
        shiftLeft(copyMatrix(matrix), shiftOn);
        System.out.println("shift up");
        shiftUp(copyMatrix(matrix), shiftOn);
        System.out.println("shift down");
        shiftDown(copyMatrix(matrix), shiftOn);
    }

    private int[][] copyMatrix(int[][] matrix) {
        int[][] copyArray = new int[matrix.length][];
        for (int i = 0; i < matrix.length; ++i)
            copyArray[i] = matrix[i].clone();
        return copyArray;
    }

    private void shiftRight(int[][] array, int step) {
        int count = 0;
        while (count < step) {
            int temp, j;
            for (int i = 0; i < array.length; i++) {
                temp = array[i][array.length - 1];
                for (j = array.length - 1; j > 0; j--) {
                    array[i][j] = array[i][j - 1];
                }
                array[i][j] = temp;
            }
            count++;
        }
        outputMatrix(array);
    }

    private void shiftLeft(int[][] array, int step) {
        for (int i = 0; i < array.length; i++) {
            int realSteps = step % array[i].length;
            while(realSteps-- > 0) {
                int temp = array[i][0];
                for (int j = array[i].length - 1; j >= 0; j--) {
                    int val = array[i][j];
                    array[i][j] = temp;
                    temp = val;
                }
            }
        }
        outputMatrix(array);
    }

    private void shiftUp(int[][] array, int step) {
        int count = 0;
        while (count < step) {
            int temp, j;
            for (int i = 0; i < array.length; i++) {
                temp = array[0][i];
                for (j = 0; j < array.length - 1; j++) {
                    array[j][i] = array[j + 1][i];
                }
                array[j][i] = temp;
            }
            count++;
        }
        outputMatrix(array);
    }

    private void shiftDown(int[][] array, int step) {
        int[] temp;
        for (int i = 0; i < step; i++) {
            temp = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = temp;
        }
        outputMatrix(array);
    }


    //3. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
    private void findLargestIncreasingAndDecreasingElements() {
        int[][] matrix = getMatrix();
        int[] oneArray = new int[matrix.length * matrix.length];
        int min = 0;
        int max = 0;
        int idOneArr = 0;
        int idLastIncr = 0;
        int idLastDes = 0;
        for (int[] arr : matrix) {
            for (int elem : arr) {
                oneArray[idOneArr++] = elem;
            }
        }
        int countIncrease = 0;
        int countDescending = 0;
        for (int i = 0; i < oneArray.length - 1; i++) {
            if (oneArray[i] < oneArray[i + 1]) {
                countIncrease += 1;
                if (countIncrease > max) {
                    max = countIncrease;
                    idLastIncr = i + 1;
                }
            } else {
                countIncrease = 0;
            }
            if (oneArray[i] > oneArray[i + 1]) {
                countDescending += 1;
                if (countDescending > min) {
                    min = countDescending;
                    idLastDes = i + 1;
                }
            } else {
                countDescending = 0;
            }
        }
        System.out.println("Maximum sequence of increasing numbers:");
        display(oneArray, max, idLastIncr);
        System.out.println("Maximum sequence of decreasing numbers:");
        display(oneArray, min, idLastDes);
    }

    private void display(int[] array, int count, int id) {
        int[] arr = new int[count + 1];
        System.arraycopy(array, (id - count), arr, 0, (count + 1));
        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }
        System.out.println(", amt.: " + (count + 1));
    }

    //4. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
    private void sumOfMatrixElements() {
        int[][] matrix = getMatrix();
        int sum = 0;
        boolean firstPositiveNum = false;
        int[] arrWithSum = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            arrWithSum[i] = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (firstPositiveNum && (matrix[i][j] < 0)) {
                    arrWithSum[i] += matrix[i][j];
                }
                if ((matrix[i][j] > 0) && !firstPositiveNum) {
                    firstPositiveNum = true;
                    continue;
                }
                if ((matrix[i][j] > 0) && firstPositiveNum) {
                    firstPositiveNum = false;
                    break;
                }
            }
        }
        for (int sumInRow : arrWithSum) {
            sum += sumInRow;
        }
        System.out.println(sum);
    }


    //5. Перестроить матрицу, переставляя в ней строки так, чтобы сумма элементов в строках полученной матрицы возрастала.
    private void sortMatrixRowsBySum() {
        System.out.print("enter matrix size (n): ");
        int size = enterNumbers();
        int[][] matrix = new int[size][size + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt( -size, size + 1);
            }
        }
        outputMatrixPlusOne(matrix);
        System.out.println(" ");
        int sum;
        for (int i = 0; i < matrix.length; i++) {
            sum = 0;
            for (int j = 0; j < matrix[i].length - 1; j++) {
                sum += matrix[i][j];
            }
            matrix[i][matrix.length] = sum;
        }
        Arrays.sort(matrix, Comparator.comparingInt(x -> x[matrix.length]));
        outputMatrixPlusOne(matrix);
    }


    //6. Найти максимальный элемент (ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
    private Set<Integer> rowsToDelete, columnsToDelete;

    private void deleteRowCol() {
        int[][] matrix = getMatrix();
        if (matrix.length > 1) {
            int max = findMax(matrix);
            getIdMax(matrix, max);
            System.out.println("Largest number: " + max);
            System.out.println("Rows to delete: " + rowsToDelete);
            System.out.println("Columns to delete: " + columnsToDelete);
            int[][] modifiedMatrix = deleteRows(matrix);
            modifiedMatrix = deleteColumns(modifiedMatrix);
            outputMatrix(modifiedMatrix);
        } else System.out.println("Largest number: " + matrix[0][0]);
    }

    private int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for(int[] row : matrix) {
            for(int value : row) {
                if(value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    private void getIdMax(int[][] matrix, int max) {
        rowsToDelete = new HashSet<>();
        columnsToDelete = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == max) {
                    rowsToDelete.add(i);
                    columnsToDelete.add(j);
                }
            }
        }
    }

    private int[][] deleteRows(int[][] matrix) {
        int rowsToLeave = matrix.length - rowsToDelete.size();
        int[][] modifiedMatrix = new int[rowsToLeave][];
        int p = 0;
        for(int i = 0; i < matrix.length; i++) {
            if(!rowsToDelete.contains(i)) {
                modifiedMatrix[p] = matrix[i];
                p++;
            }
        }
        return modifiedMatrix;
    }

    private int[][] deleteColumns(int[][] matrix) {
        int countDeletedCol = 0;
        for(int columnToDelete : columnsToDelete){
            int[][] modifiedMatrix = new int[matrix.length][matrix[0].length - 1];
            for(int i = 0; i < matrix.length; i++) {
                int p = 0;
                for(int j = 0; j < matrix[i].length; j++) {
                    if(j != columnToDelete - countDeletedCol) {
                        modifiedMatrix[i][p] = matrix[i][j];
                        p++;
                    }
                }
            }
            countDeletedCol++;
            matrix = modifiedMatrix;
        }
        return matrix;
    }


    void startArrays () {

        sortMatrixRowsInAscendingOrder();
        performCircularShiftMatrix();
        findLargestIncreasingAndDecreasingElements();
        sumOfMatrixElements();
        sortMatrixRowsBySum();
        deleteRowCol();
    }
}
