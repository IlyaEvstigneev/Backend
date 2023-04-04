package XLS;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsReader {
    private XlsReader(){
    }

    public static List<University> readUniversities (String filePath) throws IOException { //передаем ссылку на наш файл
        List<University> universities = new ArrayList<>(); //создаем коллекцию
        FileInputStream inputStream = new FileInputStream(filePath); // создаем поток на чтение и передаем ему наш файл
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream); //
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Университеты"); // говорим чтобы читал страницу с именем

        Iterator<Row> rows = xssfSheet.iterator(); //пользуемся итератором для прохода файлу по рядам
        rows.next(); //получаем следующий элемент

        while (rows.hasNext()){ //пока есть следующий элемент
            Row currentRow = rows.next();  //создаем объект типа Row и передаем наш ряд из экселя
            University university = new University();//создаем объект типа университет
            universities.add(university);//добавляем его в нашу коллекцию
            university.setId(currentRow.getCell(0).getStringCellValue());//получаем строковое значение ячейки
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int)currentRow.getCell(3).getNumericCellValue());// получаем числовое значение ячейки и преобразуем в инт
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue()));//берем строковое значение и назначаем нашей константе перечисления
        }

        return universities;

    }

    public static List<Student> readStudents (String filePath) throws IOException{
        List<Student> students = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Студенты");

        Iterator<Row> rows = xssfSheet.iterator();
        rows.next();

        while (rows.hasNext()){
            Row currentRow = rows.next();
            Student student = new Student();
            students.add(student);
            student.setUniversityId(currentRow.getCell(0).getStringCellValue());
            student.setFullName(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int)currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float)currentRow.getCell(3).getNumericCellValue());
        }
        return students;
    }
}
