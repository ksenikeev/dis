package ru.itis.dis.s2lab1.components;

import ru.itis.dis.s2lab1.annotations.Component;

@Component(name="test")
public class TestComponent {

    public String getComponentInfo() {
        return "Hello from TestComponent!";
    }

    public TestComponent() {
    }
}
