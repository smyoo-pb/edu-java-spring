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

간단한 example

```java
import org.slf4j.Logger;

public class MyController {
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);
}
```

### Dispatcher, Sevlet, Model(1,2), Front Controller

#### History

**Model 1**

-   All Code in Views(JSP)
    -   view logic
    -   flow logic
    -   queries to databases
-   단점
    -   복잡한 JSP 코드
    -   기능, 구조 관계 분리 X
    -   유지보수 어려움

**Model 2 - Servlet**

-   관계(기능과 역할에 따라) 분리
    -   servlet 등장
    -   model: 뷰에 필요한 데이터를 생성
    -   view: 사용자에게 필요한 정보를 게시
    -   controller: 흐름 제어(ex: 라우팅)
-   장점
    -   유지보수 간단
-   주요 문제: - 각각의 servlet의 공통 기능의 분리를 해볼 수 있지 않을까? - Front Controller 등장 배경

**Model 2 - Front Controller**

-   개념: 모든 요청의 흐름을 컨트롤러 하나로 중앙 집중 제어
    -   Front Controller

#### Spring MVC Front Controller - Dispatcher Servlet

-   모든 HTTP 요청을 수신
-   모든 HTTP 요청을 처리
    -   Controller Method 식별
    -   Controller Method 실행
        -   모델에 데이터 구성
        -   뷰 응답
-   HTTP 응답

#### Login 구현

[example](./src/main/java/com/precisionbio/springboot/todo/login/LoginController.java)

-   LoginController
    -   gotoLoginPage: 로그인 페이지 이동
    -   gotoWelcomePage: username, password 입력으로 welcome 페이지 이동
        -   AuthenticateService
            -   authenticate: username, password 입력으로 로그인 확인

## TODO WEB Application 구현하기

### TODO

**Data Fields**

-   id
-   username
-   description
-   targetDate
-   done

#### [implements](./src/main/java/com/precisionbio/springboot/todo/todo/TodoController.java)

#### @SessionAttributes

-   model의 담긴 특정 키 값을 session으로 저장
-   다른 곳에서도 ${model-key} 형식으로 불러올 수 있다.
-   해당 어노테이션이 존재하는 곳에만 session 값을 저장한다.
    -   어노테이션이 없는 컨트롤러에서 다른 컨트롤러로 이동할 경우 불러올 수 없음

#### Style - bootstrap5

**using webjars package**

-   bootstrap 5.1.3
-   jquery 3.6.0

```xml
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>bootstrap</artifactId>
    <version>5.1.3</version>
</dependency>
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>jquery</artifactId>
    <version>3.6.0/version>
</dependency>
```

```yaml
bootstrap:
    css:
        realPath: /META-INF/resources/webjars/bootstrap/5.1.3/css/bootstrap.min.css
        refPath: webjars/bootstrap/5.1.3/css/bootstrap.min.css
    js:
        realPath: /META-INF/resources/webjars/bootstrap/5.1.3/js/bootstrap.min.js
        refPath: webjars/bootstrap/5.1.3/js/bootstrap.min.js
jquery:
    realPath: /META-INF/resources/webjars/jquery/3.6.0/jquery.min.js
    refPath: webjars/jquery/3.6.0/jquery.min.js
```

#### validation

-   spring-boot-starter-validation
-   command bean
    -   @Valid
    -   BindingResult
-   add validations to bean
    -   [todo.java](./src/main/java/com/precisionbio/springboot/todo/todo/Todo.java)
    -   @Size
-   display validation errors in the view
    -   [todo.jsp](./src/main/resources/META-INF/resources/WEB-INF/jsp/todo.jsp)
    -   form tag
        -   form:form
        -   form:input
        -   form:errors

#### Spring Security

-   spring-boot-starter-security
-   [SpringSecurityConfiguration](./src/main/java/com/precisionbio/springboot/todo/security/SpringSecurityConfiguration.java)
    -   create new user
    -   password encoder setting
    -   그 외, 인증 처리 로그인 처리를 Spring Security가 해준다.

#### JPA & H2 Database

-   spring-boot-starter-data-jpa
-   com.h2database.h2

**H2 Console을 위한 Spring Security 설정**

-   [SpringSecurityConfiguration](./src/main/java/com/precisionbio/springboot/todo/security/SpringSecurityConfiguration.java)
-   filterChain
    -   허용할 경로 필터링
    -   http header 설정
        -   csrf 활성화
        -   기타 헤더값 필터링

**JPA Repository**

-   기존 Service 로직 Repository로 변경
-   JpaRepository Interface를 활용하여 구현된다.

**MySQL Docker**

```shell
docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle
```

**application.properties**

```shell
# data sql 적용, resources 하위에 있는 *.sql 애플리케이션 시작 시 파일을 읽어서 적용 해준다.
spring.jpa.defer-datasource-initialization=true
# db connection url
spring.datasource.url=jdbc:mysql://localhost:3306/todos
# db connection usernamne
spring.datasource.username=todos-user
# db connection password
spring.datasource.password=dummytodos
# dialect(방언) 패키지를 선택
# 다른 DBMS 혹은 버전이 다른 경우, SQL 문법에 차이가 생길 수 있다. 이 차이에 대한 문제를 해결해 줄 수 있는 패키지 클래스를 등록 해주는 것이다.
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
# 내가 생성한 Entity를 기준으로 DB를 생성해준다.
spring.jpa.hibernate.ddl-auto=update
```
