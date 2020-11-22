package Class.KBs.KB2.praktikum;

public class Service {
    private Time startTime, endTime;
    private int computerId, totalPayment;
    private String userId;

    public Service(int computerId, String userId, Time startTime, Time endTime, int totalPayment) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.computerId = computerId;
        this.totalPayment = totalPayment;
        this.userId = userId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public int getComputerId() {
        return computerId;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public String getUserId() {
        return userId;
    }
}
