package com.aln.esceulamusicabackend.Model.Person;

import java.util.Objects;

public class Address {
    private int id;
    private int idPerson;
    private String province;
    private String canton;
    private String district;
    private String fullAddress;
    private boolean status;

    public Address() {
    }

    public Address(int id, int idPerson, String province, String canton, String district, String fullAddress, boolean status) {
        this.id = id;
        this.idPerson = idPerson;
        this.province = province;
        this.canton = canton;
        this.district = district;
        this.fullAddress = fullAddress;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
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
        Address address = (Address) o;
        return id == address.id && idPerson == address.idPerson && status == address.status && Objects.equals(province, address.province) && Objects.equals(canton, address.canton) && Objects.equals(district, address.district) && Objects.equals(fullAddress, address.fullAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPerson, province, canton, district, fullAddress, status);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", idPerson=" + idPerson +
                ", province='" + province + '\'' +
                ", canton='" + canton + '\'' +
                ", district='" + district + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                ", status=" + status +
                '}';
    }
}
