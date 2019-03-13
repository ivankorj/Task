import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        ListStudents listStudents = new ListStudents();
        System.out.println("a) list of students of a given faculty: ");
        listStudents.listOfFacultyStudents(Faculty.FCD);
        System.out.println("b) student lists for each faculty and course: ");
        listStudents.listsOfStudentFacultyAndCourse(Faculty.MF, 3);
        System.out.println("c) list of students born after a given year: ");
        listStudents.listOfStudentsBornAfterYear(new GregorianCalendar(1999, 0, 0));
        System.out.println("d) study group list: ");
        listStudents.studyGroupList(553504);
    }
}
