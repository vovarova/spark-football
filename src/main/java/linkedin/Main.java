package linkedin;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.functions;

/**
 * Created by Evegeny on 11/06/2016.
 */
public class Main {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("linked in").setMaster("local[1]");
        SparkContext sparkContext = new SparkContext(sparkConf);

        SQLContext sqlContext = new SQLContext(sparkContext);
        DataFrame linkedIn = sqlContext.read().json("data/linkedin/*.json");
        linkedIn.show();

        DataFrame withSalary = linkedIn.withColumn("salary", functions.size(functions.column("keywords")).multiply(functions.column("age")).multiply(10)).drop("age");
        withSalary.show();

        DataFrame keywords = linkedIn.select(functions.explode(functions.column("keywords")).as("keyword"));
        keywords.show();

        DataFrame orderedBy = keywords.groupBy("keyword")
                .agg(functions.count("keyword").as("amount"))
                .orderBy(functions.column("amount").desc());
        orderedBy.show();

        String mostPopularWord = orderedBy.first().getString(orderedBy.schema().fieldIndex("keyword"));
        System.out.println("mostPopularWord = " + mostPopularWord);

        withSalary.where(
                functions.column("salary").leq(1200).and(functions.array_contains(functions.column("keywords"),mostPopularWord)))
                .select("name","salary").show();

    }

}
