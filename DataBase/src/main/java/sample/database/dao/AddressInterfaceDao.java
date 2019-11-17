package sample.database.dao;

import sample.database.entities.Address;

import java.util.List;

public interface AddressInterfaceDao {

    Address getAddressByUserId(long userId, String baseName);

    List<Address> getAllAdressByUserId(String baseName);
}