package com.dmall.order.domain.model;

import com.dmall.order.domain.common.ValueObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "jx_customer_contact")
@Entity
public class CustomerContact implements ValueObject<CustomerContact> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    public void setOrder(Order order) {
        this.order = order;
    }

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="ORDER_ID")
    private Order order;

    public void setName(String name) {
        this.name = name;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setMore_details(String more_details) {
        this.more_details = more_details;
    }

    private String name;
    private String province;
    private String city;
    private String area;
    private String street;

    public Long getId() {
        return id;
    }



    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getStreet() {
        return street;
    }

    public String getMore_details() {
        return more_details;
    }

    private String more_details;

    public CustomerContact() {
    }

    public String getName() {
        return name;
    }

    public String getAdress(){
        return province+city+area+street+more_details;
    }

    @Override
    public boolean sameValueAs(CustomerContact other) {
        return other.name.equals(name);
    }
}