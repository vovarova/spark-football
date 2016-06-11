package football;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Evegeny on 10/06/2016.
 */
@Service
public class FootballDataGenerator {
    @Autowired
    private CodesMapper codesMapper;
    @Autowired
    private TeamsMapper teamsMapper;
    @Autowired
    private RulesMapper rulesMapper;

    public void generate() {
    }
}
