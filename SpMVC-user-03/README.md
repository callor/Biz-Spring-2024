# Spring Security Project
- Spring Security 를 사용하여 로그인, 세션관리를 수행하는 프로젝트

## 환경설정
- 필수 dependency
```xml
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-config</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-taglibs</artifactId>
</dependency>
```

## MyBatis DBMS 연동 설정
- 필수 dependency
```
mybatis
mybatis-spring
dbcp : common-dbcp2
mysql : mysql-connector/j
spring-jdbc
```