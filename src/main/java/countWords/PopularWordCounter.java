package countWords;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function2;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 11/06/2016.
 */
public class PopularWordCounter {

    public List<String> topX(JavaRDD<String> rdd, int x) {
       return rdd.map(String::toLowerCase).
                flatMap(line-> Arrays.asList(line.split(" ")))
                .mapToPair(word->new Tuple2<>(word,1))
                .reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .map(Tuple2::_2).take(x);

    }
}
