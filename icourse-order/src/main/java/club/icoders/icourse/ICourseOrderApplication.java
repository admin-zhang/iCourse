package club.icoders.icourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ICourseGatewayApplication.java
 * @Description
 * @Author panda
 * @Date 2024/4/11 14:14
 * @Version 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ICourseOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ICourseOrderApplication.class, args);
    }
}
