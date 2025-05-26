package com.aln.esceulamusicabackend.Data.Person.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aln.esceulamusicabackend.Model.Person.User.Users;

import java.util.List;

@Repository
public class UsersData {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addUser(Users user){
        String sql = "INSERT INTO [argyranthemum].[person].[tbUser] (id_persona, rol_user, user_name, email, password, provider, oauth_id, avatar_url, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
   
            jdbcTemplate.update(sql, user.getIdPerson(), user.getUserRol(), user.getUserName(), user.getEmail(), user.getPassword(), user.getProvider(), user.getOAuthId(), user.getAvatarUrl(), user.isStatus());
            return  true;
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
            e.printStackTrace();
            return false;
        }

    }

    public boolean updateUser(Users user) {
        String sql = "UPDATE [argyranthemum].[person].[tbUser] SET id_persona = ?, rol_user = ?, user_name = ?, email = ?, password = ?, provider = ?, oauth_id = ?, avatar_url = ?, created_at = ?, last_login = ?, status = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, user.getIdPerson(), user.getUserRol(), user.getUserName(), user.getEmail(), user.getPassword(), user.getProvider(), user.getOAuthId(), user.getAvatarUrl(), user.getCreatedAt(), user.getLastLogin(), user.isStatus(), user.getId());
            return true;
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
            return false;
        }
    }

    public boolean logicalDeleteUser(int id) {
        String sql = "UPDATE [argyranthemum].[person].[tbUser] SET status = false WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
            return true;
        } catch (Exception e) {
            System.out.println("Error logically deleting user: " + e.getMessage());
            return false;
        }
    }


    public boolean deleteUser(int id) {
        String sql = "DELETE FROM person.tbUserWHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
            return false;
        }
    }


    public Users getUserById(int id) {
        String sql = "SELECT * FROM person.tbUser WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setIdPerson(rs.getInt("id_persona"));
                user.setUserRol(rs.getString("rol_user"));
                user.setUserName(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setProvider(rs.getString("provider"));
                user.setOAuthId(rs.getString("oauth_id"));
                user.setAvatarUrl(rs.getString("avatar_url"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setLastLogin(rs.getTimestamp("last_login"));
                user.setStatus(rs.getBoolean("status"));
                return user;
            });
        } catch (Exception e) {
            System.out.println("Error finding user by id: " + e.getMessage());
            return null;
        }
    }
    public Users getUserByEmail(String email) {
        String sql = "SELECT * FROM person.tbUser WHERE email = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) -> {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setIdPerson(rs.getInt("id_persona"));
                user.setUserRol(rs.getString("rol_user"));
                user.setUserName(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setProvider(rs.getString("provider"));
                user.setOAuthId(rs.getString("oauth_id"));
                user.setAvatarUrl(rs.getString("avatar_url"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setLastLogin(rs.getTimestamp("last_login"));
                user.setStatus(rs.getBoolean("status"));
                return user;
            });
        } catch (Exception e) {
            System.out.println("Error finding user by email: " + e.getMessage());
            return null;
        }
    }

    public List<Users> getAllUsers() {
        String sql = "SELECT * FROM person.tbUser";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setIdPerson(rs.getInt("id_persona"));
                user.setUserRol(rs.getString("rol_user"));
                user.setUserName(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setProvider(rs.getString("provider"));
                user.setOAuthId(rs.getString("oauth_id"));
                user.setAvatarUrl(rs.getString("avatar_url"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setLastLogin(rs.getTimestamp("last_login"));
                user.setStatus(rs.getBoolean("status"));
                return user;
            });
        } catch (Exception e) {
            System.out.println("Error retrieving all users: " + e.getMessage());
            return null;
        }
    }

    public Users login(String email) {
        String sql = "SELECT * FROM [argyranthemum].[person].[tbUser] WHERE email = ?";
        try {
            return jdbcTemplate.query(sql, ps -> ps.setString(1, email), rs -> {
                if (rs.next()) {
                    Users user = new Users();
                    user.setId(rs.getInt("id"));
                    user.setIdPerson(rs.getInt("id_persona"));
                    user.setUserRol(rs.getString("rol_user"));
                    user.setUserName(rs.getString("user_name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setProvider(rs.getString("provider"));
                    user.setOAuthId(rs.getString("oauth_id"));
                    user.setAvatarUrl(rs.getString("avatar_url"));
                    user.setCreatedAt(rs.getTimestamp("created_at"));
                    user.setLastLogin(rs.getTimestamp("last_login"));
                    user.setStatus(rs.getBoolean("status"));
                    return user;
                }
                return null;
            });
        } catch (Exception e) {
            System.out.println("Error logging in: " + e.getMessage());
            return null;
        }
    }



}
