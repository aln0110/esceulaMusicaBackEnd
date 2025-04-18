package com.aln.esceulamusicabackend.Model.Person;

import com.aln.esceulamusicabackend.Model.Person.User.Users;

import java.util.Objects;

public class PersonCreationRequest {
    private Person person;
    private Users user;
    private Address address;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonCreationRequest that = (PersonCreationRequest) o;
        return Objects.equals(person, that.person) && Objects.equals(user, that.user) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, user, address);
    }

    @Override
    public String toString() {
        return "PersonCreationRequest{" +
                "person=" + person +
                ", user=" + user +
                ", address=" + address +
                '}';
    }
}
