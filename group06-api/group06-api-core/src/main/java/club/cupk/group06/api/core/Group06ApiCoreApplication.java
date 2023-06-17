package club.cupk.group06.api.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = "club.cupk.group06.data.core.mapper")
@ComponentScan(value = {"club.cupk.group06.api.core", "club.cupk.group06.common.core", "club.cupk.group06.config"})
public class Group06ApiCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(Group06ApiCoreApplication.class, args);
    }

}
