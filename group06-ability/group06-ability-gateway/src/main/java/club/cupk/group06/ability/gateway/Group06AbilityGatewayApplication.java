package club.cupk.group06.ability.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value = {"club.cupk.group06.ability.gateway", "club.cupk.group06.common.core", "club.cupk.group06.config"})
public class Group06AbilityGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Group06AbilityGatewayApplication.class, args);
    }

}
