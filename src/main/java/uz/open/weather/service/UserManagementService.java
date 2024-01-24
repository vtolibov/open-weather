package uz.open.weather.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserManagementService<T, ID> {

    List<T> getAllUsers();


    T createUser(T user);

    T updateUser(T user);

    void deleteUser(ID id);

    T getUser(ID id);

}
