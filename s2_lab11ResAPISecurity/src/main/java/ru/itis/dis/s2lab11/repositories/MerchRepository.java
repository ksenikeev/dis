package ru.itis.dis.s2lab11.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.dis.s2lab11.model.Merch;
import java.util.List;

public interface MerchRepository extends CrudRepository<Merch, Long> {

    @Query("select m from Merch m where UPPER(name) like '%'|| :name ||'%' ")
    List<Merch> findByName(@Param("name") String name);

    @Query("select m from Merch m where code like :code ||'%' ")
    List<Merch> findByCode(@Param("code") String code);

}
