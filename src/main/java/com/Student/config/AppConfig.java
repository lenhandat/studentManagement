package com.Student.config;

import com.Student.service.MarkServiceImpl;
import com.Student.service.MarkService;
import com.Student.dao.MarkDAOImpl;
import com.Student.dao.MarkDAO;
import com.Student.service.StudentServiceImpl;
import com.Student.service.StudentService;
import com.Student.dao.StudentDAOImpl;
import com.Student.dao.StudentDAO;
import com.Student.service.SubjectServiceImpl;
import com.Student.service.SubjectService;
import com.Student.dao.SubjectDAOImpl;
import com.Student.dao.SubjectDAO;
import java.util.Properties;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.Student" })
@EnableTransactionManagement
public class AppConfig
{
    @Bean(name = { "entityManager" })
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(this.dataSource());
        em.setPackagesToScan(new String[] { "com.Student.entites" });
        final JpaVendorAdapter vendorAdapter = (JpaVendorAdapter)new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(this.additionalProperties());
        return em;
    }
    
    @Bean
    JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=studentproject");
        dataSource.setUsername("sa");
        dataSource.setPassword("123456");
        return (DataSource)dataSource;
    }
    
    Properties additionalProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        return properties;
    }
    
    @Bean
    public SubjectDAO subjectDAO() {
        return (SubjectDAO)new SubjectDAOImpl();
    }
    
    @Bean
    public SubjectService subjectService() {
        return (SubjectService)new SubjectServiceImpl(this.subjectDAO());
    }
    
    @Bean
    public StudentDAO studentDAO() {
        return (StudentDAO)new StudentDAOImpl();
    }
    
    @Bean
    public StudentService studentService() {
        return (StudentService)new StudentServiceImpl(this.studentDAO());
    }
    
    @Bean
    public MarkDAO markDAO() {
        return (MarkDAO)new MarkDAOImpl();
    }
    
    @Bean
    public MarkService markService() {
        return (MarkService)new MarkServiceImpl(this.markDAO());
    }
}
