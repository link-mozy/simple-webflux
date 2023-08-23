# SIMPLE-WEBFLUX

webfulx CRUD 예제

## 개발 환경

### 개발 도구

* JAVA v11
* Spring Boot v2.7.7(SNAPSHOT)
* Gradle - Groovy
* Docker

### Dependencies

* Spring Reactive Web
* Spring Data R2DBC
* H2 Database
* Lombok
* Spring Boot DevTools

---

## 서비스 실행하기 (with Docker)

소스 다운로드 및 도커 컨테이너에 서비스 실행

($는 명령어를 의미)

도커 이미지 빌드

```bash
$ docker build -t spring-webflux:v1 .
```

도커 이미지 실행

```bash
$ docker run -p 8080:8080 -p 8081:8081 -d -t spring-webflux:v1 --name webflux
```

---

## CRUD 테스트 (with curl)

간단한 사용자 테이블 CRUD 예제

($는 명령어를 의미)

조회 - 사용자 리스트 조회

```bash
$ curl --location --request GET 'localhost:8080/users'
```

삽입 - 사용자 추가

```bash
$ curl --location --request POST 'localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"user5",
    "age":"33"
}'
```

수정 - 사용자 정보 수정

```bash
$ curl --location --request PUT 'localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "name": "test",
    "age": 44
}'
```

삭제 - 사용자 삭제

```bash
$ curl --location --request DELETE 'localhost:8080/user/2'
```
