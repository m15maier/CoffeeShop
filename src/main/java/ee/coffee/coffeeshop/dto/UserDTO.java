package ee.coffee.coffeeshop.dto;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data   // getter + setter + required args + to string + equals
public class UserDTO {

    @NotBlank(message ="First name must not be blank")
    private String name;

    @Email(message ="Please provide a valid email address")
    private String email;

    @NotBlank(message ="The field must not be blank")
    private String password;

    @NotBlank(message ="First name must not be blank")
    private String address;

    @NotBlank(message ="First name must not be blank")
    @Digits(integer = 5, fraction = 0)
    private String phone;
}
