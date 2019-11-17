package sample.database.dao;

import sample.database.entities.Adress;

import java.util.List;

public interface AdressInterfaceDao {

    Adress getAdressByUserId(long userId, String baseName);

    List<Adress> getAllAdressByUserId(String baseName);
}