package org.spring.context;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Component
@Lazy
@PropertySource("classpath:foo.properties")
public class Student {
    @Value("ali")
    private String name;
    @Value("${family}")
    private String family;
    private int age;

    @Autowired
    @Qualifier("sportBook")
    private Book book;

    public Student(){
        System.out.println("Constructor");
    }

    public void init(){
        System.out.println("init method");
    }


    public int sum(int i, int j) {
        return i + j + 2;
    }
}
