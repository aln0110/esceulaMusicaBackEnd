package com.aln.esceulamusicabackend.Model.Person.User;

import com.aln.esceulamusicabackend.Model.Person.Address;
import com.aln.esceulamusicabackend.Model.Person.Person;

import java.util.Objects;

public class UserProfile {
    private Users user;
    private Person person;
    private Address addresses;

    public UserProfile(Users user, Person person, Address addresses) {
        this.user = user;
        this.person = person;
        this.addresses = addresses;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(user, that.user) && Objects.equals(person, that.person) && Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, person, addresses);
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "user=" + user +
                ", person=" + person +
                ", addresses=" + addresses +
                '}';
    }
}