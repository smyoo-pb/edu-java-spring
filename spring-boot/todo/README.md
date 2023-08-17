# section 7

TODO list web app

## Spring Boot - MVC

### @ResponseBody

-   일반적으로 컨트롤러에서 String을 응답하면 view 파일 이름으로 자동 인식된다.
-   @ResponseBody 어노테이션을 주입할 경우 String을 응답 Body(내용)으로 출력할 수 있다.

### JSP - Java Servlet Page

-   JSP 파일 응답을 위해 필요한 의존성 패키지

```xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <scope>provided</scope>
</dependency>
```

-   설정 수정 필요

```
# jsp 파일 위치: src/main/resources/META-INF/resources/WEB-INF/jsp/
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

-   컨트롤러에서 파일명을 리턴하면 위 설정 규칙에 따라 해당 파일로 리다이렉션 한다.

### WEB 작동 방식

1. Browser Send HttpRequest to Server
2. Server Receve HttpRequest from Browser
3. Server Process HttpRequest - Handles the request, who? > Spring Boot Web Application
4. Server Send HttpResponse to Browser

### RequestParam

-   QueryString을 가져올 수 있는 어노테이션이다.
-   어노테이션이 적용된 매개변수의 이름이 QueryString의 키 값이 된다.

```java
public String someMethod(@RequestParam String name) {

}
```

### Model

-   ModelMap 객체를 이용했다.
-   hashMap 처럼 이용하며 put(key, value) 메서드를 활용하여 값을 추가한다.
-   JSP 파일에서 ${model-key} 방식으로 JSP에서 모델의 키 값을 불러올 수 있다.

### 로깅의 중요성

-   로깅 레벨을 패키지 단위로 정할 수 있다.
-   System.out.println() 메서드를 사용했지만, 이 방법보다는 Logger를 불러와서 Log를 남기는 것이 좋다.
    -   로그 레벨을 설정하여 디버깅용 로깅과 프로덕션 환경에서 남길 로그를 분리하여 개발할 수 있음.

#### spring에서 기본으로 사용되는 logger 패키지

-   slf4j
    -   spring-boot-starter-logging 의존성 패키지가 spring-boot-starter-web 패키지에 의해 추가되어 있다.

```java
import org.slf4j.Logger;
```
