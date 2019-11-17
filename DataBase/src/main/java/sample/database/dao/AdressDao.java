package sample.database.dao;

import sample.database.entities.Adress;
import sample.database.entities.User;
import sample.database.sql.ComunicationWithBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdressDao implements AdressInterfaceDao{

    /**
     * This method provide adress from other database by userId.
     * @param userId provide user id.
     * @param baseName provide name of base where user is.
     */
    public Adress getAdressByUserId(long userId, String baseName){
        Connection connection = ComunicationWithBase.connect(baseName);
        try(Statement statment = connection.createStatement()){
            ResultSet resultSets = statment.executeQuery("SELECT * FROM adress WHERE userId=" + userId);
            if(resultSets.next()){
                Adress adress = new Adress();
                adress.setFirst(resultSets.getString("adress"));

                return adress;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * This method provide list of Adress object.
     * @param baseName provide name of base where user is.
     */
    @Override
    public List<Adress> getAllAdressByUserId(String baseName) {
        Connection connection = ComunicationWithBase.connect(baseName);
        try(Statement statment = connection.createStatement()){
            List<Adress>adress = new ArrayList<>();
            ResultSet resultSets = statment.executeQuery("SELECT * FROM adress");
            while (resultSets.next()) {
                Adress adres = new Adress();
                adres.setFirst(resultSets.getString("firstAdres"));
                adress.add(adres);
            }
            return adress;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
