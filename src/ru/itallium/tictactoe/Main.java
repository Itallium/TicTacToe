package ru.itallium.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //Создание игрового поля
    public static char field[][] = {
            { '+', '+', '+' },
            { '+', '+', '+' },
            { '+', '+', '+' }
    };

    //Ход компьютера (random-бот)
    //Бот рандомно выбирает строку и столбец до тех пор, пока не попадёт на пустую клетку.
    public static void CompMove() {

        int y = (int) Math.floor(Math.random() * 3);
        int x = (int) Math.floor(Math.random() * 3);
        while(field[y][x] != '+') {
            y = (int) Math.floor(Math.random() * 3);
            x = (int) Math.floor(Math.random() * 3);
        }
        field[y][x] = '0';

    }

    //Ход человека
    public static void HumanMove() throws IOException {

        int y = -1, x = -1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(x < 0 || x > 2 || y < 0 || y > 2 || field[y][x] != '+') {
            System.out.println("Введите строку (1..3):");
            y = Integer.parseInt(reader.readLine()) - 1;
            System.out.println("Введите столбец (1..3)");
            x = Integer.parseInt(reader.readLine()) - 1;
            if (x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Вы попали за пределы игрового поля. Повторите ввод.");
                PrintField();
                continue;
            }
            if (field[y][x] != '+') {
                System.out.println("Эта клетка уже занята. Повторите ввод.");
                PrintField();
                continue;
            }
        }
        //Так как первые условия цикла проверяют не вышли ли введённые данные за пределы поля,
        //мы не получаем ошибки программы. Если бы первым условием мы проверяли field[y][x] != '+'
        //то мы получили бы ошибку, так как одна из координат вышла за пределы границ field.
        field[y][x] = 'X';

    }

    //Распечатка текущего состояния игрового поля.
    public static void PrintField() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

    }

    //Проверка на наличие ходов.
    public static boolean CanMove() {

        int canMove = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == '+') canMove = 1;
            }
        }
        if (canMove == 1) return true;
        else return false;

    }

    //Проверка победителя
    public static char CheckGame() {

        char winner = '+';
        //Проверка победителя по строкам
        for(int i = 0; i < 3; i++) {
            if(field[i][0] == field[i][1] && field[i][1] == field[i][2]) {
                winner = field[i][0];
            }
        }

        //Проверка победителя по столбцам
        for(int i = 0; i < 3; i++) {
            if(field[0][i] == field[1][i] && field[1][i] == field[2][i]) {
                winner = field[0][i];
            }
        }

        //Проверка победителя по главной диагонали
        if(field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
            winner = field[0][0];
        }

        //Проверка победителя по дополнительной диагонали
        if(field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
            winner = field[0][2];
        }
        //Хотелось бы отметить, что я не проверяю перед каждым циклом наличие победителя.
        //Программа проверяет победителя после каждого хода, поэтому неоднознацных ситуаций
        //не возникает.
        return winner;

    }

    public static void main(String[] args) throws IOException {

        int gameCount = 1; //Номер партии

        //Основной цикл игры. Цикл бесконечный и предназначен для того,
        //чтоб человек мог повторить партию. Чтобы выйти из такого массива используется
        //команда break.
        while(true) {
            System.out.println("Игра №" + gameCount + " началась!");
            //Случайным образом выбираем игрока.
            float gamer = (float) Math.random();
            //Функция Math.random() выдаёт случайное число от 0 до 1.
            if (gamer <= 0.5) {
                System.out.println("Первым ходит компьютер.");
                while(true) {
                    CompMove();
                    if(CheckGame() != '+' || !CanMove()) break;
                    PrintField();
                    HumanMove();
                    if(CheckGame() != '+' || !CanMove()) break;
                    //Алгоритм прост: ходит компьютер, проверяется победитель и наличие ходов.
                    //После этого распечатываем игровое поле (чтоб игрок увидел ход компьютера).
                    //В конце ходит человек и производится проверка на победу и наличие ходов.
                }
            }
            if (gamer > 0.5) {
                System.out.println("Первым ходит человек.");
                while(true) {
                    PrintField();
                    HumanMove();
                    if(CheckGame() != '+' || !CanMove()) break;
                    CompMove();
                    if(CheckGame() != '+' || !CanMove()) break;
                    //Тут тоже всё просто: для начала печатаем игровое поле, чтоб знать его текущее состояние.
                    //Далее ходит человек, потом проверка на победу и наличие ходов.
                    //Далее ход компьютера и опять проверка на победу и наличие ходов.
                }
            }
            //распечатка итогового вида игрового поля и выявление победителя
            PrintField();
            if(CheckGame() == 'X') System.out.println("Поздравляю, ты выиграл!");
            if(CheckGame() == '0') System.out.println("Вы проиграли.");
            if(!CanMove()) System.out.println("Ходов больше нет.");
            System.out.print("\n~~~~~~~~\nХотите попробовать ещё раз? y - yes\n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //Если пользователь введёт с клавиатуры символ 'y' и нажмёт Enter,
            //то начнётся новая игра. Если нет, то оператор break завершит основной цикл.
            if(reader.readLine().equals("y")) {
                gameCount++;
                //Очистка игрового поля
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        field[i][j] = '+';
                    }
                }
            } else break;
        }
        System.out.println("Спасибо, что протестировали мою игру. Надеюсь вам понравилось.");
    }
}
