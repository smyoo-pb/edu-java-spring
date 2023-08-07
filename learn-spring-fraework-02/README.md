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
