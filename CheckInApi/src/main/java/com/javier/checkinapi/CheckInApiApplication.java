package com.javier.checkinapi;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import annotations.Generated;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import infraestructure.repositories.baggage.BaggageJpaRepository;
import infraestructure.repositories.check.in.CheckInJpaRepository;
import infraestructure.repositories.passanger.PassangerJpaRepository;
import infraestructure.repositories.seat.SeatJpaRepository;
import infraestructure.repositories.ticket.TicketJpaRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.Arrays;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import repositories.*;

@SpringBootApplication(
        exclude = {
                org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
                org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
                org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class
        }
)
@ComponentScan(
  basePackages = { "controllers", "infraestructure.repositories", "use.cases", "event", "core" }
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

  @Bean(name = "ticketRepository")
  public TicketRepository ticketRepository() { return new TicketJpaRepository(); }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }
    };
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


  @Value("${cloud.aws.region.static}")
  private String region;

  @Value("${cloud.aws.credentials.access-key}")
  private String awsAccessKey;

  @Value("${cloud.aws.credentials.secret-key}")
  private String awsSecretKey;

  @Value("${cloud.aws.topics.assigned-seat-arn}")
  private String assignedSeatArn;

  @Bean
  public QueueMessagingTemplate queueSQSMessagingTemplate() {
    return new QueueMessagingTemplate(amazonSQSAsync());
  }

//  @Bean
//  public QueueMessagingTemplate queueSNSMessagingTemplate() {
//    return new QueueMessagingTemplate(amazonSNSAsync());
//  }

  @Primary
  @Bean
  public AmazonSQSAsync amazonSQSAsync() {
    return AmazonSQSAsyncClientBuilder.standard().withRegion(Regions.US_EAST_1)
            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
            .build();
  }

  @Bean
  @Primary
  public AmazonSNS amazonSNSAsync () {
    return AmazonSNSAsyncClientBuilder.standard().withRegion(Regions.US_EAST_1)
            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
            .build();
  }
}

//@Configuration
//class SQSConfig {
//
//  @Value("${cloud.aws.region.static}")
//  private String region;
//
//  @Value("${cloud.aws.credentials.access-key}")
//  private String awsAccessKey;
//
//  @Value("${cloud.aws.credentials.secret-key}")
//  private String awsSecretKey;
//
//  @Bean
//  public QueueMessagingTemplate queueMessagingTemplate() {
//    return new QueueMessagingTemplate(amazonSQSAsync());
//  }
//
//  public AmazonSQSAsync amazonSQSAsync() {
//    return AmazonSQSAsyncClientBuilder.standard().withRegion(Regions.US_EAST_1)
//            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
//            .build();
//  }
//
////	@Bean
////	public SimpleMessageListenerContainer simpleMessageListenerContainer() {
////	    SimpleMessageListenerContainer msgListenerContainer = simpleMessageListenerContainerFactory()
////	            .createSimpleMessageListenerContainer();
////	    msgListenerContainer.setMessageHandler(queueMessageHandler());
////	    return msgListenerContainer;
////	}
////
////	@Bean
////	public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory() {
////	    SimpleMessageListenerContainerFactory msgListenerContainerFactory = new SimpleMessageListenerContainerFactory();
////	    msgListenerContainerFactory.setAmazonSqs(amazonSQSAsync());
////	    return msgListenerContainerFactory;
////	}
////
////	@Bean
////	public QueueMessageHandler queueMessageHandler() {
////	    QueueMessageHandlerFactory queueMsgHandlerFactory = new QueueMessageHandlerFactory();
////	    queueMsgHandlerFactory.setAmazonSqs(amazonSQSAsync());
////	    QueueMessageHandler queueMessageHandler = queueMsgHandlerFactory.createQueueMessageHandler();
////	    List<HandlerMethodArgumentResolver> list = new ArrayList<>();
////	    HandlerMethodArgumentResolver resolver = new PayloadArgumentResolver(new MappingJackson2MessageConverter());
////	    list.add(resolver);
////	    queueMessageHandler.setArgumentResolvers(list);
////	    return queueMessageHandler;
////	}
//}
