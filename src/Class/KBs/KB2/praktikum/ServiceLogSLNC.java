package Class.KBs.KB2.praktikum;

public class ServiceLogSLNC {
    private ServiceLogNodes head;

    public ServiceLogSLNC() {
        head = null;
    }

    public void insert(int computerId, String userId, Time startTime, Time endTime, int totalPayment){
        ServiceLogNodes temp = new ServiceLogNodes(new Service(computerId, userId, startTime, endTime, totalPayment));
        if (head == null){
            head = temp;
        } else {
            ServiceLogNodes help = head;
            while (help.link != null){
                help = help.link;
            }
            help.link = temp;
        }
    }

    public void show(){
        ServiceLogNodes help = head;
        while (help != null){
            System.out.println("ComputerId: "+help.data.getComputerId());
            System.out.println("UserId: "+help.data.getUserId());
            System.out.println("StartTime: "+help.data.getStartTime().getTime());
            System.out.println("EndTime: "+help.data.getEndTime().getTime());
            System.out.println("Duration: "+Helper.getDurationInString(help.data.getStartTime(), help.data.getEndTime()));
            System.out.println("PaymentTotal: Rp."+help.data.getTotalPayment()+",00");
            System.out.println();
            help = help.link;
        }
    }

    public int totalPayment(){
        ServiceLogNodes help = head;
        int total = 0;
        while (help != null){
            total += help.data.getTotalPayment();
            help = help.link;
        }
        return total;
    }
}
