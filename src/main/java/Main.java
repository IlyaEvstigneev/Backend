import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<University> universityList = XlsReader.readUniversities("src/main/resources/universityInfo.xlsx");
        for(University university : universityList){
            System.out.println(university);
        }
        List<Student> studentList = XlsReader.readStudents("src/main/resources/universityInfo.xlsx");
        for (Student student : studentList){
            System.out.println(student);
        }

    }
}
