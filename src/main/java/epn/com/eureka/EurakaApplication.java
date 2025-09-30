package epn.com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurakaApplication {

    public static void main(String[] args) {
        System.out.println("Iniciando Ejecucion de Eureka");
        SpringApplication.run(EurakaApplication.class, args);
    }
}
