package io.gmasnou.springframework.samples.beans;

import io.gmasnou.springframework.samples.beans.configuration.InfraConfigurationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeansCreationTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {

        this.applicationContext = new AnnotationConfigApplicationContext(InfraConfigurationTest.class);
    }

    @Test
    public void test() {

    }
}
