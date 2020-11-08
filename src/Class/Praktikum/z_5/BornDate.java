package Class.Praktikum.z_5;

import java.text.DateFormatSymbols;

public class BornDate {
    String[] monthsName;
    int day, month, year;

    public BornDate(int day, int month, int year) {
        if (day > 0 && day < 32){
            if (month > 0 && month < 13){
                this.day = day;
                this.month = month;
                this.year = year;
                monthsName = new DateFormatSymbols().getMonths();
            } else{
                System.out.println("Error: bulan hanya ada 1-12");
                System.exit(500);
            }
        } else {
            System.out.println("Error: tanggal hanya ada 1-31");
            System.exit(500);
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth(){
        return month;
    }

    public String getMonthName() {
        return monthsName[month-1];
    }

    public int getYear() {
        return year;
    }

    public String info(){
        return getDay() + " " + getMonthName() + " " + getYear();
    }
}
