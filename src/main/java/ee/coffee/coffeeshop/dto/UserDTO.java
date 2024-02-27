package ee.coffee.coffeeshop.dto;

import ee.coffee.coffeeshop.enums.Role;
import jakarta.persistence.Id;
import lombok.Data;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data   // getter + setter + required args + to string + equals
public class UserDTO {
    
    @Id
    private Long id;
    
    @NotBlank(message ="Name must not be blank")
    private String username;

    @Email(message ="Please provide a valid email address")
    private String email;

    @NotBlank(message ="First name must not be blank")
    private String address;

    @NotBlank(message ="First name must not be blank")
    @Digits(integer = 5, fraction = 0)
    private String phone;
    
    private boolean active;
    
    private Role role;
}
