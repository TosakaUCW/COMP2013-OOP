package question1;

public class Teacher {
    // Attributes
    private String name;
    
    // Constructor
    public Teacher(String name) {
        this.name = name;
    }
    
    public int grading(Student s) {
        Assignment a = s.getAssignment();
        
        // If the assignment’s name (the student who finished the assignment) is not equal to the name of the student who submitted the assignment, the score is 0;
        if (a == null || !a.getName().equals(s.getName())) {
            return 0;
        }
        
        // If the assignment is not submit on time, the score is 0;
        if (!a.isSubmitted()) {
            return 0;
        }
        // If the assignment is submitted on time, but cannot compile, the score is 0;
        if (!a.getCode().compile()) {
            return 0;
        }
        // If the assignment is submitted on time, can compile, but cannot run, the score is 50;
        if (!a.getCode().run()) {
            return 50;
        }
        // If the assignment is submitted on time, can compile, can run, and the code lines < 100, the score is 80;
        if (a.getCode().countLines() < 100) {
            return 80;
        }
        // If the assignment is submitted on time, can compile, can run, and the code lines > 100, the score is 100;
        if (a.getCode().countLines() >= 100) {
            return 100;
        }
        return 100;
    }
    
    // Tests
    public static void testTeacher() {
        // set one teacher named xyz
        Teacher t1 = new Teacher("xyz");

        // tests for grading
        // 4 kinds of code
        Code code1 = new Code(true, true, 50);
        Code code2 = new Code(true, false, 120);
        Code code3 = new Code();
        Code code4 = new Code(true, true, 120);

        // set 6 different students
        // not submit,score 0
        Assignment a1 = new Assignment(code1, false, "abin");
        Student stu1 = new Student("abin", true);
        stu1.writeAssignment(a1);
        System.out.println(t1.grading(stu1) == 0);

        // Copying ,score 0
        Student stu2 = new Student("huanfeng", false);
        stu2.copyAssignment(a1);
        System.out.println(t1.grading(stu1) == 0);

        // submitted , cannot compile, score 0
        Assignment a2 = new Assignment(code3, true, "Potter");
        Student stu3 = new Student("potter", true);
        stu3.writeAssignment(a2);
        System.out.println(t1.grading(stu3) == 0);

        // submitted , can compile, cannot run ,score 50
        Assignment a3 = new Assignment(code2, true, "Ron");
        Student stu4 = new Student("Ron", true);
        stu4.writeAssignment(a3);
        System.out.println(t1.grading(stu4) == 50);

        // submitted , can compile, can run, code lines <100 ,score 80
        Assignment a4 = new Assignment(code1, true, "Lupin");
        Student stu5 = new Student("Lupin", true);
        stu5.writeAssignment(a4);
        System.out.println(t1.grading(stu5) == 80);

        // submitted , can compile, can run, code lines >100 ,score 100
        Assignment a5 = new Assignment(code4, true, "Hermione");
        Student stu6 = new Student("Hermione", true);
        stu6.writeAssignment(a5);
        System.out.println(t1.grading(stu6) == 100);
    }
}
