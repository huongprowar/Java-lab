package lab0021;

import java.util.Comparator;

public class Student implements Comparator<Student> {

    private String ID;
    private String name;
    private int age;
    private String Semester;
    private String coursename;

    public Student() {
    }

    public Student(String ID, String name, int age, String Semester, String coursename) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.Semester = Semester;
        this.coursename = coursename;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compare(Student t1, Student t2) {
        return t1.getAge() - t2.getAge();
    }

}
