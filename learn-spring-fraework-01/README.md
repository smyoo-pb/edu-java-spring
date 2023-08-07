# section 2

java spring 학습

## contents

-   강한 결합 vs 느슨한 결합
-   의존성 주입
-   제어의 역전

### 강한 결합 vs 느슨한 결합

#### 강한 결합

[example](./src/main/java/com/precisionbio/learnspringframework/game/tightcoupling/AppGamingBasic.java)

-   실생활 예시
    -   자동차와 엔진 > 바꾸기 어렵고 교체 시 비용이 많이 발생

#### 느슨한 결합

[example](./src/main/java/com/precisionbio/learnspringframework/game/looselycoupling/AppGamingBasic.java)

-   실생활 예시
    -   자동차와 타이어 > 바꾸기 쉽고 비용이 적음

#### 결론

-   변하지 않는 것은 "변화" 뿐이다.
-   가능한 한 느슨한 결합을 유지하도록 노력해야한다.
    -   가능한 한 기존 코드를 적게 수정하는 방향으로 개발 해야한다.

### 의존성 주입

-   객체 지향 개발을 하다보면 class 수많은 class가 생성되고 class 혹은 interface를 의존하게 되는 의존성이 발생하게 된다.

-   의존성이 발생하면 의존성을 해결하기 위한 의존성 주입의 과정이 필요하다.

-   의존성 주입이란 이 행위를 개발자가 수동으로 해결 하는 것이 아닌 프레임워크가 해결할 수 있도록 해주는 것이다.

    -   개발자가 수동으로 의존 클래스의 객체를 생성하고 전달하는 코드를 짜는 것 X

    -   프레임워크가 정해진 규칙에 의해 자동으로 객체를 생성하고 전달 하는 것 O

#### Spring Configuration & Bean

[example](./src/main/java/com/precisionbio/learnspringframework/helloworld/App02HelloWorldSpring.java)

-   Spring Configuration 어노테이션을 통해 Spring Context를 얻을 수 있다.
-   Spring Context는 Configuration 클래스 내의 메서드들을 Bean 어노테이션을 통해 가져올 수 있다.
    -   getContext() 메서드를 사용한다.
    -   Bean을 부르는 방법은 크게 2가지가 있다.
        -   메서드 이름: getContext("method name");
        -   클래스 이름: getContext(MyClass.class); -> 해당 클래스를 응답하는 메서드가 존재해야 함.

#### Spring Container - IOC Container

-   Bean Factory: Basic Container

    -   메모리에 심한 제약이 있는 IOT 애플리케이션이 아니면 사용하지 않음

-   Application Context: Advanced Container
    -   보편적으로 널리 사용됨
    -   위에서 Bean을 사용했지만 Bean과 Bean Factory는 다르다.

#### Annotations

-   @Configuration: spring bean을 등록하기 위한 설정, Context
-   @Bean: spring bean 등록
-   @Primary: 같은 객체를 리턴하는 경우 우선순위를 매기기 위해 사용된다. 최우선 순위로 설정된다.
-   @Qualifier: 같은 객체를 리턴하는 경우, 일종의 별칭을 매겨 Bean 메서드 매개변수에 같은 어노테이션으로 작성하면 해당하는 객체를 자동으로 spring에서 넘겨준다.
