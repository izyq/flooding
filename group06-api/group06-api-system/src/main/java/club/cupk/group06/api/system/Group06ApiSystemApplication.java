package club.cupk.group06.api.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "club.cupk.group06.data.system.mapper")
public class Group06ApiSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(Group06ApiSystemApplication.class, args);
    }

}
