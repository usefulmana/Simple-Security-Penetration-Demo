package com.example.demo;

import com.example.demo.models.Tool;
import com.example.demo.models.User;
import com.example.demo.repos.ToolRepository;
import com.example.demo.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    CommandLineRunner initDatabase(ToolRepository toolRepository,
                                   UserRepository userRepository
                                   ){
        return args -> {
            User user = new User("user@gmail.com", "123456");
            userRepository.save(user);

            // Public Tools creation
            Tool hammer = new Tool("Hammer", 3, 10.99);
            Tool nail = new Tool("Nail", 15, 0.99);
            Tool nailGun = new Tool("Nail Gun", 2, 20.99);

            toolRepository.save(hammer);
            toolRepository.save(nail);
            toolRepository.save(nailGun);

            // Private Tools Creation

            Tool superSecretTool = new Tool("Super Secret Tool", 1, 999.99);
            superSecretTool.setVisible(false);
            Tool ultraSecretTool = new Tool("Ultra Secret Tool", 1, 9999.99);
            ultraSecretTool.setVisible(false);
            toolRepository.save(superSecretTool);
            toolRepository.save(ultraSecretTool);
        };
    }
}
