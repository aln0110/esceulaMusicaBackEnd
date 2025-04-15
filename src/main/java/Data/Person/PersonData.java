package Data.Person;
import Model.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;

import java.util.List;

@Repository
public class PersonData {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean addPerson(Person person) {
        String sql = "INSERT INTO tbPerson (name, lastname, type_idcard, idcard, birth_date, nationality, gender, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            jdbcTemplate.update(sql, person.getName(), person.getLastname(), person.getTypeIdCard(), person.getIdCard(), Date.valueOf(person.getBirthDate().toLocalDate()), person.getNationality(), person.getGender(), person.isStatus());
            return true;
        } catch (Exception e) {
            System.out.println("Error adding person: " + e.getMessage());
            return false;
        }
    }

    public boolean updatePerson(Person person) {
        String sql = "UPDATE tbPerson SET name = ?, lastname = ?, type_idcard = ?, idcard = ?, birth_date = ?, nationality = ?, gender = ?, status = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, person.getName(), person.getLastname(), person.getTypeIdCard(), person.getIdCard(), Date.valueOf(person.getBirthDate().toLocalDate()), person.getNationality(), person.getGender(), person.isStatus(), person.getId());
            return true;
        } catch (Exception e) {
            System.out.println("Error updating person: " + e.getMessage());
            return false;
        }
    }

    public boolean logicalDeletePerson(int id) {
        String sql = "UPDATE tbPerson SET status = false WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
            return true;
        } catch (Exception e) {
            System.out.println("Error logically deleting person: " + e.getMessage());
            return false;
        }
    }

    public boolean deletePerson(int id) {
        String sql = "DELETE FROM tbPerson WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting person: " + e.getMessage());
            return false;
        }
    }

    public Person getPersonById(int id) {
        String sql = "SELECT * FROM tbPerson WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setLastname(rs.getString("lastname"));
                person.setTypeIdCard(rs.getString("type_idcard"));
                person.setIdCard(rs.getString("idcard"));
                person.setBirthDate(rs.getDate("birth_date").toLocalDate().atStartOfDay());
                person.setNationality(rs.getString("nationality"));
                person.setGender(rs.getString("gender"));
                person.setStatus(rs.getBoolean("status"));
                return person;
            });
        } catch (Exception e) {
            System.out.println("Error finding person by ID: " + e.getMessage());
            return null;
        }
    }
    public int getIdPersonByIdCard(String idCard, String idCardType) {
        String sql = "SELECT id FROM tbPerson WHERE idcard = ? AND type_idcard = ?";
          int id = 0;
        try {
            id = jdbcTemplate.queryForObject(sql, new Object[]{idCard, idCardType}, Integer.class);

            return  id;
        }catch (Exception e) {
            System.out.println("Error finding person by ID card: " + e.getMessage());
            return  id;
        }

    }

    public List<Person> getAllPersons() {
        String sql = "SELECT * FROM tbPerson";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setLastname(rs.getString("lastname"));
                person.setTypeIdCard(rs.getString("type_idcard"));
                person.setIdCard(rs.getString("idcard"));
                person.setBirthDate(rs.getDate("birth_date").toLocalDate().atStartOfDay());
                person.setNationality(rs.getString("nationality"));
                person.setGender(rs.getString("gender"));
                person.setStatus(rs.getBoolean("status"));
                return person;
            });
        } catch (Exception e) {
            System.out.println("Error retrieving all persons: " + e.getMessage());
            return null;
        }
    }


}
