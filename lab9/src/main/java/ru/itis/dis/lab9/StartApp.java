package ru.itis.dis.lab9;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartApp implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application context start");
        DbWork.getInstance();
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

}
