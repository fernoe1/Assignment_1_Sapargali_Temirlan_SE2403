import models.School;
import models.Person;
import models.Student;
import models.Teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String studentsFile = "C:\\Users\\Berik\\IdeaProjects\\Assignment_1_Sapargali_Temirlan_SE2403\\src\\students.txt";
        String teachersFile = "C:\\Users\\Berik\\IdeaProjects\\Assignment_1_Sapargali_Temirlan_SE2403\\src\\teachers.txt";
        School school = new School();

        try {
            BufferedReader studentsReader = new BufferedReader(new FileReader(studentsFile));
            String line;
            while((line = studentsReader.readLine()) != null) {
                String[] parts = line.split(" ");
                Student student = new Student(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
                for (int i = 4; i < parts.length; i++) {
                    student.addGrade(Integer.parseInt(parts[i]));
                }
                school.addMember(student);
            }
            studentsReader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader teacherReader = new BufferedReader(new FileReader(teachersFile));
            String line;
            while((line = teacherReader.readLine()) != null) {
                String[] parts = line.split(" ");
                Teacher teacher = new Teacher(parts[0], parts[1], Integer.parseInt(parts[2]),
                        parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));
                school.addMember(teacher);
            }
            teacherReader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println(school);
        school.giveRaiseToTeachers();
        school.sortStudents();
    }
}
