public class Student {

  private String Name;
  private int Age;

  public Student(String name, int age ) {
    Name = name;
    Age = age;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}

  public String ToString() {
    return Name + " " + Integer.toString(Age);
  }

  public static Student Parse(String str) {
    str = str.trim();
    if(str.isEmpty()) 
      return null;
    
    String[] data = str.split("\\s+");
    if(data.length != 2) 
      return new Student("ParseError", -1);
    
    try {
      return new Student(data[0], Integer.parseInt(data[1]));
    } catch (NumberFormatException e) {
      return new Student("ParseError", -1);
    }
  }
}