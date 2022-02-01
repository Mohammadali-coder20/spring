package org.spring.context;

import org.springframework.stereotype.Component;

@Component
public class SportBook implements Book{

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
