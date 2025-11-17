import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            Service s = new Service();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Podaj imię: ");
            String name = scanner.nextLine().trim();

            System.out.print("Podaj wiek: ");
            int age = scanner.nextInt();

            Student newStudent = new Student(name, age);

            s.addStudent(newStudent);

            System.out.println("Student zapisany.\n");

            var students = s.getStudents();
            System.out.println("Wszyscy studenci w bazie:");

            for (Student current : students) {
                System.out.println(current.ToString());
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
