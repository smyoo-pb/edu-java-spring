# section 5

## 학습 목표

-   Why Spring Boot?
    -   build web apps & REST API
    -   What is the need for Spring Boot?
-   What are the goals of Spring Boot?
-   How does Spring Boot Work?
-   Compare Sptring Boot vs Spring MVC vs Spring

## About Spring Boot

-   REST API 개발에 필요한 세팅이 쉽다.
    -   Spring Boot 설치와 함께 설치됨
-   반복되는 설정들을 설치와 함꼐 해결

-   빠른 빌드
    -   Spring initializr
    -   Spring Boot Starter Projects
    -   Spring Boot Auto Configuration
    -   Spring Boot Dev Tools
-   프로덕션 환경에서 필요한 기능들 제공
    -   Logging
    -   Different Configurations for Different Environments
        -   profiles, Configuration Properties
    -   Monitoring (Spring Boot Actuator)

## Spring Boot Starter Projects

-   Web Application & REST API - Spring Boot Starter Web
    -   spring-webmvc, spring-web, spring-boot-starter-tomcat, spring-boot-starter-json
-   Unit Tests - Spring Boot Starter Test
-   Talk to database using JPA - Spring Boot Starter Data JPA
-   Talk to database using JDBC - Spring Boot Starter JDBC
-   Secure your web application or REST API - Spring Boot Starter Security

## Spring Boot Auto Configuration

-   스프링 어플리케이션을 사용하기 위해서 많은 설정이 필요하다. 이 것들을 자동화 해준다.
    -   클래스 경로에 있는 프레임워크에 따라 생성된다.
-   기본 설정
    -   spring boot는 디폴트 설정을 제공하고 우리는 그것을 오버라이딩 할 수 있다.

### Positive matches

-   자동 설정된 설정들

### Negative matches

-   자동 설정되지 않은 설정들

## Spring Boot Dev Tools

개발 시, 변경사항을 자동으로 새로 고침해주는 의존성 패키지이다.

-   단, 의존성 패키지 새로 설치 시 다시 시작 해야 한다.
-   그 외의 configuration과 java 코드들은 대부분 수정 시 바로 반영된 결과를 확인할 수 있다.

## Profile

-   일반적으로 dev, QA, Stage, Prod 등등.. 다양한 개발환경이 존재한다.
-   개발환경에 따라 다양한 설정이 필요하다.

### profile 설정

-   resources/application.properties
    -   spring.profiles.active=dev => resources/application-dev.properties
    -   spring.profiles.active=qa => resources/application-qa.properties
    -   spring.profiles.active=stage => resources/application-stage.properties
    -   spring.profiles.active=prod => resources/application-prod.properties
-   resources/application-prod.properties

기본 application.properties의 적용된 기본 값은 active된 프로필보다 우선순위가 낮으니 주의 해야 한다.

## Configuration Properties

-   @ConfigurationProperties 어노테이션을 활용하여 application.properties의 값을 해당 클래스에 주입할 수 있다.

## Deployment

-   WAR: Apache Tomcat 제외 되어 빌드되기 때문에 서버에 tomcat이 설치 되어 있어야 한다.
-   JAR(Embedded Server): Apache Tomcat 포함되어 java만 설치 되어 있으면 실행가능

## Monitoring: Spring Actuator

**dependency:** spring-starter-actuator
**endpoint:** /acutator

스프링 부트 애플리케이션의 상태와 컨테이너에 등록된 정보들을 확인할 수 있다.

### beans

-   컨테이너에 등록된 모든 Spring Bean 확인
-   특정 항목이 자동 설정 되었는지 확인 할 수 있다.

### configprops

-   context에 등록된 configuration properties들 확인

### env

-   환경에 관련된 모든 정보 확인
    -   jvm, tomcat 등등..

### metrics

-   애플리케이션 시작 시간, 남은 디스크 공간, 디스크 사용량 등등..
-   애플리케이션의 상태 값들?
-   수치화 가능한 상태 값들을 확인할 수 있다.
    -   대부분의 값들이 개수, 용량, 크기 등등이다.
-   http.server.requests => 현재 서버에게 요청 가능한 요청들에 대한 정보

-   management.endpoints.web.exposure.include=\*
    -   end point 노출을 결정한다.
    -   '\*' 모든 end point 노출은 그만큼 많은 정보를 수집한다는 의미로 서버 리소스를 많이 사용하게 되니 명시적으로 설정하는 것을 추천한다.

## Spring Boot vs Spring MVC vs Spring

-   Spring Framework: DI(Dependency Injection)
    -   @Component, @Autowired, @ComponentScan 등등..
    -   DI만으로는 강력한 애플리케이션을 구현할 수 없다.
    -   다양한 다른 프레임워크들이 필요하다
        -   DB -> Hibernate, JPA
        -   Test -> Junit, Mockito
-   Spring MVC
    -   REST API, 웹 앱 구현에 집중됨
    -   @Controller, @RestController, @RequestMapping 등등
-   Spring Boot
    -   빠른 애플리케이션 빌드 목적
    -   Starter Projects
    -   Auto Configuration
    -   여러 비기능 요구사항(NFRs)
        -   Acutator
        -   Embedded Server
        -   Logging and Error Handling
        -   Profile & Configuration Properties
