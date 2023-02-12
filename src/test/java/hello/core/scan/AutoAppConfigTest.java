package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.junit.jupiter.api.Assertions.*;

public class AutoAppConfigTest {

    @DisplayName("컴포넌트 방식")
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);

    }

    @DisplayName("커스텀 MyIncludeComponent 적용된 Bean이 실제 Componentscan에서 include 되는지 확인")
    @Test
    void includeComponentScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(includeOrExcludeComponentFilter.class);
        IncludeFilter bean = ac.getBean(IncludeFilter.class);
        Assertions.assertThat(bean).isNotNull();
    }

    @DisplayName("커스텀 MyExcludeComponent 적용된 Bean이 실제 Componentscan에서 exclude 되는지 확인")
    @Test
    void excludeComponentScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(includeOrExcludeComponentFilter.class);
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean(ExcludeFilter.class));
    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    static class includeOrExcludeComponentFilter {
    }
}
