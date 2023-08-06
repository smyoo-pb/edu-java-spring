package com.precisionbio.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// JDK 16에서 추가된 유형
// setter, getter 생성을 자동화하여 귀찮음을 덜어 준다.
record Person(String name, int age, Address address) {
}

record Address(String firstLine, String city) {
}

@Configuration
public class HellowWorldConfiguration {

    @Bean // spring container가 관리
    public String name() {
        return "smyoo-pb";
    }

    @Bean
    public int age() {
        return 100;
    }

    @Bean
    public Person person() {
        return new Person("smyoo-pb", 1024, new Address("Guro gu", "Seoul"));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3Qualifier") Address address) {
        return new Person(name, age, address);
    }

    // custom bean name
    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("Seocho gu", "Seoul");
    }

    // custom bean name
    @Bean(name = "address3")
    @Qualifier("address3Qualifier")
    public Address address3() {
        return new Address("Gangnam gu", "Seoul");
    }
}
