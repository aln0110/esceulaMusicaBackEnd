package Model.Person;

import lombok.*;
import org.w3c.dom.Text;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private int id;
    private int idPerson;
    private String province;
    private String canton;
    private String district;
    private String fullAddress;
    private boolean status;
}
