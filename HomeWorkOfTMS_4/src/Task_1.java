import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {

        int [][] array = maker("Введите длинну матрицы:");
        int sum = 0;

        for ( int i = 0; i < array.length; i++ ) {
            for ( int j = 0; j < array[i].length; j++ ) {
                if ( i == j && array [i][j] % 2 == 0 ) {
                    sum += array [i][j];
                }
            }
        }

        System.out.println("Cумма четных значений главной диагонали матрицы равна: " + sum);
    }

    public static int [][] maker ( String massage ) {
        Random random = new Random();
        int value;
        System.out.println(massage);
        while ( true ) {
            Scanner scanner = new Scanner(System.in);
            if ( scanner.hasNextInt() ) {
                value = scanner.nextInt();
                if ( value > 0 ) {
                    break;
                }
            }
            System.out.println("Значение не корректно, попробуйте еще раз:");
        }
        int [][] someArray = new int[value][value];
        for ( int i = 0; i < someArray.length; i++ ) {
            for ( int j = 0; j < someArray[i].length; j++ ) {
                someArray [i][j] = random.nextInt(50);
                System.out.print(someArray[i][j] + "  ");
            }
            System.out.println();
        }
        return someArray;
    }
}
