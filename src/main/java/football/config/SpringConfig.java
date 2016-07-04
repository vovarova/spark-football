package football.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Evegeny on 08/06/2016.
 */
@Configuration
@PropertySource({"classpath:teams.properties", "classpath:project.properties"})
public class SpringConfig {


    /*@Bean
    @Qualifier("dataPath")
    public String getDataPath() {
        return "data/rawData.txt";
    }*/

    @Bean
    @Qualifier("teams")
    public Properties teamsProperties() {
        return loadProperties("/teams.properties");
    }

    @Bean
    @Qualifier("rules")
    public Properties rulesProperties() {
        return loadProperties("/rules.properties");
    }

    @Bean
    @Qualifier("codes")
    public Properties codesProperties() {
        return loadProperties("/codes.properties");
    }

    private Properties loadProperties(String path) {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource(path));
        Properties properties = null;
        try {
            propertiesFactoryBean.afterPropertiesSet();
            properties = propertiesFactoryBean.getObject();

        } catch (IOException e) {
            System.out.println("Cannot load properties file." + e);
        }
        return properties;
    }


    @Bean
    public JavaSparkContext sc() {
        return new JavaSparkContext(new SparkConf().setMaster("local").setAppName("app"));
    }

    @Bean
    public SQLContext sqlContext() {
        return new SQLContext(sc());
    }


}
