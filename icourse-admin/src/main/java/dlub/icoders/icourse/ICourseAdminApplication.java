package dlub.icoders.icourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ICourseAdminController.java
 * @Description
 * @Author panda
 * @Date 2024/4/11 14:11
 * @Version 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ICourseAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ICourseAdminApplication.class, args);
    }
}
