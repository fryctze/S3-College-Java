package Class.KBs.KB2.praktikum;

public class OnGoingService {
    private String userId;
    private Time startTime;

    public OnGoingService() {
        userId = null;
        startTime = null;
    }

    public OnGoingService(String userId, Time startTime) {
        this.userId = userId;
        this.startTime = startTime;
    }

    public String getUserId() {
        return userId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void clearData() {
        this.userId = null;
        this.startTime = null;
    }
}
