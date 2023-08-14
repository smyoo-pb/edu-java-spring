# section 3

java spring 학습

## contents

-   의존성 주입
    -   Component Annotation

### Component Annotation

[example](./src/main/java/com/precisionbio/learnspringframework/GamingAppLauncherApplication.java)

-   Component 어노테이션 활용

    -   어노테이션 기반의 Configuration과 클래스패스 스캐닝을 사용 할 때, 자동 감지를 위해 사용된다.

    -   Bean는 수동으로 Configuration에 등록 해주어야 하지만 Component는 자동으로 탐색하여 Bean와 동일하게 객체를 주입할 수 있게 해주는 기능이다.

-   ComponentScan(“package-name“)

    -   자동으로 탐색을 하는 Component 어노테이션이 존재하는 package를 명시해야한다.
    -   명시하지 않을 경우 현재 패키지를 자동으로 탐색한다.

-   Component를 사용할 때에도 Primay, Qualifier 어노테이션을 활용하여 주입할 객체를 선택할 수 있다.

### 의존성 주입의 다양한 유형

-   생성자 주입
-   Setter 주입
-   Field 주입

#### Field 주입

-   Autowired 어노테이션 활용

#### 생성자 주입

-   생성자를 통하여 의존성을 주입 하는 방법이다.

-   Autowired 어노테이션을 사용하지 않고 생략하는 것을 권장하며, 의존성 주입 방식 중 생성자 주입을 권장한다.

    -   모든 초기화가 하나의 메서드에서 처리할 수 있기 때문에 초기화 시점에서 의존성 주입이 깔끔하게 완료 된다. 그래서 스프링은 생성자 주입을 권장하고 Autowired 어노테이션을 생략할 수 있게(다른 것 보다 사용하기 편하게) 만들었다.

### 용어 정리

-   **Component 어노테이션**: Component 어노테이션이 작성된 클래스의 인스턴스(Spring Bean)이 생성되고 Spring Framework에서 관리할 수 있게 된다.

-   **Dependency**: 의존성, 어느 A클래스가 어떤 B클래스 혹은 인터페이스의 기능(메서드)를 활용하는 경우 이 A클래스는 B클래스에게 의존성이 있다고 할 수 있다.

-   **Component Scan**: Spring에게 Component 클래스를 찾는 방법(패키지 이름)을 제공한다.

-   **Dependency Injection**: 의존성 주입, 앞서 말한 의존성을 해결 해주기 위한 방법 의존하는 클래스 내부가 아닌 외부에서 의존성을 주입해주는 방식이다. Spring은 그 해결 방법으로 IOC 컨테이너를 통해 Spring Bean을 생성하여 주입하는 방식을 사용한다. Autowired, Primary, Qualifier 등등 모두 의존성 주입을 위한 설정이다.

-   **IOC(Inversion Of Control)**: 제어의 역전, 의존성 주입을 사용하지 않는다면 개발자가 직접 의존 클래스 내부에서 객체를 생성하고 제어 한다. 제어의 권한 혹은 책임이 내부에 존재한다.

    -   Spring에서 의존성 주입을 사용할 경우 개발자가 아닌 IOC 컨테이너가 제어의 권한을 가지고 의존성을 주입해준다. 제어의 권한 혹은 책임이 외부에 존재한다.
    -   제어권이 내부 → 외부로 이동했다. 그래서 제어의 역전이다.

-   **Spring Bean**: Spring에서 관리하는 모든 객체를 뜻한다.

-   **Autowiring**: Spring이 Spring Bean에게 필요한 의존성이 무엇인지 식별하고 자동으로 주입해주는 것을 뜻한다.
    -   ex) 생성자에 필요한 파라미터 클래스 식별 → 일치하는 Spring Bean 탐색 → 주입

### 의존성이 발생하는 이유?

-   복잡한 비즈니스 로직을 구현하기 위해서
-   여러 개의 계층으로 나뉘게 되고 각 계층 끼리 상호작용이 필요하게 되는데 이 때 특정 계층에 의존하는 경우가 생길 수 밖에 없다.
-   일종의 인과 관계?

### Real World Java Spring Framework Example 솔루션

[example](./src/main/java/com/precisionbio/learnspringframework/example/c1/RealWorldSpringContextLauncherApplication.java)

### section2 복습

-   coupling(결합도)
    -   가능한 낮은 결합도 유지
-   Java Interface
    -   낮은 결합도 유지를 위해 interface를 구현하는 방식으로 개발
-   Spring Container
    -   Spring IOC Container
    -   Applicatoin Context
    -   Spring Bean
-   Java Bean vs Spring Bean
-   Dependency Injection
    -   의존성 주입
    -   외부(Spring Framework)에서 의존성을 주입 시키자
-   DI Types
    -   생성자 주입
    -   Setter 주입
    -   Field 주입
-   Annotations
    -   Configuration
    -   CompnentScan
    -   Bean vs Component
    -   Qualifier vs Primary

### Next Section Preview

1. Lazy initalization - 지연 초기화
2. Bean Scopes - 다양한 Spring Bean의 범위
    - Prototype
    - Singleton
3. PostConstruct & PreDestory - 생성 후, 소멸 전 작업이 필요할 경우?
4. Jakarta EE - Java 역사 시간
5. Contexts & DI
6. XML Configuration - XML 설정, Java 설정과의 차이점
7. Alternatives - @Component
    - 컴포넌트와 관련된 여러 대안들
    - @Service, @Repository
8. Spring Big Picture
9. Spring Modules & Projects
10. Why is Spring Popular?

# section 4

## Initailization

-   Default: Eager(즉시)
    -   즉시 초기화를 추천
    -   애플리케이션 시작 때 오류를 발견할 수 있다.
-   Lazy: 호출 시, 초기화
    -   자주 사용되지 않는다.
    -   존재한다는 것만 알아두자..
    -   필요할 때 초기화 하기 때문에 메모리 가 비교적 적게 소비 될 수 있다.
    -   Bean을 자주 사용하지 않는 경우 유용할 수 있음

## Prototype & Singleton

-   Singleton: 항상 하나의 인스턴스를 반환한다. Spring IoC 컨테이너에서 하나의 인스턴스를 생성하여 가지고 있다가 호출 시 가지고 있던 인스턴스를 반환한다.

-   Prototype: 항상 새로운 인스턴스를 반환 한다. Spring IoC 컨테이너에서 호출 할 때 마다 새로 생성한다.

-   Scopes apllicable Only for web-aware Spring Application Context
    -   Request: Singleton
    -   Session: Singleton
    -   Application: Singleton
    -   Websocket: Singleton

### Java Singleton (GOF) vs Spring Singleton

-   Spring Singleton: Spring IoC Container를 기준으로 하나의 컨테이너 당 하나의 객체 인스턴스
-   Java Singleton: JVM기준으로 JVM당 하나의 객체 인스턴스

-   간단한 설명:
    -   JVM 1개, Spring IoC 1개
        -   같은 의미
    -   JVM 2개, Spring IoC 1개
        -   Java Singleton은 2개 객체
        -   Spring Sinleton은 1개 객체
    -   JVM 1개, Spring IoC 2개
        -   Java Singleton은 1개 객체
        -   Spring Sinleton은 2개 객체
-   But, 99.99% JVM == Spring IoC

    -   JVM 한개당 하나의 Spring을 실행함.

## PostConstruct & PreDestory

-   PostConstruct: 생성자 초기화 이후 실행되는 메서드
-   PreDestory: 객체 소멸 전에 실행되는 메서드

## Jakarta EE vs J2EE vs Java EE

-   J2EE - java 2 Platform enterprise edition
-   Java EE - java Platform enterprise edition (Rebranding)
-   Jakarta EE (Oracla -> Eclipse Foundation)
    -   JSP
    -   JSTL
    -   EJB
    -   Jakarta RESTful Web Services (JAX-RS)
    -   Jakarta Bean Validation
    -   Jakarta Contexts and Dependency Injection
    -   Jakarta Persitence (JPA)

## Jakarata Contexts & Dependency Injection

    - CDI is interface
    - important annotation
        - @Inject -> @Autowired 대체 가능
        - @Named -> @Component 대체 가능
        - @Qualifier
        - @Scope
        - @Singleton

## XML Configuration vs Annotation Configuration

### xml

-   사용법이 어렵다.
-   문법이 복잡하다.
-   java 소스코드가 깔끔함
-   유지보수가 어렵다.
    -   같은 일은 두번해야 한다.
-   관리가 어렵다.

### annotation

-   사용법이 쉽다.
-   문법이 간결하다.
-   java class에 어노테이션을 추가 하기 때문에 자바 소스르 건드려야 한다.
-   유지보수가 쉽다.
-   관리가 쉽다.

## Spring Stereotype Annotations

-   @Component - Generic annotation applicable for any class
    -   모든 클래스에 사용가능한 generic 어노테이션
-   @Service - 비스니스 로직을 구현하는 클래스에 사용가능한 generic 어노테이션
-   @Repository - 데이터베이스 로직을 구현하는 클래스에 사용가능한 generic 어노테이션
-   @Controller - 웹 로직을 구현하는 클래스에 사용가능한 generic 어노테이션

### Why?

-   구체적인 역할을 명시 하는 역할
-   구체적인 역할을 명시하여 프레임워크의 도움을 적극적을 받을 수 있다.
