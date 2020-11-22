package Class.KBs.KB2.praktikum;

public class Main {
    static OnGoingService[] onGoingService = new OnGoingService[5];// Initialize computer slot for on going service later
    static LinearQueue queue = new LinearQueue(10);
    static int[] computersDuration = {0, 0, 0, 0, 0,}; // save most used
    static ServiceLogSLNC serviceLog = new ServiceLogSLNC();

    public static void main(String[] args) {
        // normal
        addService("Water", new Time(2020, 2, 12, 2, 2, 1));
        addService("Sand", new Time(2020, 2, 12, 2, 2, 1));
        addService("Dark", new Time(2020, 2, 12, 2, 2, 1));
        addService("Fire", new Time(2020, 2, 12, 2, 2, 1));
        addService("Earth", new Time(2020, 2, 12, 2, 2, 1));
        // queue
        addService("Light", new Time(2020, 2, 12, 2, 2, 1));
        addService("Poison", new Time(2020, 2, 12, 2, 2, 1));
        addService("Bolt", new Time(2020, 2, 12, 2, 2, 1));
        removeQueueUser("Bolt");
        getOngoingService();

        System.out.println();
        removeQueueUser("iwquheqiwuehqwiuehqwiuehoqwiuehqwiue");
        endService("Fire", new Time(2020, 2, 12, 4, 0, 0));
        endService("Earth", new Time(2020, 2, 12, 8, 2, 1));

        totalPayment();

        endService("Sand", new Time(2020, 2, 12, 2, 2, 10));

        totalPayment();

        endService("Water", new Time(2020, 2, 12, 2, 2, 2));

        getOngoingService();
        serviceLog.show();

        analyzeHigh();

        printDaily();
    }

    private static void addService(String userId, Time startTime){
        int computerId = -1; // -1 means it full
        for (int i = 0; i< onGoingService.length; i++){
            if (onGoingService[i] == null){
                computerId = i;
                break;
            }
        }

        if (computerId != -1){
            if (Helper.monthDay[startTime.month-1] > startTime.month) { //if (Helper.monthDay[startTime.month-1] <= startTime.month){
                onGoingService[computerId] = new OnGoingService(userId, startTime);
                System.out.println(onGoingService[computerId].getUserId() + " Berhasil ditambahkan ke slot komputer " +computerId+ " pada waktu "+ onGoingService[computerId].getStartTime().getTime());
            } else {
                System.out.println("Validasi error: Dengan input:"+startTime.month+", padahal bulan ke-"+startTime.month+" harinya hanya berjumlah "+Helper.monthDay[startTime.month-1]);
            }
        } else {
            System.out.println("Slot komputer penuh, "+userId+" akan kami daftarkan nanti jika ada slot kosong, tapi tetap sesuai dengan antrian Anda");
            queue.enqueue(new OnGoingService(userId, startTime));
        }

    }

    private static void endService(String userId, Time endTime){
        int found = -1;
        for (int i = 0; i< onGoingService.length; i++){
            if (onGoingService[i] != null){
                if (onGoingService[i].getUserId().equals(userId)){
                    found = i;
                    break;
                }
            }
        }

        if (found != -1){
            OnGoingService data = onGoingService[found];
            if (Helper.realDurationInSecond(data.getStartTime(), endTime) >= 0){
                serviceLog.insert(
                        found,
                        data.getUserId(),
                        data.getStartTime(),
                        endTime,
                        countPayment(data.getStartTime(), endTime));

                computersDuration[found] = Helper.realDurationInSecond(data.getStartTime(), endTime);
                System.out.println(data.getUserId() + " Telah berhenti menggunakan komputer "+found+" pada "+endTime.getTime()+ " dengan total pembayaran Rp."+countPayment(data.getStartTime(), endTime)+",00");
                onGoingService[found] = null;

                if (queue.size > 0){
                    OnGoingService output = queue.dequeue();
                    if (output != null){
                        addService(output.getUserId(), output.getStartTime());
                    }
                }

            } else {
                System.out.println("End service gagal: Waktu startTime harus lebih dari endTime, sedangkan selisih detik saat ini "+Helper.realDurationInSecond(data.getStartTime(), endTime));
            }
        } else {
            System.out.println("End service gagal: Tidak ditemukan userId yang sedang menggunakan pc");
        }
    }

    private static void analyzeHigh(){
        int first=0, second=0, third=0;
        int iFirst=-1, iSecond=-1, iThird=-1;
        for (int i = 0; i < computersDuration.length; i++) {
            if (computersDuration[i] > first) {
                third = second;
                second = first;
                first = computersDuration[i];

                iThird = iSecond;
                iSecond = iFirst;
                iFirst = i;
            } else if (computersDuration[i] > second) {
                third = second;
                second = computersDuration[i];

                iThird = iSecond;
                iSecond = i;
            } else if (computersDuration[i] > third){
                third = computersDuration[i];
                iThird = i;
            }
        }

        if (iFirst != -1)
            System.out.println("RANKING KOMPUTER YANG PALING SERING DIGUNAKAN\n1. ComputerId: "+iFirst);
        else
            System.out.println("Tidak ditemukan duration terlama!\nKemungkinan komputer masih digunakan sehingga tidak ditemukan perhitungan timestamp");
        if (iSecond != -1)
            System.out.println("2. ComputerId: "+iSecond);
        if (iThird != -1)
            System.out.println("3. ComputerId: "+iThird);
        System.out.println();
    }

    private static void getOngoingService(){
        System.out.println("\nDaftar Komputer yang saat ini digunakan");
        for (int i = 0; i < onGoingService.length; i++) {
            if (onGoingService[i] != null){
                System.out.println(onGoingService[i].getUserId()+" "+onGoingService[i].getStartTime().getTime());
            }
        }
        System.out.println();
    }

    private static int countPayment(Time startTime, Time endTime){
        return 150 * Helper.getProfitableDurationInMinute(startTime, endTime);
    }

    private static void totalPayment(){
        System.out.println("Total keseluruhan transaksi yang sudah dilakukan saat ini adalah Rp."+serviceLog.totalPayment()+",00");
    }

    private static void printDaily(){
        serviceLog.show();
        System.out.println("TOTAL PENDAPATAN HARI INI Rp."+serviceLog.totalPayment());
    }

    private static void removeQueueUser(String userId){
        queue.dequeueUser(userId);
    }
}
