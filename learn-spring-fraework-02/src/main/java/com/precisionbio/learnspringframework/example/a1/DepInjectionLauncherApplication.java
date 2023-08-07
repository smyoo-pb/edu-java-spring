package com.precisionbio.learnspringframework.example.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class MyBussinessClass {
    Dependency1 dependency1;
    Dependency2 dependency2;

    /**
     * @param dependency1
     * @param dependency2
     */
    public MyBussinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString() {
        return "MyBussinessClass{" +
                "dependency1=" + dependency1 +
                ", dependency2=" + dependency2 +
                '}';
    }

    /**
     * @return the dependency1
     */
    public Dependency1 getDependency1() {
        return dependency1;
    }

    /**
     * @param dependency1 the dependency1 to set
     */
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Dep1");
        this.dependency1 = dependency1;
    }

    /**
     * @return the dependency2
     */
    public Dependency2 getDependency2() {
        return dependency2;
    }

    /**
     * @param dependency2 the dependency2 to set
     */
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setter Dep2");
        this.dependency2 = dependency2;
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(
                DepInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(MyBussinessClass.class).toString());
        }
    }
}
