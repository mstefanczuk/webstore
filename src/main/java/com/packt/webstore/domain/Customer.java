package com.packt.webstore.domain;

public class Customer {
    private String customerId;
    private String name;
    private String address;
    private long noOfOrdersMade;

    public Customer(String customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        noOfOrdersMade = 0;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(long noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return customerId.equals(customer.customerId);

    }

    @Override
    public int hashCode() {
        return customerId.hashCode();
    }

    @Override
    public String toString() {
        return "Customer [" +
                "customerId='" + customerId + '\'' +
                ", nazwa='" + name + '\'' +
                ']';
    }
}
