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

## Get bean from Spring context

```java
Book book = context.getBean("book", Book.class);
System.out.println("The book's title is " + book.getTitle());
```

