package org.spring.context;

import org.apache.log4j.Logger;

public class Main {
    Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Main main = new Main();
        main.f();
    }
    public void f(){
        int i = 1;
        logger.info(String.format("this is object that have been called in f method with value %d",i));
    }

}
