package contact;

import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Contact {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Use automatic ID generation
    private String id;

    @NotNull
    @Size(min=1, message = "名至少一个")
    private String firstName;

    @NotNull
    @Size(min=1, message = "姓氏至少一个")
    private String lastName;

    @Pattern(regexp = "^1([34578])\\d{9}", message = "无效手机号")
    private String phoneNumber;

    @NotBlank
    @Email
    private String emailAddress;
}
