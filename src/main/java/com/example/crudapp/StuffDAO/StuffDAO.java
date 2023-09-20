package com.example.crudapp.StuffDAO;

import com.example.crudapp.DB.DBConnector;
import com.example.crudapp.StaffDTO.StuffDTO;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuffDAO {
    private final DBConnector dbConnector = DBConnector.INSTANCE;

    private PreparedStatement preparedStatement;

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
         if(stuffList.size()==0){
             return null;
         }
         return stuffList;
    }

    public void deleteStuff(Integer id){
        try {
            preparedStatement = dbConnector.getConnection().prepareStatement("DELETE FROM stuff WHERE id_stuff=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addStaff(StuffDTO stuffDTO){
        try{
            preparedStatement = dbConnector.getConnection().prepareStatement("INSERT INTO stuff (first_name,last_name,phone_number,role) VALUES(?,?,?,?)");

            preparedStatement.setString(1,stuffDTO.getFirstName());
            preparedStatement.setString(2,stuffDTO.getLastName());
            preparedStatement.setString(3,stuffDTO.getPhoneNumber());
            preparedStatement.setString(4,stuffDTO.getRole());
            preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
