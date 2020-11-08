package Class.Praktikum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class z_4_2809 {
    static Scanner in = new Scanner(System.in);
    private static boolean foundCharInString(char character, String string){
        for (int i = 0; i < string.length(); i++) {
            if (Character.toLowerCase(character) == Character.toLowerCase(string.charAt(i)))
                return true;
        }
        return false;
    }

    private static String removeDuplicatedCharacter(String string){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++)
            if (!result.toString().contains(String.valueOf(string.charAt(i))))
                result.append(string.charAt(i));
        return result.toString();
    }

    // traversing array -> read all array
    // iterator -> forward
    // list iterator -> back n forward *Pemanggilan pertama = false -> karena menunjuk ke index 0*
    // wrapper class Boolean, String, Integer
    // array can't use wrapper class (only primitive)

    /*Please create simple program to extract values in args param in main function
    into a variable array of String called argCopies.*/
    private void first(String[] args){ // array
        String[] argCopies = args;
        for (String s:argCopies) {
            System.out.println(s);
        }
    }

    /*Please create program that will save all the string that inputed by user (with maximum data of 100s.
    Then will display all the strings desc from the last string (not last index)*/
    private void second(){
        Scanner in = new Scanner(System.in);
        String[] words = new String[100];
        int counter = 0;
        String input ;
        while( counter < 100){
            input = in.nextLine();
            if (input.equals("-1"))
                break;
            words[counter] = input;
            counter++;
        }
        for (int i = counter-1; i > -1 ; i--) {
            System.out.println(words[i]);
        }
    }

    /*Let’s modify our guessing number game; this time instead of using number we will use words.
    Create 10 words in a single dimensional array. The game will choose it randomly as the question for the player to guess;
    don’t forget to create a clue for each word so the game will be more intuitive to be played.*/
    private void third(){

    }

    /*Let’s create another simple game called hunting the ghost card. The game will be played in this situation;
    the computer will have its final card, and now it’s computer’s turn to pick a card from player;
    the player will have 2 cards left; The player need to choose where tto put the card.
    The computer will choose it randomly, if the computer get the ghost card, you loose. If not,
    the situation wil be reversed. The game will be played until one of the player left only with the ghost card.*/
    private void forth(){

    }

    /*Please create a program that will eliminate any duplicate character in a string input by user.*/
    static private void fifth(){
        String string = in.next();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++)
            if (!result.toString().contains(String.valueOf(string.charAt(i))))
                result.append(string.charAt(i));
        System.out.println(result.toString());
    }

    /*Please create an object of Arraylists named students; fill it with 10 student names;
    print all the values using foreach, iterator object, and listIterator object.*/
    private void sixth(){
        ArrayList<String> students = new ArrayList<>();
        Iterator<String> iterator = students.iterator();
        students.add("Somwan");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /*Please create a simple program called moneytory to check our monthly expenses.
    The program will usedan Arraylists object that will save string in this format;
    Every cash in will be recorded as “CAIN NOMINAL” (CAIN 50000)
    Every cash out will be recorded as “COUT NOMINAL” (COUT 50000)
    The program will give the total of cash in and out that have been recorded by the application.*/
    private void seventh(){
        ArrayList<String> records = new ArrayList<>();
        records.add("CAIN 1000000");
        records.add("COUT 500000");

        int cashin = 0;
        int cashout = 0;

        for (String n:records){
            String code = "", nominal = "";
            code = toString().substring(0,4);
            nominal = toString().substring(5);
            if (code.equals("CAIN")){
                cashin += 1000000;
            } else if (code.equals("COUT")){
                cashout += 500000;
            }
        }
        System.out.println("Cashin = "+cashin+"\nCashout = "+cashout);
    }

    /*Please create a program called phonebook;
    the Application will record name and users phonenumber in one single ArrayLists object;
    We can search someone phonenumber by using name. The result of the app can more than 1 record.*/
    private void eight(){
        ArrayList<String> records = new ArrayList<>();
        records.add("budi a1234");
        records.add("ana 4234");

        String search = in.nextLine().toLowerCase();
        // searching...
        // take name
        // compare
        // if found, then display it

        for (String name:records){
            if (name.contains(search))
                System.out.println(name);
        }

    }

    /*Please create a program to generate 2 cards randomly.
    These cards will be saved in one single Arraylists object called cards.
    The program will print the two cards for the user.*/
    private void ninth(){
    }

    /**
     * hangman
     * 5 times failed then u lose
     * 10 random words
     * if correct char, then reveal char and it's current position
     * selasa <- in=a then ___a_a
     * input = char
     */
    static private void tenth(){
        String[] words = {"TISSUE","SWORD","SCISSOR","BAZOOKA","FLAMETHROWER","PILLOW","TISSUE","AXE","ROPE","PENCIL"};
        String opening =
                "Welcome to hangman game, \n" +
                        "Please guess the tools you can use to kill someone.\n" +
                        "You'll be hanged if you are wrong 5 times.",
                wrong = "You're WRONG!!",
                correct = "Yeah, that's correct",
                lose = "Finally, you lose and let us go to the guillotine",
                win = "yeah yeah you won, congratulations";
        int lives = 5;

        System.out.println(opening);
        String key = words[(int) (Math.random()*10)];
        ArrayList<Character> correctedAnswer = new ArrayList<>();
        while (lives > 0){
            System.out.println("lives = "+lives);

            if (!correctedAnswer.isEmpty()) {
                if (correctedAnswer.size() == removeDuplicatedCharacter(key).length()) {
                    System.out.println(key + "\n" + win);
                    break;
                } else
                    for (int i = 0; i < key.length(); i++)
                        if (foundCharInString(key.charAt(i), correctedAnswer.toString()))
                            System.out.print(key.length() - 1 != i ? key.charAt(i) : key.charAt(i) + "\n");
                        else System.out.print(key.length() - 1 != i ? "_" : "_\n");
            }else
                for (int i = 0; i < key.length(); i++)
                    System.out.print(key.length() - 1 != i ? "_" : "_\n");

            char answer = in.next().charAt(0);

            if (!foundCharInString(answer,correctedAnswer.toString()) && foundCharInString(answer, key)){
                System.out.println(correct);
                correctedAnswer.add(answer);
            } else {
                System.out.println(wrong);
                lives -= 1;
            }

            if (lives == 0) System.out.println(lose);
        }
    }

    // random, array/list,
    public static void main(String[] args) {
        /*Class.Praktikum.z_4_2809 me = new Class.Praktikum.z_4_2809();
        me.eight();*/
        fifth();
    }
}
