package sample.database.dao;

import sample.database.entities.Address;
import sample.database.sql.ComunicationWithBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDao implements AddressInterfaceDao {

    /**
     * This method provide address from other database by userId.
     * @param userId provide user id.
     * @param baseName provide name of base where user is.
     */
    public Address getAddressByUserId(long userId, String baseName){
        Connection connection = ComunicationWithBase.connect(baseName);
        try(Statement statment = connection.createStatement()){
            ResultSet resultSets = statment.executeQuery("SELECT * FROM adress WHERE userId=" + userId);
            if(resultSets.next()){
                Address address = new Address();
                address.setFirst(resultSets.getString("address"));

                return address;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * This method provide list of Address object.
     * @param baseName provide name of base where user is.
     */
    @Override
    public List<Address> getAllAdressByUserId(String baseName) {
        Connection connection = ComunicationWithBase.connect(baseName);
        try(Statement statment = connection.createStatement()){
            List<Address> addresses = new ArrayList<>();
            ResultSet resultSets = statment.executeQuery("SELECT * FROM addresses");
            while (resultSets.next()) {
                Address address = new Address();
                address.setFirst(resultSets.getString("firstAdres"));
                addresses.add(address);
            }
            return addresses;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
