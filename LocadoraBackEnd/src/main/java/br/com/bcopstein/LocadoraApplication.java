package br.com.bcopstein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.bcopstein"})
public class LocadoraApplication {
  public static void main(String[] args) {
    SpringApplication.run(LocadoraApplication.class, args);
  }
}
