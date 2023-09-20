package com.example.crudapp.StaffDTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuffDTO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_staff;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;

}
