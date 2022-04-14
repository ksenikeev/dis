package ru.itis.dis.s2lab8;

import ru.itis.dis.s2lab8.models.Admin;
import ru.itis.dis.s2lab8.models.User;
import ru.itis.dis.s2lab8.models.UserData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String ... args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab8");

        EntityManager em = emf.createEntityManager();

        User user = new User();
        user.setName("Kamil");
        user.setPassword("1234");
        user.setPassport("111111");

        Admin admin = new Admin();
        admin.setName("admin");
        admin.setRole("ADMIN");
        admin.setPassport("222222");


        UserData userData = new UserData();
        userData.setPassport("33333");

        em.getTransaction().begin();

        em.persist(user);
        em.persist(admin);
        em.persist(userData);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
