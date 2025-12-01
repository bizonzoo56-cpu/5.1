public class Student {

    private String name;
    private int age;
    private String dateOfBirth;

    public Student(String name, int age, String dateOfBirth) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    public String getDateOfBirth() { return dateOfBirth; }

    public static boolean isValidDate(String date) {
        return date.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }

    @Override
    public String toString() {
        return "Student: " + name + ", wiek: " + age + ", data urodzenia: " + dateOfBirth;
    }
}
