package Class.KBs.KB1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Third {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> stock = new ArrayList<>();

        for (int i = 0; i < args.length; i++)
            stock.add(i);

        while (name.size() < args.length){
            int added = random.nextInt(args.length);
            if (stock.contains(added)){
                name.add(args[added]);
                stock.remove((Integer) added);
            }
        }

        System.out.println("Random args of names:");
        System.out.println(name);

        Collections.sort(name);
        System.out.println("Sorted name:");

        for (String s:name){
            System.out.printf("%d. %s%n",name.indexOf(s)+1, s);
        }
    }
}
