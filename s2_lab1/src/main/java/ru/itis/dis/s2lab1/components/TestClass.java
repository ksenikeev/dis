package ru.itis.dis.s2lab1.components;

import ru.itis.dis.s2lab1.annotations.Component;
import ru.itis.dis.s2lab1.annotations.Inject;

@Component
public class TestClass {

    @Inject(singleton = true)
    public TestComponent testComponent;

    public void print() {
        System.out.println(testComponent.getComponentInfo());
    }

}
/*

    TestClass  ---> testComponent ---> TestComponent


 */