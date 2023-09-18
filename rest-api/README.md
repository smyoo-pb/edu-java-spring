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

## Advanced REST API Features

-   Documentation
-   Internationalization - i18n
-   Versioning
-   HEATEOAS
-   Static Filtering
-   Dynamic Filtering
-   Monitoring

### REST API Dcoumentation

-   Swagger Doc
    -   API 문서와 코드 동기화를 코드에 문서를 작성한다.
    -   endpoint, path, parameter, response 등은 대부분 자동화 된다.
    -   설명이나 예외 처리 정도만 작성해주기 때문에 심플하다.

### i18n

-   spring boot default i18n messages properties
-   resources/message.properties 생성
-   MessageSource 객체 생성
    -   getMessage() 메서드를 통해 essage.properties 파일에 지정한 키 값으로 i18n 메시지를 가져올 수 있다.
-   Accept-Language 헤더를 사용

### Versioning REST API

-   URL Versioning - Twitter
    -   v1/person
    -   v2/person
-   Request Parameter - Amazon
    -   person?version=1
    -   person?version=2
-   Header - Microsoft
    -   persion headers=[X-API-VERSION=1]
    -   persion headers=[X-API-VERSION=2]
-   Media Type
    -   persion produces=application/vnd.company.app-v1+json
    -   persion produces=application/vnd.company.app-v2+json

#### 뭐가 좋을까?

**고려사항**

-   URI 오염
-   HTTP 헤더 오용
    -   HTTP 헤더에는 관리요소가 들어가면 안된다.
-   caching
    -   일반적으로 URL을 기반으로 수행되기 때문에 Header를 사용할 경우 캐시가 불가능하다.
-   브라우저를 통해 사용할 수 있는가?
-   API 문서 작성
    -   URL이 같고 header가 다를 경우 문서 작성이 난해해질 수 있음.

**결론**: 사용하기 나름이다. 일관성 유지에 신경을 써라.

-   개인적으로는 URL Versioning이 심플하고 직관적

### HEATEOAS

> Hypermedia as the Engine of Application State
> 하이퍼 미디어를 애플리케이션의 상태를 관리하기 위한 매커니즘으로 사용한다.

-   서버와 클라이언트 상호 작용을 위해 요청에 필요한 URI를 같이 응답하는 것

#### Dependency

-   spring-boot-starter-hateoas

### 정적 필터링

-   Serialization(직렬화): convert object to stream => 객체를 JSON으로 변환
-   Jackson 라이브러리를 사용한다.
    -   @JsonProperty => JSON 키에 대한 헤더
-   응답 필드 선택
    -   ex) password 필드 응답 제외
    -   @JsonIgnoreProperty
    -   @JsonIgnoreProperties

### 동적 필터링

-   @JsonFilter: JSON 키에 대한 필터를 설정
-   MappingJacksonValue: Jackson 라이브러리를 사용하여 JSON 키에 대한 필터를 설정
-   FilterProvider: 여러 유형의 필터들을 등록 하기 위한 객체
    -   SimpleBeanPropertyFilter: 필터 로직이 직접 설정되는 객체

## Monitoring

> Spring Boot Actuator

-   end-point: /actuator
-   스프링 빈즈, 애플리케이션 상태 확인
-   요청, 응답, 리소스 통계 등등

## HAL Explorer

-   현재 애플리케이션에 구현된 API들을 조회할 수 있다.

## JPA Hibernate + H2 연동

### 설정

-   application.properties 파일을 통한 설정

    -   spring.h2.console.enabled=true
        -   h2 콘솔 활성화
    -   spring.datasource.url=jdbc:h2:mem:testdb
        -   h2 inmemory db 연결

-   entity 설정
    -   @Entity 어노테이션 활용
        -   기본적으로 테이블이 자동으로 생성된다.
    -   spring.jpa.defer-datasource-initialization=true 설정을 통해 리소스 파일의 sql 실행 지연

### Repository 생성

-   JpaRespository 인터페이스 상속
    -   findAll() => 모든 레코드 조회
    -   save() => create or update
    -   findById() => PK로 레코드 조회
        -   리턴 타입은 Optional 사용을 하자
        -   nullable을 구현하면서 null 체크를 할 수 있도록 유도
    -   deleteById() => PK로 레코드 삭제
    -   findBy{column} => 인터페이스에 해당 규칙으로 메서드를 추가하면 자동으로 해당 컬럼으로 조회 가능한 기능이 추가된다.

### Entity 관계 설정

-   @ManyToOne => N:1 관계
-   @OneToMany => 1:N 관계

-   fetch = FetchType.LAZY
    -   지연 로딩
    -   연결 관계 method를 호출하는 시점에 db에서 select
-   fetch = FetchType.Eager => 즉시 로딩

    -   해당 entity를 조회 하는 시점에 같이 관계 테이블의 데이터를 같이 조회
    -   기본 값이다.

-   @OneToMany(mappedBy = "user")
    -   하위 관계 테이블에 매핑될 속성을 정의

### 실제 SQL 쿼리 조회하기

-   spring.jpa.show-sql=true 설정을 통해 실제 쿼리 로그를 출력할 수 있다.

## JPA + MySQL

-   소스 코드의 변경 없이 spring.datasource 들의 설정을 변경하는 것 만으로도 dbms의 변경이 가능하다.

### MySQL 연결 해보기

-   spring.datasource.url=jdbc:mysql://{url}:{port}/{database-name}
-   spring.datasource.username={user}
-   spring.datasource.password={password}

## Spring Security

### 기본 인증 구현

#### 자동 설정

-   초기 관리자 아이디 패스워드 자동 생성 및 설정 가능
    -   spring.security.user.name
    -   spring.security.user.password
-   Basic Auth 인증 기능

### 기본 인증 설정 개선

#### Filter Chains

> Spring Security의 동작 순서
>
> > Spring Security는 여러 Filter들을 통해 모든 http 요청에 대한 접근 제어를 한다.

1. 모든 요청은 인증되어야 한다.
2. 인증되지 않았다면 기본(로그인) 페이지로 이동 한다.
3. CSRF 필터

#### Configurations

**Basic Aut 활성화 설정**

```java

package com.precisionbio.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Spring Security Configuration
 * For Basic Auth
 * @author smyoo-pb
 * @date 2023/09/14
 */
@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 1. 모든 요청은 인증되어야 한다.
        // 2. 인증되지 않았다면 기본(로그인) 페이지로 이동 한다.
        // 3. CSRF 필터

        // 1)
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // 2) 기본 설정
        // 3) 기본 설정

        // Basic Auth 기본 구현체 적용
        // 인증되지 않은 경우, HTTP Basic Auth를 통해
        // 인증할 수 있는 팝업(브라우저에서 지원되는..)
        http.httpBasic(withDefaults());

        return http.build();
    }
}
```
