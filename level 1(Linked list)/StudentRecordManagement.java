package Week3.Day01;

// StudentRecordManagement class
class StudentRecordManagement {
    // Node class representing a student record
    class Student {
        // Attributes for student node
        int rollNumber;
        String name;
        int age;
        String grade;
        Student next;

        // Constructor for a student node
        public Student(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    // Head pointer for the singly linked list
    private Student head = null;

    // Add a student record at the beginning of the list
    public void addStudentAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
        System.out.println("Student added at the beginning: " + name);
    }

    // Add a student record at the end of the list
    public void addStudentAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
        } else {
            Student current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudent;
        }
        System.out.println("Student added at the end: " + name);
    }

    // Add a student record at a specific position
    public void addStudentAtPosition(int rollNumber, String name, int age, String grade, int position) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 1) {
            addStudentAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position out of bounds. Adding at the end.");
            addStudentAtEnd(rollNumber, name, age, grade);
        } else {
            newStudent.next = current.next;
            current.next = newStudent;
            System.out.println("Student added at position " + position + ": " + name);
        }
    }

    // Remove a student record by Roll Number
    public void removeStudentByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("No students in the list.");
            return;
        }
        Student current = head;
        Student previous = null;
        while (current != null && current.rollNumber != rollNumber) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
            return;
        }
        if (previous == null) {
            // Remove the first node
            head = current.next;
        } else {
            // Remove the node from the middle or end
            previous.next = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " removed.");
    }

    // Search for a student record by Roll Number
    public void searchStudentByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("No students in the list.");
            return;
        }
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Student Found: Name: " + current.name + ", Roll Number: " + current.rollNumber + ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Display all student records
    public void displayStudents() {
        if (head == null) {
            System.out.println("No students in the list.");
            return;
        }
        System.out.println("Student Records:");
        Student current = head;
        while (current != null) {
            System.out.println("Name: " + current.name + ", Roll Number: " + current.rollNumber + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Update a student's grade based on their Roll Number
    public void updateStudentGrade(int rollNumber, String newGrade) {
        if (head == null) {
            System.out.println("No students in the list.");
            return;
        }
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated for student with Roll Number " + rollNumber + ": " + newGrade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    public static void main(String[] args) {
        StudentRecordManagement studentManagement = new StudentRecordManagement();

        // Add student records
        studentManagement.addStudentAtEnd(1, "John Doe", 20, "A");
        studentManagement.addStudentAtBeginning(2, "Jane Smith", 22, "B");
        studentManagement.addStudentAtPosition(3, "Alice Johnson", 21, "A", 2);

        // Display student records
        System.out.println();
        studentManagement.displayStudents();

        // Search for a student by Roll Number
        System.out.println();
        studentManagement.searchStudentByRollNumber(2);

        // Update a student's grade
        System.out.println();
        studentManagement.updateStudentGrade(2, "A");

        // Display updated student records
        System.out.println();
        studentManagement.displayStudents();

        // Remove a student by Roll Number
        System.out.println();
        studentManagement.removeStudentByRollNumber(1);

        // Display remaining student records
        System.out.println();
        studentManagement.displayStudents();
    }
}


