package models;

public class Person {
    private String name;
    private String surname;
    private int age;
    private boolean gender;

    public Person(String name, String surname, int age, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        char firstLetter = gender.charAt(0);
        this.gender = (firstLetter == 'M');
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getSurname() {

        return surname;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public int getAge() {

        return age;
    }

    public void setGender(boolean gender) {

        this.gender = gender;
    }

    public String getGender() {

        return (gender ? "Male" : "Female");
    }

    @Override
    public String toString() {

        return "Hello! my name is " + name + " " + surname + ", I'm a " + age + " years old " + (gender ? "male" : "female") + ". ";
    }
}
