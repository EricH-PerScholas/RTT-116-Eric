package com.example.module309.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    // To add a one to many relationship steps
    // 1) Goto the example website and create the @OneToMany and @ManyToOne annoations
    // 2) In the entity with the foreign key mark that colum as insertable = false and updateable = false
    // 3) Add the @ToString.Exclude annotation to both sides
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_rep_employee_id")
    @EqualsAndHashCode.Exclude
    private Employee employee;

    // now that we have the @ManyToOne mapping using the same column name for the @JoinColumn
    // hibernate is confused as the colum sales_rep_employee_id is not ambigous to hibernate
    // to solve this problem, we make this field read only by adding insertable = false and updateable = false
    // TL;DR; - The foreign key must be marked as read only for hibernate
    @Column(name = "sales_rep_employee_id", insertable = false, updatable = false)
    private Integer salesRepEmployeeId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_lastname")
    private String contactLastname;

    @Column(name = "contact_firstname")
    private String contactFirstname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "credit_limit", columnDefinition = "DECIMAL")
    private Double creditLimit;

    @Column(name = "image_url")
    private String imageUrl;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", salesRepEmployeeId=" + salesRepEmployeeId +
                ", customerName='" + customerName + '\'' +
                ", contactLastname='" + contactLastname + '\'' +
                ", contactFirstname='" + contactFirstname + '\'' +
                ", phone='" + phone + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", creditLimit=" + creditLimit +
                '}';
    }
}
