# Spring 이미지 갤러리 프로젝트
- MySQL, Mybatis, Tiles 를 이용한 갤러리 프로젝트

## Tiles 를 이용한 Layout 설정
- dependency 설정
```xml

<properties>
	<org.apache.tiles-version>3.0.8</org.apache.tiles-version>
</properties>

<dependency>
    <groupId>org.apache.tiles</groupId>
    <artifactId>tiles-core</artifactId>
    <version>${org.apache.tiles-version}</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-extras -->
<dependency>
    <groupId>org.apache.tiles</groupId>
    <artifactId>tiles-extras</artifactId>
    <version>${org.apache.tiles-version}</version>
</dependency>
```