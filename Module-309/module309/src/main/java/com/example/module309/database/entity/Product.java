package com.example.module309.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "productline_id")
    private int productlineId;

    @Column(name = "product_scale")
    private String productScale;

    @Column(name = "product_vendor")
    private String productVendor;

    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "quantity_in_stock", columnDefinition = "SMALLINT")
    private int quantityInStock;

    @Column(name = "buy_price", columnDefinition = "DECIMAL")
    private double buyPrice;

    @Column(name = "msrp", columnDefinition = "DECIMAL")
    private double msrp;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderDetail> orderDetails;

}
