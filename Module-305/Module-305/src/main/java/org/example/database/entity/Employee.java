package org.example.database.entity;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.query.Page;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    // To add a one to many relationship steps
    // 1) Goto the example website and create the @OneToMany and @ManyToOne annoations
    // https://attacomsian.com/blog/spring-data-jpa-one-to-many-mapping
    // 2) In the entity with the foreign key mark that colum as insertable = false and updateable = false
    // 3) Add the @ToString.Exclude annotation to both sides


    // the @Id annotation tells hibernate that this is the primary key for this entity
    @Id
    // this tells hibernate that the database will auto increment the new Id for a new record in the database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // this defines the database column
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Customer> customers;

    @Column(name = "office_id")
    private int officeId;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @Column(name = "reports_to")
    private int reportsTo;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "vacation_hours")
    private int vacationHours;

    @Column(name = "profile_image_url")
    private String profileImageUrl;


    public Employee() {

    }

    public Employee(int id, int officeId, String lastname, String firstname, String extension, String email, int reportsTo, String jobTitle, int vacationHours, String profileImageUrl) {
        this.id = id;
        this.officeId = officeId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.extension = extension;
        this.email = email;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
        this.vacationHours = vacationHours;
        this.profileImageUrl = profileImageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(int reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getVacationHours() {
        return vacationHours;
    }

    public void setVacationHours(int vacationHours) {
        this.vacationHours = vacationHours;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", officeId=" + officeId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", reportsTo=" + reportsTo +
                ", jobTitle='" + jobTitle + '\'' +
                ", vacationHours=" + vacationHours +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                '}';
    }
}
