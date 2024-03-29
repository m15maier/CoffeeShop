package ee.coffee.coffeeshop.dto;

import lombok.Data;

@Data   // getter + setter + required args + to string + equals
public class UserInfoDTO
{
    private String name;

    private String email;

    private String address;

    private String phone;
}
