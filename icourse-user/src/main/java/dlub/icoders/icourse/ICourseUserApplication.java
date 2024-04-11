package dlub.icoders.icourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName ICourseGatewayApplication.java
 * @Description
 * @Author panda
 * @Date 2024/4/11 14:14
 * @Version 1.0
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ICourseUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ICourseUserApplication.class, args);
    }
}
