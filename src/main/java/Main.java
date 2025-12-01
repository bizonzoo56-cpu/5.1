import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Service s = new Service();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n=== MENU ===");
            System.out.println("1 - Dodaj studenta");
            System.out.println("2 - Wyświetl listę studentów");
            System.out.println("3 - Wyszukaj studenta po imieniu");
            System.out.println("4 - Usuń studenta po imieniu i nazwisku");
            System.out.println("0 - Wyjście");
            System.out.print("Wybierz opcję: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Nieprawidłowy wybór!");
                continue;
            }

            switch (choice) {

                case 1: {
                    System.out.print("Podaj imię: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Podaj nazwisko: ");
                    String surname = scanner.nextLine().trim();

                    if (name.isEmpty() || surname.isEmpty()) {
                        System.out.println("Imię i nazwisko nie mogą być puste!");
                        break;
                    }

                    System.out.print("Podaj wiek: ");
                    int age;
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                        if (age <= 0) {
                            System.out.println("Wiek musi być większy od 0!");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Błędny wiek!");
                        break;
                    }

                    System.out.print("Podaj datę urodzenia (YYYY-MM-DD): ");
                    String dob = scanner.nextLine().trim();

                    if (!Student.isValidDate(dob)) {
                        System.out.println("Nieprawidłowy format daty!");
                        break;
                    }

                    try {
                        s.addStudent(new Student(name, surname, age, dob));
                        System.out.println("Dodano studenta.");
                    } catch (IOException e) {
                        System.out.println("Błąd zapisu: " + e.getMessage());
                    }
                    break;
                }

                case 2: {
                    try {
                        List<Student> students = s.getStudents();
                        System.out.println("\n--- Lista studentów ---");
                        if (students.isEmpty()) {
                            System.out.println("Brak studentów.");
                        } else {
                            for (Student st : students) {
                                System.out.println(st);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Błąd odczytu: " + e.getMessage());
                    }
                    break;
                }

                case 3: {
                    System.out.print("Podaj imię do wyszukania: ");
                    String searchName = scanner.nextLine().trim();

                    if (searchName.isEmpty()) {
                        System.out.println("Imię nie może być puste!");
                        break;
                    }

                    try {
                        List<Student> result = s.findStudentsByName(searchName);
                        System.out.println("\n--- Wyniki wyszukiwania ---");
                        if (result.isEmpty()) {
                            System.out.println("Nie znaleziono studenta o imieniu: " + searchName);
                        } else {
                            for (Student st : result) {
                                System.out.println(st);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Błąd odczytu: " + e.getMessage());
                    }
                    break;
                }

                case 4: {
                    System.out.print("Podaj imię studenta do usunięcia: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Podaj nazwisko studenta do usunięcia: ");
                    String surname = scanner.nextLine().trim();

                    if (name.isEmpty() || surname.isEmpty()) {
                        System.out.println("Imię i nazwisko nie mogą być puste!");
                        break;
                    }

                    try {
                        boolean removed = s.removeStudentByFullName(name, surname);
                        if (removed) {
                            System.out.println("Student usunięty.");
                        } else {
                            System.out.println("Nie znaleziono takiego studenta.");
                        }
                    } catch (IOException e) {
                        System.out.println("Błąd zapisu: " + e.getMessage());
                    }
                    break;
                }

                case 0:
                    System.out.println("Koniec programu.");
                    running = false;
                    break;

                default:
                    System.out.println("Nie ma takiej opcji!");
            }
        }

        scanner.close();
    }
}
