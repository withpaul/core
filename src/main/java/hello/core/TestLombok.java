package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.SpringApplication;

@Getter
@Setter
@ToString
public class TestLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        TestLombok testLombok = new TestLombok();
        testLombok.setAge(33);
        testLombok.setName("haha");
        System.out.println("TestLombok.TestLombok" + testLombok.toString());
    }
}
