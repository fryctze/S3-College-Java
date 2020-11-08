package Class.KBs.KB1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Fourth {
    public static void main(String[] args) {
        Random ran = new Random();

        ArrayList<Integer> stock = new ArrayList<>();
        for (int i = 0; i < args.length; i++)
            stock.add(i);

        ArrayList<Integer> number = new ArrayList<>();

        while (number.size() < args.length){
            int added = ran.nextInt(args.length);
            if (stock.contains(added)){
                number.add(Integer.parseInt(args[added]));
                stock.remove((Integer) added);
            }
        }

        System.out.println("Random args: \n"+number);
        Collections.sort(number);
        System.out.println("After sorting:");

        for (int i = 0; i < number.size(); i++)
            System.out.printf("%d. %d%n", i, number.get(i));

    }
}
