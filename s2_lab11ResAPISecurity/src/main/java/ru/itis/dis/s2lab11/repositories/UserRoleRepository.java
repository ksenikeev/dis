package ru.itis.dis.s2lab11.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.dis.s2lab11.model.UserRole;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRole,Long> {

    @Query("select r from User u join u.roles r where u.id = :user_id")
    List<UserRole> findByUser(@Param("user_id") Long user_id);
}
