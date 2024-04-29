# FK 로 연결된 2개의 테이블에 insert 하기
- 두 테이블이 FK 로 연결된 경우 1:N 의 관계의 Table 이 많다
- 1 의 Table 에는 기본키가 존재하고, 이 기본키를 기준으로 N 의 테이블에 다수의 데이터가 졵재하는 구조
- 1 의 Table 의 기본키가 생성된 후 N 테이블의 FK 칼럼에 Key 값이 추가되는 구조이다

## 테이블에 insert 하는 순서
1. `1인 테이블 : Master Table`에 데이터 insert 하기
- `Master Table` 의 `PK`는 미리 생성을 하거나, `AUTO_INCREMENT`로 만들어진다.
- `PK`를 미리 생성하는 경우는 문제가 없으나 `AUTO_INCREMENT`로 생성되는 키는 `Master Table`에 데이터가 `INSERT` 되기 전까지는 그 값을 알수가 없다.
- `Mybatis` 에서는 `insert` mapper 에 `selectKey` 라는 옵션을 제공하여 `Master Table` 에 데이터가 insert 된 후 새로 생성된 `PK` 값을 코드에서 참조할수 있도록 하고 있다.
- `Java` 에서는 `Class Type`의  객체를 매개변수로 method 에 전달한 경우 method 에서 매개변수 객체의 일부 속성(요소, properties)을 변경하는 경우 원본 객체의 속성 값이 변경되는 성질이 있다.
- 이 성질을 활용하여 `Mybatis`의 `selectKey` 에 의해 속성값을 변경하고, `Service` 등에서 그 값을 `getter` 할수 있다