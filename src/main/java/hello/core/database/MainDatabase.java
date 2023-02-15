package hello.core.database;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MainDatabase implements Database {
    @Override
    public String connection(String name) {
        return "main db connection";
    }
}
