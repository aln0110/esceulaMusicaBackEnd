package Data.Person.Users;

import  Model.Person.User.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDetailsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDetails getUserDetailsById(int userId){

        String sql = """
            SELECT u.id AS user_id, u.user_name, u.email, u.rol_user, u.provider, u.avatar_url,
                   p.id AS person_id, p.name, p.lastname, p.nationality, p.gender,
                   a.province, a.canton, a.district, a.full_address
            FROM tbUser u
            JOIN tbPerson p ON u.id_persona = p.id
            LEFT JOIN tbAddress a ON p.id = a.id_persona AND a.status = true
            WHERE u.id = ?
        """;

        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{userId}, (rs, rowNum) -> {
                UserDetails dto = new UserDetails();
                dto.setUserId(rs.getInt("user_id"));
                dto.setUserName(rs.getString("user_name"));
                dto.setEmail(rs.getString("email"));
                dto.setRolUser(rs.getString("rol_user"));
                dto.setProvider(rs.getString("provider"));
                dto.setAvatarUrl(rs.getString("avatar_url"));
                dto.setPersonId(rs.getInt("person_id"));
                dto.setName(rs.getString("name"));
                dto.setLastname(rs.getString("lastname"));
                dto.setNationality(rs.getString("nationality"));
                dto.setGender(rs.getString("gender"));
                dto.setProvince(rs.getString("province"));
                dto.setCanton(rs.getString("canton"));
                dto.setDistrict(rs.getString("district"));
                dto.setFullAddress(rs.getString("full_address"));
                return dto;
            });
        } catch (Exception e) {
            System.out.println("Error getting user details: " + e.getMessage());
            return null;
        }

    }

}
