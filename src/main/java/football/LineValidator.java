package football;

import org.apache.spark.sql.DataFrame;

/**
 * Created by Evegeny on 11/06/2016.
 */
public interface LineValidator {
    DataFrame validate(DataFrame dataFrame);
}
