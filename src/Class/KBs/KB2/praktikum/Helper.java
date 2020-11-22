package Class.KBs.KB2.praktikum;

public class Helper {
    public static int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int totalDaysInAYear(){
        int data = 0;
        for (int j : monthDay) {
            data += j;
        }
        return data;
    }

    public static int countDayOfYear(Time data){
        int totalDays = data.year * Helper.totalDaysInAYear(); // year to day
        for (int i = 0; i < data.month; i++)
            totalDays += Helper.monthDay[i];// month to day
        totalDays += data.day;              // day + day
        return totalDays;
    }

    public static String getDurationInString(Time startTime, Time endTime){
        int differenceSec = realDurationInSecond(startTime, endTime);

        int second = differenceSec % 60;
        int hour = differenceSec / 60;
        int minute = hour % 60;
        hour = hour / 60;

        return hour + " jam, " + minute + " menit, dan " + second + " detik";
    }

    public static int timeToSec(Time time){
        return (countDayOfYear(time)*24*60*60) + (time.hour * 60 * 60) + (time.minute * 60) + time.second;
    }

    public static int getProfitableDurationInMinute(Time startTime, Time endTime){
        int difference = timeToSec(endTime) - timeToSec(startTime);
        int second = difference % 60;
        int hour = difference / 60;
        int minute = hour % 60;
        hour = hour / 60;
        minute += second>0 ? 1 : 0;

        return hour*60 + minute;
    }

    public static int realDurationInSecond(Time startTime, Time endTime){
        return timeToSec(endTime) - timeToSec(startTime);
    }
}
