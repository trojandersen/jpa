package se.yrgo.domain;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(unique=true, nullable=false)
    private String enrollmentID;
    private String name;
    private Integer numberOfCourses;
    @Embedded
    private Address address;

    public Student() {
    }
    public Student(String name) {
        this.name = name;
        //this.numberOfCourses=10;
    }

    public Student(String name, String enrollmentID) {
        this(name);
        this.enrollmentID = enrollmentID;
        //this.numberOfCourses=10;
    }

    public Student(String name, String enrollmentID, String street, String city,
                   String zipCode){
        this.name = name;
        this.enrollmentID= enrollmentID;
        this.address = new Address(street,city,zipCode);
    }

    public String toString() {
        return name+" lives at: "+address;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEnrollmentID() {
        return enrollmentID;
    }
    public void setEnrollmentID(String enrollmentID) {
        this.enrollmentID = enrollmentID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address newAddress) {
        this.address = newAddress;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((enrollmentID == null) ? 0 : enrollmentID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (enrollmentID == null) {
            return other.enrollmentID == null;
        } else return enrollmentID.equals(other.enrollmentID);
    }
}
