# Petclinic Tests

Additional tests for [Spring Petclinic](https://github.com/Diabol/spring-petclinic)

## Selenium

Uses the HtmlUnit Driver or FireFox (requires FireFox).
Run with:
```
./gradlew -Dbase.url=http://192.168.33.100:8080/petclinic -DbrowserType=htmlunit test
```

## Gatling

Uses the Gatling Tool to run stress test.
Run with:
```
./gradlew -Dbase.url=http://192.168.33.100:8080/petclinic gatling
```
