//package org.example.chapter08.correctv1.domain;
//
//import jakarta.persistence.Embeddable;
//
//import java.util.Objects;
//
//@Embeddable
//public class Address08Cv1 {
//
//    private String city;
//    private String street;
//    private String zipcode;
//
//    public Address08Cv1(String city, String street, String zipcode) {
//        this.city = city;
//        this.street = street;
//        this.zipcode = zipcode;
//    }
//
//    public Address08Cv1() {
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public String getZipcode() {
//        return zipcode;
//    }
//
//
//    @Override
//    public boolean equals(Object object) {
//        if (this == object) return true;
//        if (object == null || getClass() != object.getClass()) return false;
//        Address08Cv1 that = (Address08Cv1) object;
//        return Objects.equals(getCity(), that.getCity()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getZipcode(), that.getZipcode());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getCity(), getStreet(), getZipcode());
//    }
//}
