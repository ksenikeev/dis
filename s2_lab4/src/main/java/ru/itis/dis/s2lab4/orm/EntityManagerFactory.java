package ru.itis.dis.s2lab4.orm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EntityManagerFactory {

    private CharSequence url;

    private Connection connection;

    private Map<Long, EntityManager> entityManagerMap = new HashMap<>();

    private Map<String, Map<String, Class>> structureDB;

    public EntityManagerFactory() {
    }

    public void scanDB() {
        // structureDB
    }

    public EntityManagerFactory(CharSequence url) {
        this.url = url;
    }

    private Connection getConnection() {
        // DB connection
        return null;
    }

    public EntityManager getEntityManager() {
        Long id = Thread.currentThread().getId();
        EntityManager em = entityManagerMap.get(id);
        if (em == null) {
            em = new EntityManagerImpl();
        }
        return em;
    }

    public void closeEntityManager() {
        Long id = Thread.currentThread().getId();
        entityManagerMap.remove(id);
    }

    public String testDbWork() {
        return this.toString();
    }

    public void destroy() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            System.out.println("DbWork destroed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
