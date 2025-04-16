package com.aln.esceulamusicabackend.Model.Person;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person {

    private int id;
    private String name;
    private String lastname;
    private String typeIdCard;
    private String idCard;
    private LocalDateTime BirthDate;
    private String nationality;
    private String gender;
    private boolean status;

    public Person() {
    }

    public Person(int id, String name, String lastname, String typeIdCard, String idCard, LocalDateTime BirthDate, String nationality, String gender, boolean status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.typeIdCard = typeIdCard;
        this.idCard = idCard;
        this.BirthDate = BirthDate;
        this.nationality = nationality;
        this.gender = gender;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTypeIdCard() {
        return typeIdCard;
    }

    public void setTypeIdCard(String typeIdCard) {
        this.typeIdCard = typeIdCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public LocalDateTime getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDateTime BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && status == person.status && Objects.equals(name, person.name) && Objects.equals(lastname, person.lastname) && Objects.equals(typeIdCard, person.typeIdCard) && Objects.equals(idCard, person.idCard) && Objects.equals(BirthDate, person.BirthDate) && Objects.equals(nationality, person.nationality) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, typeIdCard, idCard, BirthDate, nationality, gender, status);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", typeIdCard='" + typeIdCard + '\'' +
                ", idCard='" + idCard + '\'' +
                ", BirthDate=" + BirthDate +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                ", status=" + status +
                '}';
    }
}
