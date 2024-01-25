package uz.open.weather.service;


import java.util.List;

public interface UserManagementService<T, ID> {

    List<T> getAllUsers();

    T createUser(T user);

    T updateUser(T user);

    void deleteUser(ID id);

    T getUser(ID id);

}
