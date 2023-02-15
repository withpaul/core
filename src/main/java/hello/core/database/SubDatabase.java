package hello.core.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sub")
public class SubDatabase implements Database{
    @Override
    public String connection(String name) {
        return "subDatabase connection";
    }
}
