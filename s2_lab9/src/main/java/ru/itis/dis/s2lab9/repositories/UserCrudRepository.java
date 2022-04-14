package ru.itis.dis.s2lab9.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.dis.s2lab9.models.User;
import ru.itis.dis.s2lab9.models.UserData;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByNameAndId(String name, Long id);

    @Query("select u from User u where upper(name) = :name")
    List<User> findByNameUpperCase(@Param("name") String name);

    @Query("select u.userData from User u where name = :name")
    List<UserData> findUserData(@Param("name") String name);

}
