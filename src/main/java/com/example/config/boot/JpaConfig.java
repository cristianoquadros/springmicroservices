package com.example.config.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.example.integration.repository", "com.example.integration.repository.impl"}, repositoryImplementationPostfix="Impl") 
@EnableTransactionManagement 
public class JpaConfig {

//    @Value("${datasource}") //inject the databse JNDI. 
//    private String dataSourceJndi;
//
//    @Bean //Creating and registering in spring context an entityManager
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan(new String[]{"com.example.domain.entity"}); // package where are the @Entity classes are located, ususaly your domain package
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); // JPA implementation 
//        em.setJpaVendorAdapter(vendorAdapter);
//
//        return em;
//    }
//
//    @Bean //Creating the dataSource using the Jndi 
//    public DataSource dataSource() {
//        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//        dsLookup.setResourceRef(true);
//        DataSource dataSource = dsLookup.getDataSource(dataSourceJndi);
//
//        return dataSource;
//    }
//
//    @Bean //Configuring the transactionManager
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }

}