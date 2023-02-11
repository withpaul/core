package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration

// 이걸 쓰면 어노테이션 적힌 걸 다 스캔해
@ComponentScan(
        // 이건 스캔에서 제외가 필요한 클래스들
        // AppConfig 내부를 보면 Component 어노테이션이 있어서.. 충돌나니까 추가한거임
        // 예제코드를 살리기 위해서 한거지 실무에서는 안함
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

public class AutoAppConfig {

}
