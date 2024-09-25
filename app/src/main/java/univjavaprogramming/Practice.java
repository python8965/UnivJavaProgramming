package univjavaprogramming;

import java.util.Scanner;

public class Practice {


    public static void week1(){
        int number = 20231975;
        String name = " 박성준";
        System.out.println(number + name);

        int a = 3;
        double b = 10.123;

        System.out.println(String.format("%d + %.3f = %.3f", a, b, a+b));
        System.out.println(String.format("%d - %.3f = %.3f", a, b, a-b));
        System.out.println(String.format("%d * %.3f = %.5f", a, b, a*b));
        System.out.println(String.format("%d / %.3f = %.7f", a, b, a/b));

        //

        System.out.println(String.format("거스름돈 = %d", 50000 - 200 * 1 - 3000 * 2 - 4900 * 5));
        

        try (Scanner scanner = new Scanner(System.in)) {
            //

            int a0, b0;
            System.out.print("두 정수를 입력하세요>> ");
            a0 = scanner.nextInt();
            b0 = scanner.nextInt();
            
            System.out.println(String.format("%d + %d = %d", a0, b0, a0+b0));
            System.out.println(String.format("%d - %d = %d", a0, b0, a0-b0));
            System.out.println(String.format("%d * %d = %d", a0, b0, a0*b0));
            System.out.println(String.format("%d / %d = %d", a0, b0, a0/b0));
            System.out.println(String.format("%d %% %d = %d", a0, b0, a0%b0));
            //
            System.out.print("원화를 입력하세요(단위 원)>>");

            double won = scanner.nextDouble();
            double wontod = 1310.0;

            System.out.println(String.format("12000원은 $%.2f입니다.", won / wontod));
            
            //
            
            final double pi = 3.141592;
            
            System.out.print("구의 반지름 : ");
            
            double radius = scanner.nextDouble();
            double volume = (4.0 / 3.0) * pi * Math.pow(radius, 3);

            System.out.println(String.format("구의 부피 = %.2f", volume));
            
            //

            
        }
    }

    public static void week2(){
        try (Scanner scanner = new Scanner(System.in)) { 

            ///////1
            if (scanner.nextInt() % 2 == 0) {
                System.out.println("짝수입니다");
            } else {
                System.out.println("홀수입니다");
            }

            ///////3
            double height, m_height, weight, bmi;
            String result = "";

            System.out.printf("몸무게를 입력하세요.(kg) >> ");
            weight = scanner.nextDouble();

            System.out.printf("키를 입력하세요.(cm)>> ");
            height = scanner.nextDouble() / 100.0;

            m_height = height * height;
            bmi = weight / m_height;

            if (bmi < 19.0){
                result = "저체중";
            } else if (bmi < 23.0){
                result = "정상";
            } else if (bmi < 29.0) {
                result = "과체중";
            } else {
                result = "비만";
            }

            System.out.println(String.format("BMI 지수 : %.2f, 판정결과 : %s", bmi, result));

            ///////5

            System.out.print("연산식을 입력하세요 >> ");
            int op1 = scanner.nextInt();
            String op = scanner.next(); 
            int op2 = scanner.nextInt();

            switch (op) {
                case "+":
                    System.out.println(String.format("%d%s%d의 계산 결과는 %d", op1, op, op2, op1 + op2));
                    break;
                case "-":
                    System.out.println(String.format("%d%s%d의 계산 결과는 %d", op1, op, op2, op1 - op2));
                    break;
                case "*":
                    System.out.println(String.format("%d%s%d의 계산 결과는 %d", op1, op, op2, op1 * op2));
                    break;
                case "/":
                    System.out.println(String.format("%d%s%d의 계산 결과는 %d", op1, op, op2, op1 / op2));
                    break;
                default:
                    throw new AssertionError();
            }

            ////////6

            int sum = 0;
            for (int i = 1; i < 10+1; i++) {
                System.out.print(i + " ");
                sum += i;
            }
            System.out.println("\nsum = "+sum);

            ////////7

            for (int i = 1; i < 10+1; i++) {
                System.out.print(i + " ");
            }
            System.out.println("");
            for (int i = 1; i < 10+1; i++) {
                System.out.println(i);
            }

            ////////8
            System.out.print("건너뛸 숫자를 입력하세요 (1 ~ 10 사이) >> ");
            int skip = scanner.nextInt();

            for (int i = 1; i < 10+1; i++) {
                if (i == skip)
                    continue;
                System.out.print(i + " ");
            }

            System.out.println("");

            ////////9

            for (;;) {
                System.out.print("숫자를 입력하세요: ");
                int input = scanner.nextInt();
                System.out.println("입력한 숫자 : " + input);

                if (input == 10)
                    break;
            }
            ////////10
            for (int j = 1; j < 10; j++) {
                for (int i = 9; i > 1; i--) {

                    System.out.printf("%-15s", String.format("%d X %d = %d",i ,j , (i*j)));

                    
                }
                System.out.println();
            }
        }
    }

    public static int[] generateRandomIntArray(int length){
        var randomArray = new int[length];

        for (int i = 0; i < length; i++) {
            randomArray[i] = (int)(Math.random()*100 + 1);
        }

        return randomArray;
    }

    public static void week3(){
        try (Scanner scanner = new Scanner(System.in)) { 
            var array = new int[]{1, 2, 3, 4, 5};

            for (int i = 0; i < array.length; i++) {
                System.out.printf("인덱스 %d: %d\n", i, array[i]);
            }

            String course [] = { "객체지향", "프로그래밍", "알고리즘", "자료구조", "컴퓨터구조" };
            char score [] = {'A', 'B', 'B', 'C', 'D'};
        
            ////////////////////

            String input = scanner.next();
            while (!input.equals("종료")){
                for (int i=0;i < course.length;i++){
                    if (input.equals(course[i])){
                        System.out.printf("%s의 학점은 %c\n", course[i], score[i]);
                        break;
                    }

                    if (i == course.length-1){
                        System.out.println("존재하지 않는 강의입니다.");
                    }
                }

                input = scanner.next();
            }

            //////////////////////////////

            int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; // 환산할 돈의 종류
            int[] amount = new int[unit.length];

            System.out.print("금액을 입력하세요 >> ");
            int value = scanner.nextInt();

            for (int i = 0; i < unit.length; i++) { 
                // unit이 내림차순 정렬되어있다고 가정
                int p = value / unit[i];

                amount[i] = p;
                value -= p * unit[i];
            }

            //출력코드

            //////////////////////////////

            var randomArray = generateRandomIntArray(10);

            System.out.println("생성된 배열:");

            for (int i : randomArray) {
                System.out.printf("%d ", i);
            }

            System.out.println();

            /////////////////////

            int[] arr = {4, 9, 39, 30, 10, 43};

            for (int i = 0; i < arr.length-1; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[j] > arr[i]){
                        var tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp; 
                    }
                }
            }

            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.printf("%d ", i);
        }


    }
    
}
