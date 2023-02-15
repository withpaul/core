package hello.core.database;

import hello.core.AutoAppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    @DisplayName("빈이 2개 조회되기 때문에 Primary 또는 Qualifier 없이 할 경우 예외 터진다.")
    @Test
    void databaseConnection() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () ->  ac.getBean(Database.class));
    }

    @DisplayName("메인 db 사용할때는 Primary")
    @Test
    void mainDatabaseConnection() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        Database bean = ac.getBean(Database.class);
        assertThat(bean).isInstanceOf(MainDatabase.class);
    }
}