package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

import static java.util.Map.entry;

public class Student extends Person {
    private int id;
    private static int id_gen;
    private final ArrayList<Integer> grades = new ArrayList<>();
    private static final Map<Integer, Double> gradesToGPA = Map.ofEntries(
            entry(100, 4.0),
            entry(95, 4.0),
            entry(90, 3.67),
            entry(85, 3.33),
            entry(80, 3.0),
            entry(75, 2.67),
            entry(70, 2.33),
            entry(65, 2.0),
            entry(60, 1.67),
            entry(55, 1.33),
            entry(50, 1.0)
    );

    public Student(String name, String surname, int age, String gender) {
        super(name, surname, age, gender);
        id = id_gen++;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        int overall = (int) ((sum / grades.size()));

        return convertToGPA(overall);
    }

    private static double convertToGPA(int grade) {
        grade -= grade % 5;
        Double gpa = gradesToGPA.get(grade);
        if (gpa == null) {
            return 0;
        }

        return gpa;
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
