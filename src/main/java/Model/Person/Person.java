package Model.Person;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {


   private int id;
   private String name;
   private String lastname;
   private String typeIdCard;
   private String idCard;
   private LocalDateTime BirthDate;
   private String nationality;
   private String gender;
   private boolean status;

}
