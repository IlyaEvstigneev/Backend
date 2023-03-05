public class Main {

    public static void main(String[] args) {

        Student student = new Student("Evstigneev", "12345", 12, 13.8f);

        University university = new University("123", "Московский авиационный институт",  "МАИ", 40, StudyProfile.ENGINEER);

        System.out.println(student);

        System.out.println(university);
    }
}
