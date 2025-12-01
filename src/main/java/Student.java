public class Student {

    private String name;
    private String surname;
    private int age;
    private String dateOfBirth;

    public Student(String name, String surname, int age, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public static boolean isValidDate(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    @Override
    public String toString() {
        return name + " " + surname + ", wiek: " + age + ", ur.: " + dateOfBirth;
    }
}
