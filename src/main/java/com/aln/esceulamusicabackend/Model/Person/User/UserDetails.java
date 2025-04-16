package com.aln.esceulamusicabackend.Model.Person.User;

import java.util.Objects;

public class UserDetails {
    private int userId;
    private String userName;
    private String email;
    private String rolUser;
    private String provider;
    private String avatarUrl;

    private int personId;
    private String name;
    private String lastname;
    private String nationality;
    private String gender;

    private String province;
    private String canton;
    private String district;
    private String fullAddress;

    public UserDetails() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRolUser() {
        return rolUser;
    }

    public void setRolUser(String rolUser) {
        this.rolUser = rolUser;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails that = (UserDetails) o;
        return userId == that.userId && personId == that.personId && Objects.equals(userName, that.userName) && Objects.equals(email, that.email) && Objects.equals(rolUser, that.rolUser) && Objects.equals(provider, that.provider) && Objects.equals(avatarUrl, that.avatarUrl) && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(nationality, that.nationality) && Objects.equals(gender, that.gender) && Objects.equals(province, that.province) && Objects.equals(canton, that.canton) && Objects.equals(district, that.district) && Objects.equals(fullAddress, that.fullAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, email, rolUser, provider, avatarUrl, personId, name, lastname, nationality, gender, province, canton, district, fullAddress);
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", rolUser='" + rolUser + '\'' +
                ", provider='" + provider + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", personId=" + personId +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                ", province='" + province + '\'' +
                ", canton='" + canton + '\'' +
                ", district='" + district + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }
}
