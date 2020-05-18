public class Task_4 {
    public static void main(String[] args) {

        int [][] array = Task_1.maker("Введите длинну матрицы:");
        int sum = 0;

        for ( int i = 0; i < array.length; i++ ) {
            for ( int j = 0; j < array[i].length; j++ ) {
                if ( j < array [i].length - i - 1 && array [i][j] % 2 == 0 ) {
                    sum += array [i][j];
                }
            }
        }

        System.out.println("Cумма четных значений над побочной диагональю матрицы (не включительно) равна: " + sum);
    }
}
