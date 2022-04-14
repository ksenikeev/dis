package ru.itis.dis.s2lab7.service;

import org.springframework.stereotype.Component;
import ru.itis.dis.s2lab7.controllers.Profiling;

@Component
@Profiling
public class TestProfilingImpl implements TestProfiling {
    public void test() {
        System.out.println("test");
    }
}
