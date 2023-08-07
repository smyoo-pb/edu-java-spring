package com.precisionbio.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // 1: Launch a Spring Context

        // private resource
        // closeable객체 관련하여 자동으로 리소스를 반납
        // 예외 발생 시, 자원이 반납 되지 않는 문제 예방
        try (var context = new AnnotationConfigApplicationContext(HellowWorldConfiguration.class)) {

            // 2: Configure the things that we want Spring to manage
            // HelloWorldConfiguration - @Configuration
            // name - @Bean

            // 3: Retrieving Beans Managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("address2"));

            // reason: Address객체를 리턴하는 Bean이 2개 이상이기 때문에 class name으로 찾을 수 없음
            // @Primary 어노테이션을 활용하여 같은 객체를 리턴하는 메서드에 우선순위를 매겨주면 된다.
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean(Person.class));

            // @Qualifier 한정자로 별칭 정도로 생각할 수 있다.
            System.out.println(context.getBean("person5Qualifier"));
            // Spring Bean 모두 나열
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}