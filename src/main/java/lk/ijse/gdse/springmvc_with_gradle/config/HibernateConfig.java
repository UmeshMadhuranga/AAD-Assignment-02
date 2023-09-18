package lk.ijse.gdse.springmvc_with_gradle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories("lk.ijse.gdse.springmvc_with_gradle.repository")
public class HibernateConfig {

    public final Environment env;

    public HibernateConfig(Environment environment) {
        this.env = environment;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource source) {

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(source);
        emf.setPackagesToScan("lk/ijse/gdse/springmvc_with_gradle/entity");

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(adapter);
        emf.setJpaPropertyMap(hibernateConfigs());
        return emf;

    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        ds.setUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        return ds;

    }

    @Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean emf) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf.getObject());
        return transactionManager;

    }

    private Map<String, String> hibernateConfigs() {

        HashMap<String, String> hbConfigs = new HashMap<>();
        hbConfigs.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        hbConfigs.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        hbConfigs.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        hbConfigs.put("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));

        return hbConfigs;

    }

}
