package org.spring.context;


import lombok.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Component
@Primary
public class HistoryBook implements Book {

    private int price;
    private String title;

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public String getTitle() {
        return null;
    }
}
