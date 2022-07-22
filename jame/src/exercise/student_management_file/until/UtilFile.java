package exercise.student_management_file.until;

import exercise.student_management_file.model.Student;
import exercise.student_management_file.model.Teacher;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UtilFile {
    public static String PATH_STUDENT = "jame/src/exercise/student_management_file/data/student.csv";
    public static String PATH_TEACHER = "jame/src/exercise/student_management_file/data/teacher.csv";

    private static @NotNull List<String> readFile(String path) throws IOException {
        List<String> strings = new ArrayList<>();
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        return strings;
    }

    private static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static @NotNull List<Student> readStudentFile(String path) {
        List<Student> students = new ArrayList<>();
        List<String> strings = null;
        try {
            strings = readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arr;
        for (String s : strings) {
            arr = s.split(",");
            if (arr.length == 6) {
                Student student = new Student(arr[0], arr[1], arr[2], Boolean.parseBoolean(arr[3]), arr[4], Double.parseDouble(arr[5]));
                students.add(student);
            }
        }
        return students;
    }

    public static void writeStudentFile(String path, List<Student> students) {
        StringBuilder data = new StringBuilder();
        for (Student student : students) {
            data.append(student.getInfo()).append("\n");
        }

        data.deleteCharAt(data.length() - 1);
        try {
            writeFile(path, data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static @NotNull List<Teacher> readTeacherFile(String path) {
        List<Teacher> teachers = new ArrayList<>();
        List<String> strings = null;
        try {
            strings = readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arr;
        for (String s : strings) {
            arr = s.split(",");
            if (arr.length == 5) {
                Teacher teacher = new Teacher(arr[0], arr[1], arr[2], Boolean.parseBoolean(arr[3]), arr[4]);
                teachers.add(teacher);
            }
        }
        return teachers;
    }

    public static void writeTeacherFile(String path, List<Teacher> teachers) {
        StringBuilder data = new StringBuilder();
        for (Teacher teacher : teachers) {
            data.append(teacher.getInfo()).append("\n");
        }

        data.deleteCharAt(data.length() - 1);
        try {
            writeFile(path, data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
