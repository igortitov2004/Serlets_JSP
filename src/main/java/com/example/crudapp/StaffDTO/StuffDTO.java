package com.example.crudapp.StaffDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuffDTO {
    private int id_staff;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
//    private int age;
}
