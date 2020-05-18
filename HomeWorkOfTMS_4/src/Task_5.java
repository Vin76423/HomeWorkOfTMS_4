import java.util.Arrays;

public class Task_5 {
    public static void main(String[] args) {

        int [][] array = Task_1.maker("Введите длинну матрицы:");
        int [][] newArray = new int[array.length][array.length];

        System.out.println();

        for ( int i = 0; i < array.length; i++ ) {
            for ( int j = 0; j < array[i].length; j++ ) {
                newArray [j][i] = array [i][j];
            }
        }


        for ( int i = 0; i < newArray.length; i++ ) {
            for ( int j = 0; j < newArray[i].length; j++ ) {
                System.out.print(newArray [i][j] + "  ");
            }
            System.out.println();
        }


    }
}
