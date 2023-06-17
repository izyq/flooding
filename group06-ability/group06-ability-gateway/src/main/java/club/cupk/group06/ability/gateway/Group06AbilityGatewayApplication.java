package club.cupk.group06.ability.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Group06AbilityGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Group06AbilityGatewayApplication.class, args);
    }

}
