package club.cupk.group06.ability.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "club.cupk.group06.data.system")
@ComponentScan(value = {"club.cupk.group06.ability.auth", "club.cupk.group06.common.core", "club.cupk.group06.config", "club.cupk.group06.data.system"})
public class Group06AbilityAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(Group06AbilityAuthApplication.class, args);
    }

}
