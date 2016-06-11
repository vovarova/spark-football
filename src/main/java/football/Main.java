package football;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 08/06/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("football");
        FootballDataGenerator generator = context.getBean(FootballDataGenerator.class);
        for (int i = 0; i < 100; i++) {
           generator.generate();

        }
    }
}
