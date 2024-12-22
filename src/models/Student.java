package models;

import java.util.ArrayList;
import java.util.Comparator;

public class Student extends Person {
    private int id;
    private static int id_gen;
    ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name, String surname, int age, String gender) {
        super(name, surname, age, gender);
        id = id_gen++;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateGPA () {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        return ((double) sum / grades.size()) * 0.04;
    }

    public static Comparator<Student> compareGpa() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.calculateGPA() > s2.calculateGPA()) return 1;
                if (s1.calculateGPA() < s2.calculateGPA()) return -1;
                return s1.getSurname().compareTo(s2.getSurname());
            }
        };
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {

        return super.toString() + "I am a student with the student ID " + id;
    }
}
