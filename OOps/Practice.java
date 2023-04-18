import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int id;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

public class Practice {

    List<Student> stdList = new ArrayList<>();

    void addStd(Student st) {
        stdList.add(st);
    }

    void removeStdId(int id) {
        for (Student student : stdList) {
            if (student.getId() == id)
                stdList.remove(id);
        }
    }

    void searchStdId(int id) {
        for (Student student : stdList) {
            if (student.getId() == id) {
                System.out.println("Id :" + student.getId() + "Name: " + student.getName());
            }
        }
    }

    void searchStdName(String name) {
        for (Student student : stdList) {
            if (student.getName().equals(name)) {
                System.out.println("Id :" + student.getId() + "Name: " + student.getName());
            }
        }
    }

    void showStdList() {
        for (Student student : stdList) {
            System.out.println("Id :" + student.getId() + "Name: " + student.getName());
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Practice main = new Practice();

        Student s1 = new Student(1, "Saiful");
        main.addStd(s1);
        Student s2 = new Student(2, "Islam");
        main.addStd(s2);

        main.showStdList();

    }
}