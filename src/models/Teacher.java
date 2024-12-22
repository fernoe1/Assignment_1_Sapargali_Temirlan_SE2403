package models;

public class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    private int salary;
    public Teacher(String name, String surname, int age, String gender, String subject, int years, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = years;
        this.salary = salary;
    }

    public void giveRaise(int percentage) {
        salary = (int)(salary * ((percentage + 100) / 100.0));
    }

    public String getSubject() {
        return subject;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {

        return super.toString() + "I teach " + subject;
    }
}
