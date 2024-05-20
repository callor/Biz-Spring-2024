# Spring REST(RESTful) API 서버
- Spring 프로젝트의 `Controller` 클래스에 `@RestController`를 부착하여 각 method 에서 데이터를 return 하도록 하거나, `@Controller` 를 부착하고 각 method 에 `@ResponsBody` 를 부착하면 method는 `Resolver`를 경유하지 않고, 데이터를 즉시 client 로 return 한다.
- 보통 `API` 서비스를 수행하기 위한 조치이다
- 하지만 spring 에서 REST 데이터를 return 하는 것은 기본적으로 String type 만 가능하다.
- 초기 SpringFramework 에서는 모든 데이터 type 을 return 할수 있었으나, 지금은 분리된 프로젝트로 구현되었다.

## Spring 에서 모든 데이터 type 을 `JSON`, `xml` type 으로 return 하기
- `jackson-databind` dependency 설정하기
- `java 의 모든 데이터 Type` 을 `JSON` type 으로 client 로 return 하는 도구
- `JSON` 외에 `xml`, `yaml` 등 기타 type 이 필요한 경우는 추가로 `jackson-dataformat-*` 등의 도구를 설치하여 사용한다.
```xml
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.17.1</version>
</dependency>
```