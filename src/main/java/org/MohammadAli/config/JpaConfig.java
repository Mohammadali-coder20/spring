package org.MohammadAli.config;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"org.MohammadAli.data"})
public class JpaConfig {

    @Autowired
    Environment env;

//    @Bean
//    @Autowired
//    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
//        LocalSessionFactoryBean sessionFactoryBean =  new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setPackagesToScan(new String[]{"org.MohammadAli.data.entities"});
//        sessionFactoryBean.setHibernateProperties(hibernateProperties());
//        return sessionFactoryBean;
//    }

    @Bean
    public LocalContainerEntityManagerFactoryBean managerFactoryBean(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setPackagesToScan(" org.MohammadAli.data.entities");
        factoryBean.setJpaProperties(hibernateProperties());
        return factoryBean;
    }

    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        return adapter;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("database.datasource.driver"));
        dataSource.setUsername(env.getRequiredProperty("database.datasource.username"));
        dataSource.setPassword(env.getRequiredProperty("database.datasource.password"));
        dataSource.setUrl(env.getRequiredProperty("database.datasource.url"));
        return dataSource;
    }

    public Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put(AvailableSettings.SHOW_SQL, "true");
        properties.put(AvailableSettings.FORMAT_SQL, "true");
        properties.put(AvailableSettings.HBM2DDL_AUTO, "update");
        properties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager platformTransactionManager(EntityManagerFactory managerFactory) {
        {
            JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
            jpaTransactionManager.setEntityManagerFactory(managerFactory);
            return jpaTransactionManager;
        }
    }
}
