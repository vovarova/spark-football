package countWords;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 11/06/2016.
 */
public class PopularWordCounterTest {

    @Test
    public void testTopX() throws Exception {
        List<String> list = Arrays.asList("Java the java the java, the", "Scala the Groovy the groovy", "pascal kotlin");
        SparkConf conf = new SparkConf().setAppName("my app").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> rdd = sc.parallelize(list);

        PopularWordCounter wordCounter = new PopularWordCounter();
        List<String> popularWords = wordCounter.topX(rdd, 3);
        Assert.assertEquals("java", popularWords.get(0));
        Assert.assertEquals("groovy", popularWords.get(1));

    }
}