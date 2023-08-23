# Webflux R2DBC 사용하기 (with MariaDB)

webflux r2dbc 설정

## 개발 환경

### 개발 도구

* JAVA v17
* Spring Boot v3.1.2
* Gradle -Groovy
* Docker

## 데이터베이스

### MariaDB 도커 실행

```shell
docker run -d --name simple-webflux-mariadb -p 3306:3306 --env MARIADB_ROOT_PASSWORD=test mariadb
```