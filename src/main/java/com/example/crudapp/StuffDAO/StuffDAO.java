package com.example.crudapp.StuffDAO;

import com.example.crudapp.DB.DBConnector;
import com.example.crudapp.StaffDTO.StuffDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuffDAO {
    private final DBConnector dbConnector = DBConnector.INSTANCE;



    public List<StuffDTO> getListStuff()  {
        List<StuffDTO> stuffList = new ArrayList<>();
         try{
             ResultSet resultSet = dbConnector.getConnection().createStatement().executeQuery("SELECT * FROM stuff");
             while (resultSet.next()){
                 StuffDTO stuff = new StuffDTO();
                 stuff.setId_staff(resultSet.getInt(1));
                 stuff.setFirstName(resultSet.getString(2));
                 stuff.setLastName(resultSet.getString(3));
                 stuff.setPhoneNumber(resultSet.getString(4));
                 stuff.setRole(resultSet.getString(5));
//                 stuff.setAge(resultSet.getInt(6));
                 stuffList.add(stuff);
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
         return stuffList;
    }


}
