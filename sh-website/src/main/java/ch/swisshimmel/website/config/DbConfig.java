package ch.swisshimmel.website.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DbConfig {

    
    @Bean(destroyMethod = "close")
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dbPerson");
        dataSource.setUser("root");
        dataSource.setPassword("Chhapolia@123");
        dataSource.setMaxIdleTime(120);
        dataSource.setMaxPoolSize(10);
        dataSource.setUnreturnedConnectionTimeout(150);
        dataSource.setDebugUnreturnedConnectionStackTraces(true);

        return dataSource;
    }
    
    @Bean
    public SessionFactory sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(getDataSource()).scanPackages("ch.swisshimmel.website");
        builder.setProperty(org.hibernate.cfg.Environment.DIALECT, MySQL5Dialect.class.getName());
        return builder.buildSessionFactory();
    }
    
    
    @Bean
    //@Qualifier("hibernateTransaction")
    public HibernateTransactionManager hibernateTransactionManager() throws PropertyVetoException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        return transactionManager;
    }
    
    
}
