package org.spring;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.spring.context.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    ApplicationContext context;

    @Before
    public void springContextInit(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void checkSingletonInitStudent(){
        Student student = (Student) context.getBean("student");
        Student student1 = (Student) context.getBean("student");
        System.out.println(student);
        System.out.println(student1);
        Assert.assertTrue(student == student1);
    }

    @Test
    public void sumMethodShouldSumTwoIntValues(){
        Student student = new Student();
        int actual = student.sum(3,4);
        assertEquals(7,actual);
    }

    @Test
    public void studentMustHaveBookWhenInit(){
        Student student = (Student) context.getBean("student");
         assertNotEquals(null ,student.getBook());
    }

    @After
    public void resourceClose(){

    }

}
