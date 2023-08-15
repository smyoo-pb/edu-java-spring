# section 6

## dependencies

-   Spring Data JDBC: Java Data Base Connectivity
-   Spring Data JPA: Java Persistence API, ORM 사용을 위한 Interface
-   h2 Database: Java로 만들어진 RDBMS이다.
    -   로컬 개발, 테스트 환경에서 주로 사용된다.

## H2 Database

-   Java로 만들어진 In memory RDBMS.

### H2 콘솔 활성화

-   end point: /h2-console

#### application.properties

```
spring.h2.console.enabled=true
```

## JDBC

-   Java <-> DB 연결을 위한 API(인터페이스)
-   JdbcTemplate 클래스를 이용하여 간단하게 SQL 구분 실행을 명령 할 수 있다.
-   JdbcTemplatre.update() 메서드 활용
    -   Select의 경우 queryForObject(SQL, new BeanPropertyRowMapper<>(Course.class), id) 메서드 활용

## JPA
