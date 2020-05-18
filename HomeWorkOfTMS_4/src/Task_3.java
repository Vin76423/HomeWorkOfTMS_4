import java.util.Arrays;

public class Task_3 {
    public static void main(String[] args) {

        int [][] array = Task_1.maker("Введите длинну матрицы:");

        System.out.println();
        int summGeneralLine = 1;
        int summUnGeneralLine = 1;

        for ( int i = 0; i < array.length; i++ ) {
            for ( int j = 0; j < array[i].length; j++ ) {
                if ( j == i ) {
                    summGeneralLine *= array [i][j];
                }
                if ( j == array[i].length - i -1 ) {
                    summUnGeneralLine *= array [i][j];
                }
            }
        }

        if ( summGeneralLine > summUnGeneralLine ) {
            System.out.println("Произведение главной диагонали больше и ровняется: " + summGeneralLine);
        } else {
            System.out.println("Произведение второстепенной диагонали больше и ровняется: " + summUnGeneralLine);
        }
    }
}
