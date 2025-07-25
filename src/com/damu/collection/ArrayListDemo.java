package com.damu.collection;

import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Double.compare(student.gpa, gpa) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', gpa=" + gpa + '}';
    }

    // Used for natural sorting (descending by GPA)
    @Override
    public int compareTo(Student o) {
        return Double.compare(o.gpa, this.gpa); // descending GPA
    }
}

public class ArrayListDemo {
    public static void main(String[] args) {
        // Create list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Akshit", 3.9));

        // Option 1: Custom comparator (GPA desc, then name asc)
        Comparator<Student> comparator = Comparator
                .comparing(Student::getGpa).reversed()
                .thenComparing(Student::getName);

        students.sort(comparator);

        System.out.println("Sorted by GPA (desc), Name (asc):");
        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getGpa());
        }

        // Option 2: Use natural ordering (compareTo method in Student)
        Collections.sort(students);
        System.out.println("\nSorted using Comparable (only GPA descending):");
        students.forEach(System.out::println);
    }
}
/*
 * - `Comparable<Student>` allows natural sorting based on descending GPA.
 * - Custom `Comparator` can sort by GPA (desc) and then name (asc).
 * - `Comparator.comparing(...).reversed().thenComparing(...)` is clean & powerful.
 * - Always override `equals()` and `hashCode()` for object-based collections (like Set, Map).
 * - Use `Collections.sort()` or `List.sort()` for sorting with custom or natural order.
 */
