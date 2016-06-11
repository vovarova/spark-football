package countWords.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Evegeny on 11/06/2016.
 */
@Configuration
@ComponentScan(basePackages = "countWords")
public class RootConfig {
    @Autowired
    private SparkConf sparkConf;

    @Bean
    public JavaSparkContext sc() {
        return new JavaSparkContext(sparkConf);
    }
}
