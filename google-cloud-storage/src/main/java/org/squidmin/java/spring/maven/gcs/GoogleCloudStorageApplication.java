package org.squidmin.java.spring.maven.gcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "org.squidmin.java.spring.maven.gcs")
public class GoogleCloudStorageApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GoogleCloudStorageApplication.class, args);
        System.out.println("Beans loaded: " + context.getBeanDefinitionCount());
    }

}
