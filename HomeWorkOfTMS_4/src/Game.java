import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {


        // Part 1: (Подготовка исходных данных)
        boolean somebodyWin = false;
        int numberOfPlayer = 1;
        int gameCounter = 0;
        int counterPlayer1 = 0; //x
        int counterPlayer2 = 0; //0
        int[][] workPlace = new int[3][3];
        int [][] cache = new int[9][2]; // row/column
        System.out.println("Перед вами игра крестики-нолики. Ваша задача заполнять" +
                " рабочее поле 3х3 поочереди. Первый игрок играет за \"Х\" , второй за \"0\". " +
                "\nчтобы вписать свое значение в игравое поле, нужно указать номер строки а затем номер колонки для своего значения во время хода." +
                "\nНумерация начинаятся c левого верхнего угла поля");
        for (int i = 0; i < workPlace.length; i++) {
            for (int j = 0; j < workPlace[i].length; j++) {
                workPlace[i][j] = 0;
                System.out.print("* ");
            }
            System.out.println();
        }


        // Part 2: (Рабочее тело игры - итератор)
        body: while (gameCounter < 9) {
            // Получает инпут от игрока, осуществляет его валидацию
            int valueRow = 0;
            int valueColumn = 0;
            boolean key = true;
            String massage = "Введите координату(номер) строки:";
            System.out.println(numberOfPlayer + " игрок делает ход.");
            while ( key ) {
                for ( int i = 0; i < 2; i++) {
                    System.out.println(massage);
                    int value;
                    while ( true ) {
                        Scanner scanner = new Scanner(System.in);
                        if ( scanner.hasNextInt() ) {
                            value = scanner.nextInt();
                            if ( value > 0 && value < 4 ) {
                                break;
                            }
                        }
                        System.out.println("Значение не корректно, попробуйте еще раз:");
                    }
                    if ( i == 0 ) {
                        valueRow = value;
                        massage = "Введите координату(номер) столбца:";
                    } else {
                        valueColumn = value;
                    }
                }
                key = false;
                for ( int i = 0; i < cache.length; i++ ) {
                    if ( valueRow == cache[i][0] && valueColumn == cache[i][1] ) {
                        key = true;
                        System.out.println("Эта ячейка уже заполнена! Введите другие координаты.");
                        break;
                    }
                }
                cache[gameCounter][0] = valueRow;
                cache[gameCounter][1] = valueColumn;
            }
            // Вносит изменения и выводит рабочее поле на экран
            for ( int i = 0; i < workPlace.length; i++ ) {
                for ( int j = 0; j < workPlace[i].length; j++ ) {

                    if ( i == valueRow - 1 && j == valueColumn - 1 ) {
                        if ( gameCounter % 2 == 0 ) {
                            workPlace[i][j] = 1;
                        } else {
                            workPlace[i][j] = 2;
                        }
                    }

                    if ( workPlace[i][j] == 1 ) {
                        System.out.print("X ");
                    } else  if ( workPlace[i][j] == 2 ) {
                        System.out.print("0 ");
                    } else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
            // Корректирует статистику ходов игроков
            if ( gameCounter % 2 == 0 ){
                counterPlayer1++;
            } else {
                counterPlayer2++;
            }
            // Проверяет рабочее поле на предмет выигрыша
            for ( int x = 0; x < 4; x++ ) {
                int counterForX = 0;
                int counterFor0 = 0;
                int[] counterColumnForX = {0,0,0};
                int[] counterColumnFor0 = {0,0,0};
                for ( int i = 0; i < workPlace.length; i++ ) {
                    int counterRowForX = 0;
                    int counterRowFor0 = 0;

                    for ( int j = 0; j < workPlace[i].length; j++ ) {
                        switch ( x ) {
                            case 0: // Проверяется главная диагональ
                                if ( i == j && workPlace[i][j] == 1 ) {
                                    counterForX++;
                                } else if ( i == j && workPlace[i][j] == 2 ) {
                                    counterFor0++;
                                }
                                break;
                            case 1: // Проверяется побочная диагональ
                                if ( workPlace[i].length - 1 - i == j && workPlace[i][j] == 1 ) {
                                    counterForX++;
                                } else if ( workPlace[i].length - 1 - i == j && workPlace[i][j] == 2 ) {
                                    counterFor0++;
                                }
                                break;
                            case 2: // Проверяется горизонтальные строки
                                if ( workPlace[i][j] == 1 ) {
                                    counterRowForX++;
                                } else if ( workPlace[i][j] == 2 ) {
                                    counterRowFor0++;
                                }
                                break;
                            case 3: // Проверяется вертикальные столбцы
                                if ( workPlace[i][j] == 1 ) {
                                    counterColumnForX [j]++;
                                } else if ( workPlace[i][j] == 2 ) {
                                    counterColumnFor0 [j]++;
                                }
                        }
                    }

                    if ( counterRowForX == workPlace[i].length || counterRowFor0 == workPlace[i].length ) {
                        somebodyWin = true;
                        break body;
                    }

                }
                if ( counterForX == workPlace.length || counterFor0 == workPlace.length ) {
                    somebodyWin = true;
                    break body;
                }
                for ( int i = 0; i < counterColumnForX.length; i++ ) {
                    if ( counterColumnForX[i] == 3 || counterColumnFor0[i] == 3 ) {
                        somebodyWin = true;
                        break body;
                    }
                }
            }
            // Корректирует статистику игры
            if ( gameCounter % 2 == 0 ){
                numberOfPlayer++;
            } else {
                numberOfPlayer--;
            }
            gameCounter++;
        }


        // Part 3: (Подведение результатов игры)
        System.out.println("И так, игра закончена.");
        if ( somebodyWin ) {
            System.out.print("У нас есть победитель им стал игрок под номером " + numberOfPlayer);
            if ( gameCounter % 2 == 0 ) {
                System.out.println(" За " + counterPlayer1 + " хода");
            } else {
                System.out.println(" За " + counterPlayer2 + " хода");
            }
        } else {
            System.out.println("К сожалению у нас ничья...Не хотите ли сыграть еще раз?");
        }
    }
}
