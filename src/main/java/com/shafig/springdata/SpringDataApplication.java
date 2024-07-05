package com.shafig.springdata;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@OpenAPIDefinition(
//        info = @Info(title = "Elmin's App"),
//        servers = {@Server(url = "elmin-dev.app", description = "dev host"),
//                @Server(url = "elmin-test.app", description = "test host")}
//)
@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

}
