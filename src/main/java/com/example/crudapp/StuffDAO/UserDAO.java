package com.example.crudapp.StuffDAO;

import com.example.crudapp.DB.DBConnector;
import com.example.crudapp.StaffDTO.StuffDTO;
import com.example.crudapp.StaffDTO.UserDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final DBConnector dbConnector = DBConnector.INSTANCE;

    private PreparedStatement preparedStatement;

    public List<UserDTO> getListUsers()  {
        List<UserDTO> usersList = new ArrayList<>();
        try{
            ResultSet resultSet = dbConnector.getConnection().createStatement().executeQuery("SELECT * FROM users");
            while (resultSet.next()){
                UserDTO userDTO = new UserDTO();
                userDTO.setId_user(resultSet.getInt(1));
                userDTO.setLogin(resultSet.getString(2));
                userDTO.setPassword(resultSet.getString(3));
                userDTO.setRole(resultSet.getString(4));
                usersList.add(userDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(usersList.size()==0){
            return null;
        }
        return usersList;
    }

    public void deleteUser(Integer id){
        try {
            preparedStatement = dbConnector.getConnection().prepareStatement("DELETE FROM users WHERE id_users=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addUser(UserDTO userDTO){
        try{
            preparedStatement = dbConnector.getConnection().prepareStatement("INSERT INTO users (login,password,role,email) VALUES(?,?,?,?)");
            preparedStatement.setString(1,userDTO.getLogin());
            preparedStatement.setString(2,userDTO.getPassword());
            preparedStatement.setString(3,"Пользователь");
            preparedStatement.setString(4,userDTO.getEmail());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public boolean checkAuth(UserDTO userCheck){
        List<UserDTO> listUsers = getListUsers();
        for(UserDTO userDTO:listUsers){
            if(userCheck.getLogin().equals(userDTO.getLogin()) && userCheck.getPassword().equals(userDTO.getPassword())){
                return true;
            }
        }
        return false;
    }
//    public void editStuff(StuffDTO stuffDTO){
//        try{
//            preparedStatement = dbConnector.getConnection().prepareStatement("UPDATE stuff SET first_name=?,last_name=?,phone_number=?,role=? WHERE id_stuff=?");
//            preparedStatement.setString(1,stuffDTO.getFirstName());
//            preparedStatement.setString(2,stuffDTO.getLastName());
//            preparedStatement.setString(3,stuffDTO.getPhoneNumber());
//            preparedStatement.setString(4,stuffDTO.getRole());
//            preparedStatement.setInt(5,stuffDTO.getId_staff());
//            preparedStatement.execute();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
}
