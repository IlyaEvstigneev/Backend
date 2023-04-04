package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;

import java.util.List;

public class JsonUtil {
    private JsonUtil(){

    }

    public static String studentToJson(Student student){
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String universityToJson(University university){
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static String listStudentToJson(List<Student> students){
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }

    public static String listUniversityToJson(List<University> universities){
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }

    public static Student jsonToStudent(String json){
        return new Gson().fromJson(json, Student.class);
    }

    public static University jsonToUniversity(String json){
        return new Gson().fromJson(json, University.class);
    }

    public static List<Student> jsonToListStudent(String json){
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }

    public static List<University> jsonToListUniversity(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {
        }.getType());
    }
}
