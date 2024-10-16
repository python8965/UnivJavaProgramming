/*
 * This source file was generated by the Gradle 'init' task
 */
package univjavaprogramming;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.GapContent;

public class App {
    

    public static void main(String[] args) {
        Challenge4();
        //Practice.week5();
    }

    public static void Challenge1(){
        int hour, minute;

        int currentMinute;
        int alarmMinute = 9 * 60;

        try (Scanner scanner = new Scanner(System.in)) { 
            for (;;){
                System.out.printf("현재 시간을 입력하세요 (HH 형식) : ");
                hour = scanner.nextInt();

                if (hour < 0 || hour > 24){
                    System.out.println("시간은 0 ~ 24 사이로 입력해주셔야 합니다.");
                    continue;
                }

                System.out.printf("현재 분을 입력하세요 (mm 형식) : ");
                minute = scanner.nextInt();

                if (minute < 0 || minute > 60){
                    System.out.println("분은 0 ~ 60 사이로 입력해주셔야 합니다.");
                    continue;
                }

                break;
            }

            currentMinute = hour * 60 + minute;

            int resultMinuteDiff = currentMinute - alarmMinute;

            boolean sign = resultMinuteDiff > 0;

            int resultMinuteSum = Math.abs(resultMinuteDiff);

            int resultHour = resultMinuteSum / 60;
            int resultMinute = resultMinuteSum % 60;

            if (resultMinuteSum == 0){
                System.out.println("알람이 울리는 중입니다!");
                return;
            }

            if (sign) {
                System.out.printf("알람이 울린 후 %d시간 %d분 지났습니다.", resultHour, resultMinute);
            } else {
                System.out.printf("알람이 울리기까지 %d시간 %d분 남았습니다.", resultHour, resultMinute);
            }
        }
    }

    

    public static void Challenge2(){
        class Helper {
            public static int randomRange(int start, int end){
                return (int)(Math.random() * (end - start - 1)) + start;
            }
        }

        try (Scanner scanner = new Scanner(System.in)) { 
            var inputLottoNumber = new int[6];
            var lottoNumber = new int[6];

            for (int i = 0; i < inputLottoNumber.length; i++) {
                check : for (;;){
                    var num = Helper.randomRange(1, 45);

                    if (num < 1 || num > 45){
                        continue;
                    }

                    for (int j : inputLottoNumber) {
                        if (j == num){
                            continue check;
                        }
                    }

                    inputLottoNumber[i] = num;
                    break;
                }
            }

            for (int i = 0; i < lottoNumber.length; i++) {
                System.out.print("로또 번호를 입력하세요 (1부터 45 사이의 숫자, 중복 없이) : ");

                check : for (;;){
                    var num = scanner.nextInt();

                    if (num < 1 || num > 45){
                        System.out.println("입력 숫자는 반드시 1~45 사이어야 합니다.");
                        continue;
                    }

                    for (int j : lottoNumber) {
                        if (j == num){
                            System.out.println("입력 숫자는 중복되면 안됩니다.");
                            System.out.print("로또 번호를 입력하세요 (1부터 45 사이의 숫자, 중복 없이) : ");

                            continue check;
                        }
                    }

                    lottoNumber[i] = num;
                    break;
                }
            }


            Arrays.sort(inputLottoNumber);
            Arrays.sort(lottoNumber);

            System.out.printf("당첨 번호: %s\n", Arrays.toString(lottoNumber));
            System.out.printf("사용자 번호: %s\n", Arrays.toString(inputLottoNumber));

            var correct = 0;

            for (int i = 0; i < inputLottoNumber.length; i++) {
                var num = inputLottoNumber[i];

                for (int j : lottoNumber) {
                    if (j == num){
                        correct += 1;
                        break;
                    }
                }
            }

            switch (correct) {
                case 3:
                    System.out.println("4등입니다.");
                    break;
                case 4:
                    System.out.println("3등입니다!");
                    break;
                case 5:
                    System.out.println("2등입니다!!");
                    break;
                case 6:
                    System.out.println("1등입니다!!!");
                    break;
                default:
                    System.out.printf("꽝입니다. 일치하는 번호가 %d개입니다.", correct);
                    break;
            }
        }
    }

    public static char intToChar(int toChar) {
        return (char)(toChar + 65);
    }

    public static void Challenge3(){

        class  SeatPosition implements Comparable<SeatPosition> {
            int row;
            int col;

            public SeatPosition(int row, int col) {
                this.row = row;
                this.col = col;
            }



            public SeatPosition(String string) throws RuntimeException {
                var tempRow = 0;
                var tempCol = 0;

                // Input [A-Z][0-9] * n

                tempCol = (int)string.charAt(0) - 65;

                tempRow = Integer.parseInt(string.substring(1)) - 1;

                this.row = tempRow;
                this.col = tempCol;
            }

            public boolean  checkIsValid(int numRows, int numCols){
                return !(row < 0 || row >= numRows || col < 0 || col >= numCols);
            }



            @Override
            public String toString() {
                if (col + 16 > (int)'Z'){

                }

                return String.valueOf(intToChar(col)) + (row + 1);
            }



            @Override
            public int compareTo(SeatPosition o) {

                if(this.col > o.col) {
                    return 1;
                }

                if(this.col == o.col) {
                    if (this.row > o.row){
                        return 1;
                    } else if (this.row == o.row){
                        return 0;
                    } else {
                        return -1;
                    }
                }

                else {
                    return -1;
                }
            }
        }

        class Reservation {
            SeatPosition position;
            String name;
            String phoneNumber;
        }

        

        class MovieTheater {
            int numRows;
            int numCols;
            
            TreeMap<SeatPosition, Reservation> seat;


            public MovieTheater(int numRows, int numCols){
                this.numRows = numRows;
                this.numCols = numCols;
                seat = new TreeMap<>();
            }

            public void displaySeats(){
                var keys = seat.keySet().iterator();

                var nextPosition = keys.hasNext() ? keys.next() : null;

                System.out.print("  ");

                for (var i = 0; i < numRows; i++){ 
                    System.out.printf("%d ", i+1);
                }

                System.out.println();

                for (var j = 0 ;j < numCols; j++){
                    System.out.print(intToChar(j));
                    System.out.print(" ");

                    for (var i = 0; i < numRows; i++){

                        if (nextPosition == null) {
                            System.out.print("□ ");
                        } else {

                            var currentSeekPosition = new SeatPosition(i, j);

                            if (nextPosition.compareTo(currentSeekPosition) == 0) {
                                System.out.print("■ ");
                                nextPosition = keys.hasNext() ? keys.next() : null;
                            } else {
                                System.out.print("□ ");
                            }
                        }
                    }

                    System.out.println();
                }
            }

            public boolean reserveSeat(Reservation reservation){

                
                if (seat.containsKey(reservation.position)){
                    System.err.println("빈 곳을 찾아 예약해주세요");
                    return false;    
                }


                if (!reservation.position.checkIsValid(numRows, numCols)){
                    System.err.printf("예약할 좌석 범위는 A1 ~ %s 이내여야 합니다.\n", 
                        new SeatPosition(numRows - 1, numCols - 1).toString());
                    return false;
                }

                seat.put(reservation.position, reservation);

                return true;
            }

            public boolean cancelReservation(SeatPosition position) {
                if (!position.checkIsValid(numRows, numCols)){
                    System.err.printf("삭제할 좌석 범위는 A1 ~ %s 이내여야 합니다.\n", 
                        new SeatPosition(numRows - 1, numCols - 1).toString());
                    return false;
                }

                if (!seat.containsKey(position)){
                    System.err.println("예약되지 않은 자리입니다. 다시 선택해주세요.");
                    return false;    
                }

                seat.remove(position);

                return true;
            }

            public void displayReservationInfo(String name) {
                for (var reservation : seat.values()){
                    if (reservation.name.equals(name)) {
                        System.out.println("예약 정보 >> ");
                        System.out.printf("좌석 : %s\n이름 : %s\n전화번호 : %s\n", 
                            reservation.position.toString(), 
                            reservation.name, 
                            reservation.phoneNumber);
                        return ;
                    } 
                }

                System.err.printf("%s 이라는 이름은 없습니다.\n", name);
            }
        }

        Scanner scanner = new Scanner(System.in);

        MovieTheater movieTheater = new MovieTheater(10, 10);

        exit: for (;;) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("1. 좌석 조회\n2. 좌석 예약\n3. 좌석 예약 취소\n4. 예약 정보 조회\n5. 종료\n원하는 작업을 선택하세요 (1/2/3/4/5): ");
            var selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    movieTheater.displaySeats();
                    break;
                case 2:
                    System.out.print("예약 화면입니다. ");

                    Reservation reservation = new Reservation();

                    System.out.print("예약하고 싶은 좌석의 번호/이름/전화번호 순으로 입력하주세요. (예: A2/홍길동/123-4567)\n");

                    try {
                        var str=  scanner.next();
                        var splitted = str.split("/");

                        reservation.position = new SeatPosition(splitted[0]);

                        reservation.name = splitted[1];
                        reservation.phoneNumber = splitted[2];

                        movieTheater.reserveSeat(reservation);
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("예약을 취소할 좌석을 입력하세요 (예: A2): ");
                    try {
                        var parsedPos = new SeatPosition(scanner.next());

                        movieTheater.cancelReservation(parsedPos);
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    }

                    
                    break;
                case 4:
                    System.out.print("조회하고 싶은 예약의 예약자명을 입력해주세요: ");



                    movieTheater.displayReservationInfo(scanner.next());    

                    break;
                case 5:
                    
                    break exit;
                default:
                    throw new AssertionError();
            }
        }

    }

    public static void Challenge4() {
        class Helper {
            public static int randomRange(int start, int end){
                return (int)(Math.random() * (end - start - 1)) + start;
            }
        }

        class Position {
            int x;
            int y;

            Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        enum Tile {
            PacMan, Empty, Cookie
        }

        class GameObject {
            Position position;
            public GameObject(Position position){
                this.position = position;
            }

            public void register(Tile[][] tile){
                tile[position.y][position.x] = getTileType();
            }

            protected Tile getTileType(){
                return Tile.Empty;
            }
        }



        class PacMan extends GameObject{
            public PacMan(Position position) {
                super(position);
            }

            @Override
            protected Tile getTileType() {
                return Tile.PacMan;
            }
        }

        class Cookie  extends GameObject{

            public Cookie(Position position) {
                super(position);
            }

            @Override
            protected Tile getTileType() {
                return Tile.Cookie;
            }
        }


        
        
        

        enum Direction {
            UP, DOWN,
            RIGHT, LEFT
        }

        class Map {
            Tile[][] mapData;

            Cookie[] cookies;
            PacMan pacMan;

            public Map(int width, int height) {
                mapData = new Tile[height][width];

                int cookieAmount = Helper.randomRange(2, 6);

                cookies = new Cookie[cookieAmount];

                pacMan = new PacMan(new Position(0, 0));
                pacMan.register(mapData);


                for (int i = 0; i < cookieAmount; i++){
                    int x = 0;
                    int y = 0;

                    while (true) { 
                        x = Helper.randomRange(0, width);
                        y = Helper.randomRange(0, height);

                        if (mapData[x][y] != Tile.Empty){
                            break;
                        }
                    }

                    cookies[i] = new Cookie(new Position(x, y));
                    cookies[i].register(mapData);
                }
            }

            public void PrintMap(){
                for (var row : mapData) {
                    for (var tile : row) {
                        var c = '-';


                        if (tile != null){
                        switch (tile) {
                            case PacMan:
                                c = 'C';
                                break;
                            case Cookie:
                                c = 'o';
                                break;
                            default:
                                break;
                        }}

                        System.out.printf("%c", c);
                    }

                    System.out.println();
                }
            }

            public Tile Peek(Position current, Direction direction) {

                return null;
            }
        }

        var scanner = new Scanner(System.in);

        var map = new Map(10, 10);

        map.PrintMap();

        scanner.next();
    }

    public static void Challenge5(){
        class SouthPanel extends JPanel{
            public SouthPanel() {
                add(new Label("계산 결과"));
                add(new TextField());
            }
        }

        class CenterPanel extends JPanel{
            public CenterPanel() {
                setLayout(new GridLayout(4,3, 5,5));



                for (int i = 1; i <= 9; i++){
                    add(new Button("${i}"));
                }

                add(new Button("+"));
                add(new Button("-"));
                add(new Button("*"));
                add(new Button("/"));

                add(new Button("계산"));
            }
        }

        class NorthPanel extends JPanel {
            public NorthPanel(){
                add(new Label("현재 수식"));
                add(new TextField());
            }
        }

        class MainFrame extends JFrame {
            public MainFrame() {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Container contentPane = getContentPane();

                contentPane.add(new SouthPanel(), BorderLayout.SOUTH);
                contentPane.add(new NorthPanel(), BorderLayout.NORTH);
                contentPane.add(new CenterPanel(), BorderLayout.CENTER);
            }
        }

        new MainFrame();
    }
}
