package uz.open.weather.service;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UserManagementService<T, ID> {

    Flux<T> getAllUsers();

    Mono<T> createUser(T user);

    Mono<T> updateUser(T user);

    void deleteUser(ID id);

    Mono<T> getUser(ID id);

}
