package org.example.karthick;

public class MicroservicesCommunication {

    /Synchronous
    @Autowired
return
        -

    RestTemplate(legacy)

    privateRestTemplaterestTemplate;
restTemplate.getForObject(
    @Service
    public
    public User

    class
    OrderService
getUser(Long
"http://user-service/api/users/"
    userId)
            +

    {
        {
            userId,
                    User.class );
        }
    } // Synchronous - WebClient (recommended) @Service public class

    OrderService
Mono<User>

    {
        @Autowired
                getUser(Long
        private
        userId)
        WebClient.Builder
        {
            return
                    webClientBuilder;public
            webClientBuilder.build().get()
                    .uri("http://user-service/api/users/" + userId).retrieve().bodyToMono(User.class);
        }
    } // Synchronous - Feign Client (declarative) @FeignClient(name = "user-service")

    public
    interface
    UserClient
getUserById(

    @PathVariable
            (RabbitMQ / Kafka)
    RabbitTemplate
    @Service
            Long
    id);
    public rabbitTemplate;

    {
    }

    class
    public
    @GetMapping("/api/users/{id}") User
//Queue
            Asynchronous
    OrderService

    void {
        -
                Message
        @Autowired
                createOrder(Order
        private
        order)
        {
            rabbitTemplate.convertAndSend("order-exchange", "order.created", order);
        }
    }
}
