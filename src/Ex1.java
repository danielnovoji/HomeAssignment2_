import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        printArray();


    }

    public static void printArray() {
        int[] array = new int[10];
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 10 numbers in the array: ");
        for (int i = 0; i < array.length; i++) {
            int numbers = scanner.nextInt();
            array[i] = numbers;
            sum += numbers;

        }
        System.out.println("The average of the array is: " + sum / 10);
        int average;
        average = sum /10;
        System.out.println("The numbers that are bigger than the average: ");
        for (int j=0; j<array.length; j++) {
            if (array[j]>average) {
                System.out.println(array[j]);

            }
        }


    }
}
