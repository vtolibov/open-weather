package uz.open.weather.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserManagementService {

    <T> Flux<T> getAllUsers();

    <T> Mono<T> createUser(T user);

    <T, U> Mono<T> updateUser(U user);

    <ID> void deleteUser(ID id);

    <T, ID> Mono<T> getUser(ID id);

}
