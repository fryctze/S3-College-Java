package Class.Praktikum;

import java.util.Random;
import java.util.Scanner;

public class z_1_2109 {
    /*  s – formats strings
        d – formats decimal integers
        f – formats the floating-point numbers
        t– formats date/time values */
    private void print(){
        System.out.println("This is text");
        System.out.print("print usual\n");
        System.out.printf("Hello %s!%n", "World");
    }

    private void first() {
        String myName = "Hi there, my name is Fikry Farenza";
        System.out.println(myName);
    }

    private void second(){
        String firstName = "Fikry";
        String lastName = "Farenza";
        System.out.println("Hi there, you can call me "+lastName+", "+firstName);
    }

    private void third(){
        Scanner scanner = new Scanner(System.in);
        String myName = scanner.nextLine();
        System.out.printf("Welcome, %s",myName);
    }

    private void forth(){
        Scanner scanner = new Scanner(System.in);
        double floor= scanner.nextDouble();
        double height= scanner.nextDouble();
        double area = (floor * height) / 2;
        System.out.println("The area of the triangle is "+area);
    }

    // Scanner.next()and Scanner.nextLine().
    // Please write a program to understand the difference between those functions.
    private void fifth(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input text with spaces\n1 ");
        String textWithLine = scanner.nextLine();
        System.out.print("2 ");
        String textNoLine = scanner.next();
        System.out.println("Next with line is = "+textWithLine+"\nNext without line is = "+textNoLine);
    }

    // Scanner doesn’t have a spesific function to get input for character variable
    private void sixth(){
        Scanner scanner = new Scanner(System.in);
        char name = scanner.next().charAt(0);
        System.out.println("The first character you input is "+name);
    }

    /*
    * By using Random Class, please write a program that will generate specific random numbers
    * like 3, 6, 9, 12, 15, 18, 21, 24, 27
    */
    private void seventh(){
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            int intRandom = random.nextInt(27)+1;
            while(intRandom % 3 != 0){
                intRandom = random.nextInt(27)+1;
            }
            System.out.println(intRandom);
        }
    }

    //Now it’s a little bit different, by using Math.random(),
    //please write a program that will generate specific
    // random numbers like 1, 4, 7, 10, 13, 16, 19, 22, 26, 30.
    // 7 times +3 at 22-26 THEN +4
    private void eight(){
        for (int i = 0; i < 9; i++) {
            int rand = (int)((Math.random() + 0.1) * 10) + 3;
            while(rand % 3 != 0){
                rand = (int)((Math.random() + 0.1) * 10) + 3;
                System.out.println("loop"+rand);
            }
            System.out.println(rand+1);
        }
    }

    public static void main(String[] args) {
        z_1_2109 me = new z_1_2109();
        me.fifth();me.second();me.third();me.forth();me.fifth();me.sixth();me.seventh();me.eight();
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), loop = 1;
        while (loop == 1){
            switch (a) {
                case 1 -> me.first();
                case 2 -> me.second();
                case 3 -> me.third();
                case 4 -> me.forth();
                case 5 -> me.fifth();
                case 6 -> me.sixth();
                case 7 -> me.seventh();
                case 8 -> me.eight();
                default -> loop = 0;
            }
        }
    }
}
