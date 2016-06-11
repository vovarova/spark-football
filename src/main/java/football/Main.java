package football;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 08/06/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("football");
        context.getBeansOfType(Mapper.class).values().stream().map(Mapper::get).forEach(System.out::println);
    }
}
