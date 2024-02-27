package com.example.book_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BookManagementApplication {

    public static void main(String[] args) {

        ApplicationContext application = SpringApplication.run(BookManagementApplication.class, args);

    }

}
