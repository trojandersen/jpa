package se.yrgo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {
    /*@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;*/
    private String subjectName;
    @ManyToMany
    private Set<Tutor>tutors;

    public Subject() {}

    public Subject (String subjectName, int numberOfSemesters) {
        this.subjectName = subjectName;
        this.tutors = new HashSet<Tutor>();
    }

    public void addTutorToSubjects(Tutor tutor) {
        this.tutors.add(tutor);
        tutor.getSubjects().add(this);
    }
    public String getSubjectName () {
        return subjectName;
    }
    public Set<Tutor>getTutors () {
        return tutors;
    }
}