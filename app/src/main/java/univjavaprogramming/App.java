/*
 * This source file was generated by the Gradle 'init' task
 */
package univjavaprogramming;



import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.text.Document;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.List;

import java.net.*;
import java.util.*;

public class App {
    

    public static void main(String[] args) {
        Challenge8();
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

    class Helper {
        public static int randomRange(int start, int end){
            return (int)(Math.random() * (end - start - 1)) + start;
        }
    }

    public static void Challenge2(){


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
        enum TileType {
            Empty,
            Cookie,
            PacMan
        }

        class Tile {
            final TileType type;

            Tile(TileType type) {
                this.type = type;
            }

            public char ToIcon(){
                return switch (type) {
                    case Empty -> '-';
                    case Cookie -> 'C';
                    case PacMan -> 'P';
                };
            }
        }

        interface IMap{
            Tile[][] getMapData();

            int getWidth();
            int getHeight();
        }

        record Position (int x,int y){

        }

        abstract class GameObject{
            protected Position position;

            GameObject(Position position) {
                this.position = position;
            }

            abstract TileType getTileType();

            void Tick(){

            }
        }

        abstract class MoveAble extends GameObject{
            MoveAble(Position position) {
                super(position);
            }

            abstract public void Move(int dx, int dy, IMap map);
        }

        class PacMan extends MoveAble{

            PacMan(Position position) {
                super(position);
            }

            @Override
            TileType getTileType() {
                return TileType.PacMan;
            }

            @Override
            public void Move(int dx, int dy ,IMap map) {
                final var width = map.getWidth();
                final var height = map.getHeight();

                var movedX = dx + position.x;
                var movedY = dy + position.y;

                if (movedX < 0 || movedX >= width || movedY < 0 || movedY >= height){
                    return;
                }

                this.position = new Position(movedX, movedY);
            }
        }

        class Cookie extends GameObject{
            int count = 0;
            Cookie(Position position) {
                super(position);
            }

            @Override
            TileType getTileType() {
                return TileType.Cookie;
            }

            @Override
            void Tick() {
                super.Tick();

                count += 1;

                if (count == 3){
                    var dx = Helper.randomRange(-1, 1);

                    var dy = 0;
                    if (dx == 0){
                        dy = Helper.randomRange(-1, 1);
                    }

                    position = new Position(position.x + dx, position.y + dy);


                    count = 0;
                }
            }
        }

        class Map implements IMap{
            Tile[][] mapData;

            int width;
            int height;

            public Map(int width, int height) {
                mapData = new Tile[height][width];
                this.width = width;
                this.height = height;
            }

            @Override
            public Tile[][] getMapData() {
                return mapData;
            }

            @Override
            public int getWidth() {
                return this.width;
            }

            @Override
            public int getHeight() {
                return this.height;
            }

            public void removeAt(int x, int y) {
                mapData[y][x] = null;
            }

            public Tile getAt(int x, int y) {
                var data= mapData[y][x];
                if (data== null){
                    return new Tile(TileType.Empty);
                }

                return data;
            }

            public void setAt(int x, int y, Tile tile) {
                mapData[y][x] = tile;
            }
        }

        class Game{
            Map map;
            List<GameObject> Objects;

            int cookieCount;

            public Game(Map map){
                this.map = map;
                Objects = new ArrayList<>();

                var pacMan = new PacMan(new Position(0,0));
                this.map.setAt(0,0 , new Tile(TileType.PacMan));

                Objects.add(pacMan);

                List<Position> positions = new ArrayList<Position>();

                this.cookieCount = Helper.randomRange(2, 5);

                for (int i = 0; i < this.cookieCount; i++){
                    var pos = new Position(Helper.randomRange(0, map.getWidth()),Helper.randomRange(0, map.getHeight()));

                    while (positions.contains(pos)) {
                        pos = new Position(Helper.randomRange(0, map.getWidth()), Helper.randomRange(0, map.getHeight()));
                    }

                    positions.add(pos);


                    Objects.add(new Cookie(pos));
                    this.map.setAt(pos.x, pos.y, new Tile(TileType.Cookie));
                }
            }

            public void input(int dx, int dy) {
                for (var object: Objects){
                    if (object instanceof MoveAble){ //
                        var preMovePosition = ((MoveAble) object).position;

                        ((MoveAble) object).Move(dx, dy, map);

                        var endMovePosition = ((MoveAble) object).position;



                        if (!preMovePosition.equals(endMovePosition)){
                            map.removeAt(preMovePosition.x, preMovePosition.y);
                            map.setAt(endMovePosition.x, endMovePosition.y, new Tile(object.getTileType()));
                        }
                    }
                }

                for (var object: Objects){
                    object.Tick();
                }
            }

            public void print(){
                var height = map.getHeight();
                var width = map.getWidth();

                for (int y = 0; y < height; y++){
                    for (int x = 0; x < width; x++){
                        System.out.printf("%c",map.getAt(x, y).ToIcon());

                    }
                    System.out.println();
                }
            }


        }

        Scanner scanner = new Scanner(System.in);

        Map map = new Map(20, 20);

        Game game = new Game(map);

        game.print();

        loop: while (game.cookieCount != 0){
            var in= scanner.next();

            int dx = 0;
            int dy = 0;

            switch (in){
                case "w":
                    dx = 0;
                    dy = -1;
                    break;
                case "s":
                    dx = 0;
                    dy = 1;
                    break;
                case "a":
                    dx = -1;
                    dy = 0;
                    break;
                case "d":
                    dx = 1;
                    dy = 0;
                    break;
                default:
                    break loop;
            }

            game.input(dx, dy);
            game.print();


        }


    }

    public static void Challenge5(){
        class SouthPanel extends JPanel{
            public SouthPanel() {
                add(new JLabel("계산 결과")).setForeground(Color.WHITE);;
                add(new JTextField());

                setBackground(Color.DARK_GRAY);
            }
        }

        class CenterPanel extends JPanel{
            public CenterPanel() {
                setLayout(new GridLayout(4,3, 5,5));



                for (int i = 0; i <= 9; i++){
                    add(new JButton("" + i));
                }

                add(new JButton("CE"));
                add(new JButton("계산"));

                add(new JButton("+")).setBackground(Color.YELLOW);;
                add(new JButton("-")).setBackground(Color.YELLOW);;
                add(new JButton("*")).setBackground(Color.YELLOW);;
                add(new JButton("/")).setBackground(Color.YELLOW);;


            }
        }

        class NorthPanel extends JPanel {
            public NorthPanel(){
                add(new JLabel("현재 수식"));
                add(new TextField());
                setBackground(Color.GRAY);

            }
        }

        class MainFrame extends JFrame {
            public MainFrame() {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Container contentPane = getContentPane();

                contentPane.add(new SouthPanel(), BorderLayout.SOUTH);
                contentPane.add(new NorthPanel(), BorderLayout.NORTH);
                contentPane.add(new CenterPanel(), BorderLayout.CENTER);

                setSize(300, 300);

                setVisible(true);
            }
        }

        new MainFrame();
    }


    public static void Challenge6(){
        class SouthPanel extends JPanel{
            JTextField resultDocument;

            public SouthPanel() {


                add(new JLabel("계산 결과")).setForeground(Color.WHITE);


                var c = new JTextField();
                c.setColumns(15);
                c.setFocusable(false);
                resultDocument = c;
                add(c);

                setBackground(Color.DARK_GRAY);
            }
        }

        class CenterPanel extends JPanel{
            JTextField resultField;
            JTextField inputField;

            public CenterPanel() {
                setLayout(new GridLayout(4,3, 5,5));



                for (int i = 0; i <= 9; i++){
                    var btn = new JButton("" + i);

                    btn.addActionListener(
                            new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    JButton b = (JButton)e.getSource();

                                    int i = Integer.parseInt(b.getText());
                                    inputField.setText(inputField.getText() + i);
                                }
                            }
                    );

                    add(btn);
                }

                var cebutton = new JButton("CE");

                cebutton.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                inputField.setText("");
                            }
                        }
                );

                add(cebutton);

                var calcbutton=new JButton("계산");



                calcbutton.addActionListener(
                        new ActionListener() {
                            int getOrder(char c) {
                                switch (c) {
                                    case '+':
                                    case '-':
                                        return 0;
                                    case '*':
                                    case '/':
                                        return 1;
                                    default:
                                        return -1;
                                }
                            }

                            boolean isDigit(char c){
                                return getOrder(c) == -1;
                            }

                            public void actionPerformed(ActionEvent e) {

                                //후위 표기법 파트

                                var text = inputField.getText();
                                var stack = new Stack<Character>();


                                List<Character> postfixText = new ArrayList<Character>();

                                for (var c : text.toCharArray()){

                                    if (!isDigit(c)){
                                        if (stack.size() != 0){

                                            var token = stack.peek();

                                            if (getOrder(c) <= getOrder(token)){
                                                postfixText.add(stack.pop());
                                                stack.add(c);
                                                continue;
                                            }
                                        }

                                        stack.add(c);
                                    }
                                    else {
                                        postfixText.add(c);
                                    }
                                }

                                while (stack.size() != 0){
                                    postfixText.add(stack.pop());
                                }

                                System.out.println(postfixText.toString());

                                // 계산 파트
                                Stack<Integer> istack = new Stack<>();

                                try{

                                    for (var c: postfixText){
                                        if (isDigit(c)) {

                                            int i =Integer.parseInt(Character.toString(c));


                                            istack.push(i);
                                        } else {
                                            int op2 = istack.pop();
                                            int op1 = istack.pop();

                                            switch (c) {
                                                case '+':
                                                    istack.push(op1 + op2);
                                                    break;
                                                case '-':
                                                    istack.push(op1 - op2);
                                                    break;
                                                case '/':
                                                    istack.push(op1 / op2);
                                                    break;
                                                case '*':
                                                    istack.push(op1 * op2);
                                                    break;
                                            }
                                        }
                                    }

                                    if (istack.size() != 1){
                                        System.out.println(istack.toString());
                                        throw new Exception();
                                    }

                                    resultField.setText(istack.pop().toString());
                                }catch (Exception error){
                                    resultField.setText("에러: " + error.getMessage());
                                }
                            }
                        }
                );

                add(calcbutton);



                String[] s = {"+", "-", "*", "/"};

                for (var token : s){
                    var btn = new JButton(token);
                    btn.addActionListener(
                            new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    JButton b = (JButton)e.getSource();

                                    String i = b.getText();
                                    inputField.setText(inputField.getText() + i);
                                }
                            }
                    );
                    btn.setBackground(Color.YELLOW);

                    add(btn);
                }

            }
        }

        class NorthPanel extends JPanel {
            JTextField inputField;

            public NorthPanel(){
                add(new JLabel("현재 수식"));

                var c= new JTextField();
                add(c);
                c.setColumns(15);
                inputField = c;
                setBackground(Color.GRAY);

            }
        }

        class MainFrame extends JFrame {
            public MainFrame() {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Container contentPane = getContentPane();

                var southPanel = new SouthPanel();

                var northPanel = new NorthPanel();

                contentPane.add(southPanel, BorderLayout.SOUTH);

                contentPane.add(northPanel, BorderLayout.NORTH);

                var centerPanel = new CenterPanel();
                centerPanel.resultField = southPanel.resultDocument;
                centerPanel.inputField = northPanel.inputField;
                contentPane.add(centerPanel, BorderLayout.CENTER);

                setSize(300, 300);

                setVisible(true);
            }
        }

        new MainFrame();
    }

    public static void Challenge7(){


        class MainFrame extends JFrame {
            class TitlePanel extends JPanel {
                public TitlePanel() {
                    var label = new JLabel("Lorem Picsum");
                    label.setForeground(Color.MAGENTA);
                    add(label);
                }
            }

            class MainPanel extends JPanel {
                public Image image;
                int imageHeight = 200;
                int imageWidth = 200;

                public void paintComponent(Graphics g){
                    for (int i = 0; i < 4; i++){
                        for (int j = 0; j < 4; j++){
                            g.drawImage(image, i * (imageWidth + 10), j * (imageHeight + 10), this);
                        }
                    }

                    var c = g.getClipBounds();



                    g.drawString("20231975 박성준", c.width /2, c.height/2);


                }
            }

            public MainFrame(){
                var mainPanel = new MainPanel();

                try {
                    URL url = new URL("https://picsum.photos/200");

                    Image image = ImageIO.read(url);

                    System.out.print(image.toString());

                    mainPanel.image = image;
                } catch (Exception e){
                    //exit
                    System.out.println(e.getMessage());

                }


                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Container contentPane = getContentPane();

                var titlePanel = new TitlePanel();



                contentPane.add(mainPanel, BorderLayout.CENTER);

                contentPane.add(titlePanel, BorderLayout.SOUTH);

                setSize(300, 300);

                setVisible(true);
            }




        }

        new MainFrame();
    }

    public static void Challenge8() {
        class MainFrame extends JFrame {
            private JLabel resultLabel = new JLabel("계산 결과 출력");

            public MainFrame(){
                super("다이얼로그 만들기");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container c = getContentPane();

                c.setLayout(new FlowLayout());
                JButton btn  = new JButton("calculate");
                btn.addActionListener(new MyActionListener());
                c.add(btn);

                resultLabel.setOpaque(true);
                resultLabel.setBackground(Color.WHITE);
                c.add(resultLabel);

                setSize(250,200);
                setVisible(true);
            }

            public void SetResultLabel(String string) {
                resultLabel.setText(string);
            }

            class MyActionListener implements ActionListener{
                private CalcDialog dialog;
                public MyActionListener() {
                    dialog = new CalcDialog(MainFrame.this);
                    dialog.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowDeactivated(WindowEvent e) {
                            int number = ((CalcDialog)e.getSource()).getResult();
                            MainFrame.this.resultLabel.setText(Integer.toString(number));
                        }
                        
                    });
                }

                public void actionPerformed(ActionEvent e){
                    dialog.setVisible(true);
                }
            }

            class CalcDialog extends JDialog{
                private int sum=0;
                private JTextField a = new JTextField(10);
                private JTextField b = new JTextField(10);
                private JButton mulBtn = new JButton("   Multiply   ");

                public CalcDialog(JFrame owner){
                    super(owner,"Calculation Dialog", true);
                    setLayout(new FlowLayout());

                    add (new JLabel("두 수를 곱합니다."));
                    add(a);
                    add(b);

                    mulBtn.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                sum = Integer.parseInt( a.getText()) * Integer.parseInt(b.getText());
                                setVisible(false);
                            } catch (NumberFormatException ee) {
                                sum = 0;
                                System.err.println("please Enter number");
                            } 
                        }
                        
                    });

                    

                    add(mulBtn);
                    setSize(350, 400);
                }

                public int getResult() {
                    return sum;
                }
            }
        }

        new MainFrame();
    }
}
