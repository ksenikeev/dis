package ru.itis.dis.s2lab4.orm;

public class DbWork {

    private CharSequence url;

    public DbWork() {
    }

    public DbWork(CharSequence url) {
        this.url = url;
    }

    public String testDbWork() {
        return this.toString();
    }

    public void destroy() {
        System.out.println("DbWork destroed");
    }
}
