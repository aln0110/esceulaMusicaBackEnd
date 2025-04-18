package com.aln.esceulamusicabackend.Model.Person.User;

import java.sql.Timestamp;
import java.util.Objects;

public class Users {
    private int id;
    private int idPerson;
    private String userRol;
    private String userName;
    private String email;
    private String password;
    private String provider;
    private String oAuthId;
    private String avatarUrl;
    private Timestamp createdAt;
    private Timestamp lastLogin;
    private boolean status;

    public Users() {
    }

    public Users(int id, int idPerson, String userRol, String userName, String email, String password, String provider, String oAuthId, String avatarUrl, Timestamp createdAt, Timestamp lastLogin, boolean status) {
        this.id = id;
        this.idPerson = idPerson;
        this.userRol = userRol;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.provider = provider;
        this.oAuthId = oAuthId;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
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

    public String getUserRol() {
        return userRol;
    }

    public void setUserRol(String userRol) {
        this.userRol = userRol;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getOAuthId() {
        return oAuthId;
    }

    public void setOAuthId(String oAuthId) {
        this.oAuthId = oAuthId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
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
        Users users = (Users) o;
        return id == users.id && idPerson == users.idPerson && status == users.status && Objects.equals(userRol, users.userRol) && Objects.equals(userName, users.userName) && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(provider, users.provider) && Objects.equals(oAuthId, users.oAuthId) && Objects.equals(avatarUrl, users.avatarUrl) && Objects.equals(createdAt, users.createdAt) && Objects.equals(lastLogin, users.lastLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPerson, userRol, userName, email, password, provider, oAuthId, avatarUrl, createdAt, lastLogin, status);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", idPerson=" + idPerson +
                ", userRol='" + userRol + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", provider='" + provider + '\'' +
                ", oAuthId='" + oAuthId + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createdAt=" + createdAt +
                ", lastLogin=" + lastLogin +
                ", status=" + status +
                '}';
    }
}
