package com.example.crudapp.StaffDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id_user;
    private String login;
    private String password;
    private String role;

    private String email;
}
