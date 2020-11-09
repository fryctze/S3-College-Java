package Class.Teory.z_8;

public class pt8Main {
    public static void main(String[] args) {
        //DLNC dlnc = new DLNC();
        DLC dlnc = new DLC();
        dlnc.addFirst(1);
        dlnc.addFirst(2);
        dlnc.addFirst(3);

        dlnc.addLast(4);
        dlnc.addLast(5);
        dlnc.addLast(6);

        dlnc.removeFirst();
        dlnc.removeLast();

        dlnc.show();

        System.out.println();

        dlnc.showBackward();
    }
}
