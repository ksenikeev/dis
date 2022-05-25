package ru.itis.dis.s2lab11.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.dis.s2lab11.model.User;
import ru.itis.dis.s2lab11.model.UserRole;

public interface UserRepository extends CrudRepository<User, Long> {

    /*
        Здесь можно было получить результат без аннотации @Query, но  тогда мы получаем
        проблему с ленивой (LAZY) загрузкой ролей пользователя

        В запросе @Query мы заставляем Hibernate загрузить роли пользователя
     */
    @Query("select u from User u LEFT JOIN FETCH u.roles where u.userName = :name ")
    User findByUserName(@Param("name") String name);

    @Query("select r from UserRole r where id = :id ")
    UserRole findRoleById(@Param("id") Long id);
}
