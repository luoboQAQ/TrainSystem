package top.lbqaq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TrainSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainSystemApplication.class, args);
    }

}
