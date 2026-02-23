package campus;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // ---- Courses ----
        Course oop = new Course("OOP", "Dr. Lee", 6);
        Course discrete = new Course("Discrete Math", "Dr. Kim", 5);
        Course english = new Course("English", "Ms. Brown", 3);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(oop);
        courses.add(discrete);
        courses.add(english);

        // ---- Assignments ----
        ArrayList<AssignmentTask> tasks = new ArrayList<>();
        tasks.add(new AssignmentTask("Lab 1", oop, 3, 1));
        tasks.add(new AssignmentTask("Project", oop, 8, 5));
        tasks.add(new AssignmentTask("Homework", discrete, 4, 0));
        tasks.add(new AssignmentTask("Essay", english, 2, 3));
        tasks.add(new AssignmentTask("Quiz Prep", discrete, 2, 2));

        // ---- Study Sessions ----
        ArrayList<StudySession> sessions = new ArrayList<>();
        sessions.add(new StudySession(oop, 120));
        sessions.add(new StudySession(oop, 90));
        sessions.add(new StudySession(discrete, 60));
        sessions.add(new StudySession(english, 45));

        // ---- Print Courses ----
        System.out.println("=== COURSES ===");
        for (Course c : courses) {
            System.out.println(c);
        }

        // ---- Print Assignments ----
        System.out.println("\n=== ASSIGNMENTS ===");
        int totalRemaining = 0;

        for (AssignmentTask t : tasks) {

            if (t.isUrgent()) {
                System.out.println("URGENT -> " + t);
            } else {
                System.out.println(t);
            }

            if (!t.isCompleted()) {
                totalRemaining += t.getEstimatedHours();
            }
        }

        System.out.println("\nTotal remaining hours: " + totalRemaining);

        // ---- Study Time Per Course ----
        System.out.println("\n=== STUDY TIME PER COURSE ===");

        for (Course c : courses) {
            double totalHours = 0;

            for (StudySession s : sessions) {
                if (s.getCourse() == c) {
                    totalHours += s.hours();
                }
            }

            System.out.println(c.getName() + ": " + totalHours + " hours");
        }

        // ---- Mark one task completed ----
        System.out.println("\n=== MARK ONE TASK COMPLETED ===");

        AssignmentTask taskToComplete = tasks.get(0);
        taskToComplete.markCompleted();

        System.out.println("Updated task:");
        System.out.println(taskToComplete);

        totalRemaining = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                totalRemaining += t.getEstimatedHours();
            }
        }

        System.out.println("New remaining hours: " + totalRemaining);
    }
}