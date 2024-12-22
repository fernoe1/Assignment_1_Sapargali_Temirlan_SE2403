package models;

import java.util.ArrayList;
import java.util.Random;

public class School {
    ArrayList<Person> members = new ArrayList<>();

    public void addMember(Person person) {
        members.add(person);
    }

    public void giveRaiseToTeachers() {
        Random random = new Random();
        System.out.println("Raised salaries:");
        for (Person member : members) {
            if (member instanceof Teacher) {
                if (((Teacher) member).getYearsOfExperience() > 10) {
                    int tempSalary = ((Teacher) member).getSalary();
                    ((Teacher) member).giveRaise(random.nextInt(1, 101));
                    System.out.println(member.getName() + " " + member.getSurname()
                            + "'s salary was raised to " + ((Teacher) member).getSalary() + " from " + tempSalary);
                }
            }
        }
        System.out.println();
    }

    public void sortStudents() {
        ArrayList<Student> students = new ArrayList<>();

        for (Person member : members) {
            if (member instanceof Student) {
                students.add(((Student) member));
            }
        }

        students.sort(Student.compareGpa());
        System.out.println("Sorted list of students: ");
        for (Student student : students) {
            System.out.println(student.getId() + " " + student.getName() + " " + student.getSurname() + " " + student.calculateGPA());
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("School consists of the following: \n");

        str.append("Teachers: \n");
        for (Person member : members) {
            if (member.getClass().equals(Teacher.class)) {
                str.append(member).append("\n");
            }
        }

        str.append("Students: \n");
        for (Person member : members) {
            if (member.getClass().equals(Student.class)) {
                str.append(member).append("\n");
            }
        }

        return str.toString();
    }
}