import java.util.Arrays;

public class Task_2 {
    public static void main(String[] args) {

        int [][] array = Task_1.maker("Введите длинну матрицы:");

        System.out.println();

        for ( int i = 0; i < array.length; i++ ) {
            for ( int j = 0; j < array[i].length; j++ ) {
                if ( j <= i && array [i][j] % 2 != 0 ) {
                    System.out.print(array [i][j] + " ");
                }
            }
        }
    }
}

