package contact;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Contact {
    private Long id;

    @NotNull
    @Size(min=1,message = "名至少一个")
    private String firstName;

    @NotNull
    @Size(min=1,message = "姓氏至少一个")
    private String lastName;

    @Pattern(regexp = "^1([34578])\\d{9}",message = "无效手机号")
    private String phoneNumber;

    @NotBlank
    @Email
    private String emailAddress;

 //   @Override
//    public String toString() {
//        return "Contact{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", emailAddress='" + emailAddress + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Contact contact = (Contact) o;
//        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(emailAddress, contact.emailAddress);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, lastName, phoneNumber, emailAddress);
//    }
}