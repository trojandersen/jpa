package se.yrgo.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tutorID;
    private String name;
    private int salary;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="TUTOR_FK")
    private Set<Student>teachingGroup;
    @ManyToMany(mappedBy= "tutors")
    private Set<Subject>subjectsToTeach;

    public Tutor() {
    }

    public Tutor(String tutorID, String name, int salary) {
        this.tutorID = tutorID;
        this.name = name;
        this.salary = salary;
        this.teachingGroup = new HashSet<Student>();
        this.subjectsToTeach = new HashSet<Subject>();
    }

    public void addStudentToTeachingGroup (Student student) {
        this.teachingGroup.add(student);
    }

    public Set<Student>getTeachingGroup() {
        return Collections.unmodifiableSet(this.teachingGroup);
    }

    public void addSubjectsToTeach(Subject subject) {
        this.subjectsToTeach.add(subject);
        subject.getTutors().add(this);
    }

    public String toString() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getTutorID() {
        return tutorID;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public void setName(String name) {
        this.name= name;
    }

    public Set<Student>getModifiableTeachingGroup(){
        return this.teachingGroup;
    }

    public Set<Subject> getSubjects() {
        return this.subjectsToTeach;
    }

    public void createAndAddStudentToGroup(String studentName, String
            enrollmentID, String street, String city, String zipCode) {
        Student student = new Student(studentName, enrollmentID, street, city, zipCode);
        this.addStudentToTeachingGroup(student);
    }
}
