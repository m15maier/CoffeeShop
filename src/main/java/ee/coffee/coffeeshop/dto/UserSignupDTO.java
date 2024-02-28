package ee.coffee.coffeeshop.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data   // getter + setter + required args + to string + equals
public class UserSignupDTO {
    
    @NotBlank(message ="Name must not be blank")
    private String name;
    
    @Email(message ="Please provide a valid email address")
    private String email;

    @NotBlank(message ="Address must not be blank")
    private String address;

    @NotBlank(message ="Please provide digits for phone")
    @Digits(integer = 11, fraction = 0)
    private String phone;
    
    @NotBlank(message ="password must not be blank")
    private String password;
    
    @NotBlank(message ="password confirm must not be blank")
    private String passwordConfirm;
}
