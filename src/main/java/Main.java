import XLS.XlsReader;
import XLS.XlsWriter;
import enums.comparator.StudentComparator;
import enums.comparator.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import model.Statistics;
import model.Student;
import model.University;
import util.ComparatorUtil;
import util.JsonUtil;
import util.StatisticsUtil;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<University> universityList = XlsReader.readUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universityList.sort(universityComparator);
        String listUniversityToJson = JsonUtil.listUniversityToJson(universityList);
        System.out.println(listUniversityToJson);
        List<University> universityList2 = JsonUtil.jsonToListUniversity(listUniversityToJson);
        System.out.println(universityList.size() == universityList2.size());
        universityList.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            // проверяем, что json из отдельного элемента создан успешно
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            // проверяем, что обратно элемент воссоздаётся
            System.out.println(universityFromJson);
        });
        List<Student> studentList = XlsReader.readStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        studentList.sort(studentComparator);
        String listStudentToJson = JsonUtil.listStudentToJson(studentList);
        System.out.println(listStudentToJson);
        List<Student> studentList2 = JsonUtil.jsonToListStudent(listStudentToJson);
        System.out.println(studentList.size() == studentList2.size());
        studentList.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            // проверяем, что json из отдельного элемента создан успешно
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            // проверяем, что обратно элемент воссоздаётся
            System.out.println(studentFromJson);
        });
        List<Statistics> statisticsList = StatisticsUtil.createStatistics(studentList, universityList);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");
    }

    }

