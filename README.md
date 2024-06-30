# Add bean to Spring context using @bean annotation

> This project is based on chapter **2.2.1. Using the @Bean annotation to add beans into the Spring context** from book **Spring Starts here (2021)** by Laurentiu Spilca.

## Create Maven project with Intellij Idea

File > New project > Java

## Add Spring Context dependency

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.1.10</version>
</dependency>
```

## Create entity

```java
public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book book = (Book) obj;
        return title.equals(book.title);
    }

    public int hashCode() {
        return title.hashCode();
    }
}
```

## Create configuration class

```java
@Configuration
public class ApplicationConfiguration {
}
```

## Add bean to configuration class

```diff
@Configuration
public class ApplicationConfiguration {
+   @Bean
+   Book book() {
+       return new Book(" One Hundred Years of Solitude");
+   }
}
```

## Create Spring context

```java
ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
```

## Get book from Spring context

```java
Book book = context.getBean("book", Book.class);
```

## Add tests

### Add dependency for Spring TestContext Framework

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>6.1.10</version>
    <scope>test</scope>
</dependency>
```

### Add dependency for JUnit

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.11.0-M2</version>
    <scope>test</scope>
</dependency>
```

### Create test to check that application context is created

```java
public class ApplicationTests {

    @Test
    @DisplayName("Checks that Application Context is created")
    public void checkApplicationContextCreated() {
        ApplicationContext context = new AnnotationConfigApplicationContext();

        assertNotNull(context);
    }
}
```

### Create test to check that book is added to Spring context

- use `@ExtendWith(SpringExtension.class)` to integrate Spring TestContext Framework to the test
- use `@ContextConfiguration` to configure Spring context in Spring integration tests

```java
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ApplicationConfiguration.class })
public class BookTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Fetch the book bean from the context")
    public void fetchBookBean() {
        Book book = context.getBean("book", Book.class);

        assertEquals(new Book("One Hundred Years of Solitude"), book);
    }
}
```
