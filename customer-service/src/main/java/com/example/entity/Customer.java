package com.example.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * The entity class of the user database table
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", unique = true, nullable = false, updatable = false)
    private Integer customerID;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "balance")
    private Integer balance;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "customer_fk")
//    private List<Account> account = new ArrayList<>();

    /**
     * The constructor of the Customer
     * @param customerID The customer id
     * @param name The name of the customer
     * @param surname The surname of the customer
     * @param balance The balance of the customer
     */
    public Customer(Integer customerID, String name, String surname, Integer balance) {
        this.customerID = customerID;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }
}
