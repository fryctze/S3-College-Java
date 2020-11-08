package Class.KBs.KB1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> question = new ArrayList<>(), answer = new ArrayList<>();
        ArrayList<Character> letter_answer = new ArrayList<>();
        question.add("Buah yang berwarna merah, bulat, dan terkenal sebagai buah yang memperkenalkan Isaac Newton tentang gravitasi?");
        question.add("Daging apa yang termasuk kategori daging paling sehat?");
        question.add("Sebutan apa bintang yang sangat padat dan berat tetapi berukuran lebih kecil dari bumi?");
        answer.add("APEL");
        answer.add("IKAN");
        answer.add("NEUTRON");

        Random random = new Random();

        System.out.println("Masukan -1 untuk keluar dan 1 untuk skip pertanyaan");
        int correct = 0;
        while (!question.isEmpty()) {
            int rand = random.nextInt(question.size());
            System.out.println(question.get(rand));
            String input = "";
            for (int j = 0; j < answer.get(rand).length(); j++)
                letter_answer.add(answer.get(rand).charAt(j));
            while (!letter_answer.isEmpty()){
                int rand2 = random.nextInt(letter_answer.size());
                System.out.print(letter_answer.get(rand2));
                letter_answer.remove(rand2);
            }
            System.out.println();
            while (!(input.equals("1") || input.equals("-1"))){
                input = in.next();
                if (input.equalsIgnoreCase(answer.get(rand))){
                    correct += 1;
                    System.out.println("benar");
                    break;
                } else if (input.equals("1") || input.equals("-1"))
                    System.out.println("Pertanyaan selanjutnya");
                else
                    System.out.println("salah, coba lagi");
            }
            question.remove(rand);
            answer.remove(rand);
            if (input.equals("-1"))
                break;
        }
        System.out.println("Semua pertanyaan telah diberikan,");
        System.out.println("Yang benar terjawab: "+correct+"/3");
    }
}
