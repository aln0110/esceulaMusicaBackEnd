package Model.Person.User;

import lombok.*;
import org.w3c.dom.Text;

import java.time.LocalDate;
import java.sql.Timestamp;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
