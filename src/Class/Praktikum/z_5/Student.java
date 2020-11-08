package Class.Praktikum.z_5;

public class Student {
    String firstName, lastName;
    String bornPlace;

    BornDate bornDate;

    public Student(String firstName, String lastName, String bornPlace, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornPlace = bornPlace;

        this.bornDate = new BornDate(day, month, year);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBornPlace() {
        return bornPlace;
    }

    public void info(){
        System.out.printf("%s %s, %d years old\n%s, %s",
                getFirstName(), getLastName(),
                getAge(),
                getBornPlace(),
                bornDate.info()
        );
    }

    public int getAge(){
        return 2020 - bornDate.getYear();
    }
}
