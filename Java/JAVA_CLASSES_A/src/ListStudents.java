import java.util.Arrays;
import java.util.List;
import java.util.GregorianCalendar;
import java.util.Calendar;

class ListStudents {

    private static List<Student> students = Arrays.asList(
            new Student(1, "Ivan", "Karotkiy", "Nikolaevich",
                    new GregorianCalendar(1997, 11, 22),
                    "Minsk", "+375297172589", Faculty.FCD, 3, 610901),
            new Student(2, "Igor", "Kapustin", "Romanovich",
                    new GregorianCalendar(1998, 11, 26),
                    "Gomel", "+375441234567", Faculty.MF, 3, 610901),
            new Student(3, "Ivan", "Ponomarov", "Alexandrovich",
                    new GregorianCalendar(1999, 6, 29),
                    "Bereza", "+375330987654", Faculty.FCD, 3, 610902),
            new Student(4, "Anastasia", "Ponomarenko", "Denisovna",
                    new GregorianCalendar(2000, 7, 31),
                    "Minsk", "+375292345678", Faculty.FEE, 2, 553505),
            new Student(5, "Arsen", "Safaryan", "Denisovich",
                    new GregorianCalendar(1997, 11, 25),
                    "Polotsk", "+375177654321", Faculty.FREE, 1, 228228),
            new Student(6, "Oleg", "Kornev", "Nikolaevich",
                    new GregorianCalendar(1998, 3, 12),
                    "Orscha", "+375441234577", Faculty.FREE, 1, 228228),
            new Student(7, "Alexander", "Getman", "Alexandrovich",
                    new GregorianCalendar(1998, 3, 18),
                    "Polotsk", "+375295566778", Faculty.MF, 1, 228228),
            new Student(8, "Anna", "Stadchenko", "Nikolaevna",
                    new GregorianCalendar(1995, 2, 15),
                    "Minsk", "+375290989076", Faculty.FEE, 4, 234543),
            new Student(9, "Anna", "Sviridenok", "Alexandrovna",
                    new GregorianCalendar(1998, 3, 24),
                    "Minsk", "+375336469746", Faculty.FCD, 3, 610901),
            new Student(10, "Anna", "Kunitskaya", "Olegovna",
                    new GregorianCalendar(1997, 10, 16),
                    "Pruzhany", "+375298647024", Faculty.FCSaN, 4, 610902),
            new Student(11, "Nikolay", "Karotkiy", "Anatolevich",
                    new GregorianCalendar(1969, 4, 27),
                    "Chernigov", "+375447689537", Faculty.FITM, 4, 553505),
            new Student(12, "Elena", "Karotkaya", "Viktorovna",
                    new GregorianCalendar(1973, 10, 25),
                    "Polotsk", "+375447654567", Faculty.FIC, 2, 553505),
            new Student(13, "Alexey", "Karotkiy", "Nikolaevich",
                    new GregorianCalendar(2012, 5, 10),
                    "Pruzhany", "+375297656795", Faculty.FREE, 1, 100000),
            new Student(14, "Roman", "Popov", "Sergeevich",
                    new GregorianCalendar(2000, 9, 15),
                    "Polotsk", "+375296767676", Faculty.MF, 2, 553504)
            );


    private void output(Student s) {
        System.out.print("id: " + s.getId() + ", " + s.getSurname() + " " + s.getName() + " " + s.getPatronymic()
                + ", birthday: " + s.getBirthday().get(Calendar.DAY_OF_MONTH) + "/" + s.getBirthday().get(Calendar.MONTH)
                + "/"+ s.getBirthday().get(Calendar.YEAR) + ", address: " + s.getAddress() + ", phone number: "
                + s.getPhoneNumber() + ", faculty: " + s.getFaculty() + ", course: " + s.getCourse()
                + ", group number: " + s.getGroupNumber() + "\n");
    }


    //a) список студентов заданного факультета;
    void listOfFacultyStudents(Faculty faculty) {
        for (Student stud : students) {
            if(stud != null) {
                if (faculty.equals(stud.getFaculty())) {
                    output(stud);
                }
            }
        }
    }


    //b) списки студентов для каждого факультета и курса;
    void listsOfStudentFacultyAndCourse(Faculty faculty, int course) {
        for (Student stud : students) {
            if (stud != null) {
                if (faculty.equals(stud.getFaculty()) && stud.getCourse() == course) {
                    output(stud);
                }
            }
        }
    }


    //c) список студентов, родившихся после заданного года;
    void listOfStudentsBornAfterYear(GregorianCalendar year) {
        for (Student stud : students) {
            if(stud != null) {
                if (stud.getBirthday().get(Calendar.YEAR) > year.get(Calendar.YEAR)) {
                    output(stud);
                }
            }
        }
    }


    //d) список учебной группы.
    void studyGroupList(int groupNumber) {
        for (Student stud : students) {
            if (stud != null) {
                if (stud.getGroupNumber() == groupNumber) {
                    output(stud);
                }
            }
        }
    }
}
