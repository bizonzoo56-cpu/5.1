import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private final String fileName = "students.txt";

    public void addStudent(Student st) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(st.getName() + ";" + st.getAge() + ";" + st.getDateOfBirth());
        writer.newLine();
        writer.close();
    }

    public List<Student> getStudents() throws IOException {
        List<Student> list = new ArrayList<>();

        File file = new File(fileName);
        if (!file.exists()) return list;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");

            if (parts.length == 3) {
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String dob = parts[2];
                list.add(new Student(name, age, dob));
            }
        }

        reader.close();
        return list;
    }

    
    public List<Student> findStudentsByName(String name) throws IOException {
        List<Student> all = getStudents();
        List<Student> result = new ArrayList<>();

        for (Student st : all) {
            if (st.getName().equalsIgnoreCase(name)) {
                result.add(st);
            }
        }

        return result;
    }
}
