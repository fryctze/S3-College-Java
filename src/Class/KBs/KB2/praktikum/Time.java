package Class.KBs.KB2.praktikum;

public class Time {
    int year = 0 , month =0 , day = 0, hour = 0, minute =0 , second =0 ;

    public Time(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String getTime(){
        return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
    }
}
