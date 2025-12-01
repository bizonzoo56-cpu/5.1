import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private final String fileName = "students.txt";

    public void addStudent(Student st) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(st.getName() + ";" + st.getSurname() + ";" +
                     st.getAge() + ";" + st.getDateOfBirth());
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
            if (parts.length == 4) {
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                String dob = parts[3];
                list.add(new Student(name, surname, age, dob));
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

    public boolean removeStudentByFullName(String name, String surname) throws IOException {
        List<Student> all = getStudents();
        List<Student> updated = new ArrayList<>();

        boolean removed = false;

        for (Student st : all) {
            if (st.getName().equalsIgnoreCase(name)
                && st.getSurname().equalsIgnoreCase(surname)) {
                removed = true;
            } else {
                updated.add(st);
            }
        }

        // Nadpisanie pliku
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        for (Student st : updated) {
            writer.write(st.getName() + ";" + st.getSurname() + ";" +
                         st.getAge() + ";" + st.getDateOfBirth());
            writer.newLine();
        }
        writer.close();

        return removed;
    }
}
