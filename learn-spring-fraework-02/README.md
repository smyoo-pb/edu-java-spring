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
