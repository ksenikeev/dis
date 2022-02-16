package ru.itis.dis.s2lab1.components;


import ru.itis.dis.s2lab1.annotations.Component;
import ru.itis.dis.s2lab1.annotations.Inject;

@Component
public class Main implements Runnable {

    @Inject
    private TestComponent testComponent;

    @Override
    public void run() {
        System.out.println(testComponent.getComponentInfo());
    }
}
