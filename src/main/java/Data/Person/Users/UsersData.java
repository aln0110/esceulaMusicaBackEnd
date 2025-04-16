package Data.Person.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

//import java.util.ArrayList;
import java.util.List;

//import Data.DataBase;
import Model.Person.User.Users;

@Repository
public class UsersData {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addUser(Users user){
        String sql = "INSERT INTO person.tbUser (id_persona, rol_user, user_name, email, password, provider, oauth_id, avatar_url, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println("Holaaaaaaaaa?");
        try {
            System.out.println("Trying to add user...");
            jdbcTemplate.update(sql, user.getIdPerson(), user.getUserRol(), user.getUserName(), user.getEmail(), user.getPassword(), user.getProvider(), user.getOAuthId(), user.getAvatarUrl(), user.isStatus());
            return  true;
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
            e.printStackTrace();
            return false;
        }

    }

    public boolean updateUser(Users user) {
        String sql = "UPDATE person.tbUser SET id_persona = ?, rol_user = ?, user_name = ?, email = ?, password = ?, provider = ?, oauth_id = ?, avatar_url = ?, created_at = ?, last_login = ?, status = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, user.getIdPerson(), user.getUserRol(), user.getUserName(), user.getEmail(), user.getPassword(), user.getProvider(), user.getOAuthId(), user.getAvatarUrl(), user.getCreatedAt(), user.getLastLogin(), user.isStatus(), user.getId());
            return true;
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
            return false;
        }
    }

    public boolean logicalDeleteUser(int id) {
        String sql = "UPDATE person.tbUser SET status = false WHERE id = ?";
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

    public Users login(String email, String password) {
        String sql = "SELECT * FROM person.tbUser WHERE email = ?";
        try {
            Users user = jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) -> {
                Users u = new Users();
                u.setPassword(rs.getString("password"));
                u.setId(rs.getInt("id"));
                u.setIdPerson(rs.getInt("id_persona"));
                u.setUserRol(rs.getString("rol_user"));
                u.setUserName(rs.getString("user_name"));
                u.setEmail(rs.getString("email"));
                u.setProvider(rs.getString("provider"));
                u.setOAuthId(rs.getString("oauth_id"));
                u.setAvatarUrl(rs.getString("avatar_url"));
                u.setCreatedAt(rs.getTimestamp("created_at"));
                u.setLastLogin(rs.getTimestamp("last_login"));
                u.setStatus(rs.getBoolean("status"));
                return u;
            });

            if (user != null && new BCryptPasswordEncoder().matches(password, user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
            System.out.println("Error logging in: " + e.getMessage());
        }
        return null; // Invalid credentials
    }



}
