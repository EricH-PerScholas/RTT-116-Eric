package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "orderdetails")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "quantity_ordered")
    private int quantityOrdered;

    @Column(name = "price_each", columnDefinition = "DECIMAL")
    private double priceEach;

    @Column(name = "order_line_number", columnDefinition = "SMALLINT")
    private int orderLineNumber;

}
