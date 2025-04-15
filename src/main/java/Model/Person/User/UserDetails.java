package Model.Person.User;

import lombok.Data;
import java.sql.Timestamp;

@Data
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
}
