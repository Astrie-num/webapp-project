package exam.project.project.dao;

import java.sql.*;
import java.util.ArrayList;
import


public class UserDao {
private Connection connection;

public UserDao() {
    this.connection = DriverManager.getConnection();
}


public List<Pet> getAllPets(){
    List<Pet> cats = new ArrayList<>();

    try{
        String query = "SELECT * FROM pets";

        try(PreparedStatement statement = connection.prepareStatement(query));
        ResultSet resultSet =statement.executeQuery()) {

        while(resultSet.next()){
            Pet cat =new Pet();
            cat.setId(resultSet.getInt("id"));
            cat.setCode(resultSet.getString("pet_code"));
            cat.setName(resultSet.getString("name"));
            cat.setOwner(resultSet.getString("owner"));
            cat.setLocation(resultSet.getString("location"));
            cats.add(cat);
        }
        };
    } catch(SQLException e){
        e.printStackTrace();
    }
    return cats;
}



public booleanregisterCat(Pet pet){
    try{
        String sql = "INSERT INTO pets(pet_code, name, owner, location) VALUES(?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, pet.pet_code);
            statement.setString(2, pet.getName);
            statement.setString(3, pet.getOwner);
            statement.setString(4, pet.getLocation);


            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        }

    }catch(SQLException e) {
        throw new RuntimeException(e);
        e.printStackTrace();
    }

}


public boolean login_validatePet(Pet pet) {
    try{
        String sql = "SELECT * FROM pet WHERE  id = ? AND pet_code = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatement.setInt(1, pet.getId());
            prepareStatement.setString(2, pet.getCode());
            try(ResultSet resultSet = prepareStatement.executeQuery()){
                return resultSet.next();
            }
        }
    }
    catch( SQLException e){
e.printStackTrace(e);
    }

    return false;
}

public Pet getPetByCode(String pet_code) {
try{
    String sql = "SELECT * FROM pets WHERE pet_code = ?";
    try(PreparedStatement statement = connection.prepareStatement(sql)){
        prepareSatement.setString(1, pet_code);
        try(ResultSet resultSet = prepareStatement.executeQuery()){
            if(resultSet.next()) {
                Pet loggedInPet = new Pet(
                    resultSet.getString("pet_code");
                    resultSet.getString("name");
                    resultSet.getString("owner");
                    resultSet.getString("location");
                        );

                return loggedInPet;
            }
        }
    }

}
catch(SQLException e) {
    e.printStackTrace(e);
}
    return null;
}
}
