package com.javier.checkinapi;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import annotations.Generated;
import infraestructure.repositories.baggage.BaggageJpaRepository;
import infraestructure.repositories.check.in.CheckInJpaRepository;
import infraestructure.repositories.passanger.PassangerJpaRepository;
import infraestructure.repositories.seat.SeatJpaRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.Arrays;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import repositories.BaggageRepository;
import repositories.CheckInRepository;
import repositories.PassangerRepository;
import repositories.SeatRepository;

@SpringBootApplication
@ComponentScan(
  basePackages = { "controllers", "infraestructure.repositories", "use.cases" }
)
@EntityScan("infraestructure.model")
@EnableJpaRepositories(basePackages = { "infraestructure.repositories" })
@EnableTransactionManagement
@OpenAPIDefinition(info = @Info(title = "Check in Domain", version = "1.0.0"))
@Generated
public class CheckInApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(CheckInApiApplication.class, args);
  }

  @Bean(name = "checkInRepository")
  public CheckInRepository checkInRepository() {
    return new CheckInJpaRepository();
  }

  @Bean(name = "passangerRepository")
  public PassangerRepository passangerRepository() {
    return new PassangerJpaRepository();
  }

  @Bean(name = "seatRepository")
  public SeatRepository seatRepository() {
    return new SeatJpaRepository();
  }

  @Bean(name = "baggageRepository")
  public BaggageRepository baggageRepository() {
    return new BaggageJpaRepository();
  }

  @Bean
  Pipeline pipeline(
    ObjectProvider<Command.Handler> commandHandlers,
    ObjectProvider<Notification.Handler> notificationHandlers,
    ObjectProvider<Command.Middleware> middlewares
  ) {
    return new Pipelinr()
      .with(commandHandlers::stream)
      .with(notificationHandlers::stream)
      .with(middlewares::orderedStream);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {}
    };
  }
}
