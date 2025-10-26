package org.example;
import java.util.Scanner;
import java.util.Random;

public class LW_1 {

    // Константи для розміру матриці та діапазону випадкових чисел
    public static final int MAX_SIZE = 20;
    public static final int MIN_RANDOM = 0;
    public static final int MAX_RANDOM = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть кількість рядків матриці (1-20): ");
        int rows = readIntInRange(scanner, 1, MAX_SIZE);

        System.out.println("Введіть кількість стовпців матриці (1-20): ");
        int cols = readIntInRange(scanner, 1, MAX_SIZE);

        System.out.println("Обрати спосіб заповнення матриці: 1 - вручну, 2 - випадково");
        int choice = readIntInRange(scanner, 1, 2);

        int[][] matrix = new int[rows][cols];

        if (choice == 1) {
            fillMatrixManually(scanner, matrix);
        } else {
            fillMatrixRandomly(matrix);
        }

        System.out.println("\nЗгенерована матриця:");
        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);

        System.out.println("\nМінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);

        scanner.close();
    }

    // Метод для введення числа в діапазоні
    public static int readIntInRange(Scanner scanner, int min, int max) {
        int num;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num >= min && num <= max) {
                    break;
                } else {
                    System.out.println("Число має бути в діапазоні " + min + "-" + max + ". Спробуйте ще раз:");
                }
            } else {
                System.out.println("Невірне введення. Введіть число:");
                scanner.next(); // пропускаємо некоректний ввід
            }
        }
        return num;
    }

    // Метод для ручного заповнення матриці
    public static void fillMatrixManually(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Введіть елемент [" + i + "][" + j + "]: ");
                matrix[i][j] = readInt(scanner);
            }
        }
    }

    // Метод для введення одного числа
    public static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Невірне введення. Введіть ціле число:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Метод для випадкового заповнення матриці
    public static void fillMatrixRandomly(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM;
            }
        }
    }

    // Метод для друку матриці
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.printf("%5d", elem);
            }
            System.out.println();
        }
    }

    // Метод для пошуку мінімального елемента
    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int elem : row) {
                if (elem < min) {
                    min = elem;
                }
            }
        }
        return min;
    }

    // Метод для пошуку максимального елемента
    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int elem : row) {
                if (elem > max) {
                    max = elem;
                }
            }
        }
        return max;
    }

    // Метод для розрахунку середнього арифметичного
    public static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int elem : row) {
                sum += elem;
                count++;
            }
        }
        return (double) sum / count;
    }
}

