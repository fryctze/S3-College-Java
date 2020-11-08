package Class.Praktikum;

import java.util.Scanner;

/**
 * JAVA Development Environment = JRE, (JDK, IntelliJ IDEA (code editor))->developer
 * JAVA = Pemrograman independent => platform-independent
 *      karena tidak bergantung dengan plaform apapun -> windows, linux, solaris
 * unggul karena => Java di compile dlm lingkunan java itu sendiri
 *     Kalau tersedia, maka aplikasi java dapat berjalan
 * source -> compile w/JDK -> become Java code -> java compiler(in JDK) -> executable Java Bytecode => exec with JRE (java virtual machine)
 *
 * Converting between data types in java
 *  Promotion -> java => byte->sort->int->long || int->float
 *      smaller type to larger type => integral value TO floating point type
 *          Long var=1L || double d = 4 // become 4 double
 *  Casting -> manual
 *      larger type to smaller type => floating point type TO integral value
 *      (int) 1234L || (int) 32.243
 *  Parsing -> only string type => String->int,double
 *      string value to numeric
 *      Integer.parseInt(String) || Double.parseDouble(String)
 *
 * Structure => project -> our code inside src
 * each class to be runnable must have function main public static void main (String[] args)
 */

public class z_2_2809 {

    private static void demo(){
        float f = 3.4f;
        long a = 1234567890123456789L;
        double z = 13D/2D; // result is 6 => change float/double before calculate
        // use double instead float => hindari kesalahan presisi, koma lebih baik dari float
        String asdf = "asd";
        Double doube = 3.4;
        System.out.println("doube = " + doube);
        System.out.print(asdf);
        System.out.printf("%n %8.4f",z);// format
    }

    /*
     * compareTo() method has 3 different integer outputs, what is it ?
     * 0, <0(negatif)  , >0(positif)
     *
     * And in what condition those values will be returned ?
     * 0 Jika string sama dengan string yang sedang dibandingkan
     * <0 Jika urutan leksikografis karakter kurang dari string yang sedang dibandingkan
     * >0 Jika urutan leksikografis karakter lebih dari string yang sedang dibandingkan
     * */
    private void zero(){
        System.out.println("sama "+"data".compareTo("data"));
        System.out.println("<0 "+"dat9".compareTo("data"));
        System.out.println("<0 "+"dat".compareTo("data"));
        System.out.println(">0 "+"datc".compareTo("data"));
        System.out.println(">0 "+"data ".compareTo("data"));
    }

    /*
    * Please create a simple program to analyze a string inputed by user;
    * wether it’s a vocal or consonants then print the sum of each component.
    * */
    private void first(){

    }

    /*
    * Please create a simple program to analyze a string wether it’s a palindrom or not.*/
    private void second(){

    }

    /*
    * Please create a simple program to convert a word into van ophuysen orthography.
    * This unique words will have these specialty, like:
    * ⌁Using the letter ‘i’ instead of ‘y’ (soerabaia)⌁Using the letter ‘oe’ instead of ‘u’ (doeloe)
    * ⌁Using the letter ‘tj’ instead of ‘c’ (pertjaia, tjara)
    * ⌁Using the letter ‘ch’ instad of ‘kh’ (choesoes)*/
    private void third(){

    }

    /*
    * Please create a program to anayze how many word in a string inputed by user. */
    private void forth(){

    }

    /*
    * Please create a program to present a series of number based on these conditions;
    * start with xwith range of yfor z numbers*/
    private void fifth(){

    }

    /*
    * Please create a program to calculate total groceries of a customer based on these datas;
    * 110 indomie 2,500,-(disc 0%)
    * 112 rice 50,000,-(disc 15%)
    * 114 cooking oil 25,000,-(disc 10%)
    * 116 eggs 30,000,-(disc 5%)*/
    private void sixth(){

    }

    /*
    * Please create a program to analyze an email.
    * The program will separate the user accounts and the mail domain used.*/
    private void seventh(){

    }

    /*
    * Please create a program to print the lucky number based on user birthdate information.
    * The program will sum dd + mm + yyyy and split the digits to sum all the numbers
    * until it get the final digit (0-9).*/
    private void eight(){

    }

    /*
    * Please create a simple game “guessing the number”.
    * The program will randomly create a number between (1-100) secretly.
    * User will need to to guess the number until it’s correct.
    * The program will give clue > or < until the condition is meet.
    * The program will show how many guess user made in game.*/
    private void ninth(){

    }

    /*
    * Please create a simple captcha contains 2 numbers and 1 basic math operators.
    * Program will analyze the user input wether it’s correct or otherwise.*/
    private void tenth(){

    }




    public static void main(String[] args) {
        String f = "asd", bs="asd";
        System.out.println("asd"=="asd");
        System.out.println(f==bs);
    }
}
