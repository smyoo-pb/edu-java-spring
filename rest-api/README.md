# section 8

## 학습 목표

-   build simple REST API with Spring Boot
-   build REST API for Social Media Application
-   connect to Database

## Project 생성

### 의존성

-   Spring Web
-   Spring Data JPA
-   Spring H2 Database
-   Spring DevTools

## HelloWorld

-   @RestController: 기존 @Controller, @ResponseBody와 같은 어노테이션의 축약
    -   @ResponseBody 어노테이션을 이용해야 View 파일 이동이 아닌 응답 값을 그대로 반환할 수 있음.
    -   REST API는 JSON 응답을 주로하기 때문에 @RestController 어노테이션 하나로 귀찮은 작업을 제거
-   @GetMapping(path="path")
    -   기존에는 @RequestMapping 어노테이션으로 요청 메서드와 url 경로를 설정 했다.
    -   좀 더 직관적이고 간략한 문법을 제공할 수 있게 해준다.

### @RestController 특징

-   응답 객체(Bean)를 JSON으로 자동 변환
    -   @ResponseBody + JacksonHttpMessageConverters

### Path Parameters

```yaml
url: /users/{id}/todos/{id} => /users/1/todos/1
```

-   말 그대로 경로에 매개변수를 넣는 것을 뜻한다.
-   Spring Boot에서는 @PathVariable 어노테이션을 사용한다.

## REST API For SNS

### Requst Methods for REST API

-   GET: 리소스의 상세 정보 조회
-   POST: 리소스의 생성
-   PUT: 리소스의 수정(전체)
-   PATCH: 리소스의 수정(일부)
-   DELETE: 리소스의 제거

### Users REST API

-   모든 회원 조회
    -   GET /users
-   회원 생성
    -   POST /users
-   특정 회원 조회
    -   GET /users/{id}
-   특정 회원 삭제
    -   DELETE /users/{id}
-   Posts REST API
    -   특정 회원의 모든 포스트 조회
        -   GET /users/{id}/posts
    -   포스트 작성
        -   POST /users/{id}/posts
    -   특정 회원의 특정 포스트 조회
        -   GET /users/{id}/posts/{post_id}

### Post Method 구현

-   @PostMapping
    -   메서드 POST
    -   GetMpping과 마찬가지로 경로만 지정 해주면 된다.
-   @RequestBody
    -   요청 본문(JSON Body)를 Object로 변환하기 위한 어노테이션이다.
-   Response Header: Location
    -   생성한 리소스의 API end point를 표기해주는 것이 좋다.
    ```java
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();
    ```

### 404 Resource Not Found 예외 구현 하기

-   RuntimeException 을 상속 받아 구현
-   @ResponseStatus 어노테이션으로 http status 설정
-   요청이 json이면 json을 응답한다.
-   브라우저에서 요청하면 http response로 응답한다.

### 모든 리소스를 대상으로 예외 처리 구현하기

-   ResponseEntityExceptionHandler 상속 필요
-   @ControllerAdvice: 에외를 이 어노테이셔이 있는 에러 핸들러로 처리할 수 있게 해준다.
-   @ExceptionHandler(Exception.class) 어노테이션을 이용하여 원하는 exception 클래스를 넣고 메서드를 만들어 주면 해당 exception에 대한 별도의 예외 처리를 해줄 수 있다.

### DELETE 메서드로 삭제 구현하기

-   @DeleteMapping: delete 메서드에 대한 라우팅 처리
-   no content: 삭제에 성공할 경우 void로 응답 하는 것이 일반적이다.

### REST API - Validation error (400: Bad Request)

-   dependency: spring-boot-starter-validation
-   @Valid 어노테이션을 사용하여 유효성 검사를 명시
-   @RequestBody 어노테이션을 사용한 클래스에 유효한 validation 어노테이션을 추가
-   jakarta.validation.constraints.\*: SpringBoot에서 기본으로 제공하는 유효성 검사 규칙 어노테이션 패키지
