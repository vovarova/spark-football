package countWords;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Evegeny on 11/06/2016.
 */
@Component
public class UserConfig {
    public Set<String> garbage;

    @Value("${garbage}")
    private void setGarbage(String[] garbage) {
        this.garbage = new HashSet<>(Arrays.asList(garbage));
    }
}
