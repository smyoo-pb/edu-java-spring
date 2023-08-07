package com.precisionbio.learnspringframework.example.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration 어노테이션으로 Context 등록
 * ComponentScan 어노테이션으로 현재 패키지의 Spring Bean 탐색
 */
@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(
                RealWorldSpringContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}
