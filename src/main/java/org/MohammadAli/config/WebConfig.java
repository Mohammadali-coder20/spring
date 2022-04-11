package org.MohammadAli.config;

import org.MohammadAli.data.entities.Cart;
import org.MohammadAli.data.entities.Customer;
import org.MohammadAli.data.entities.Product;
import org.MohammadAli.models.CustomerDTO;
import org.MohammadAli.models.Pagination;
import org.MohammadAli.models.ProductDTO;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.jsp.tagext.ValidationMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {"org.MohammadAli.controllers","org.MohammadAli.services","org.MohammadAli.data"})
@EnableWebMvc
@EnableSwagger2
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    @Bean
    @Scope("prototype")
    public Logger produceLogger(InjectionPoint injectionPoint){
        Class<?> classOnWired = injectionPoint.getMember().getDeclaringClass();
        return Logger.getLogger(classOnWired);
    }

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classPath:message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }


    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new CookieLocaleResolver();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(5*1024*1024);
        return resolver;
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.mohammadali.controllers.rest"))
                .paths(PathSelectors.ant("/rest/**"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return  new ApiInfo(
                "Online Shop Rest Api",
                "crud operation on customer cart",
                "api 1.0",
                "Term of Service",
                new Contact("MohammadAli Khomarbaghi","https://contact.ac.ir/mohammadali","example@dummy.com"),
                "License Api",
                "Licence Api url",
                Collections.emptyList()
                );
    }

    @Bean
    public List<CustomerDTO.RETRIEVE> getList(){
        return new ArrayList<>();
    }

    @Bean
    public Pagination<ProductDTO.RETRIEVE> getPagePagination(){
        return new Pagination<>(ArrayList<ProductDTO.RETRIEVE>::new);
    }

    @Bean
    public Cart initCart(){
        Cart cart = new Cart();
        cart.setCustomer(new Customer());
        return cart;
    }
































}
