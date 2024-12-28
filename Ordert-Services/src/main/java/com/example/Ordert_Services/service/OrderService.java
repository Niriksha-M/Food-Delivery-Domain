package com.example.Ordert_Services.service;

import com.example.Ordert_Services.dto.OrderDto;
import com.example.Ordert_Services.dto.ResponseDto;
import com.example.Ordert_Services.dto.RestaurantDto;
import com.example.Ordert_Services.model.OrderInfo;
import com.example.Ordert_Services.repository.OrderRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepository;

    private  final WebClient webClient;
   /* @Autowired
    public OrderService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9097").build();
    }
*/
    public OrderInfo addOrder(OrderInfo info) {
        return orderRepository.save(info);
    }

   /* @CircuitBreaker(name = "orderService", fallbackMethod = "fallbackGetOrder")
    public ResponseDto getOrder(long menuid) {
        ResponseDto responseDto = new ResponseDto();
        OrderInfo orderInfo = orderRepository.findByMenuid(menuid).orElseThrow(() -> new RuntimeException("Order not found"));
        OrderDto driverDto = mapToOrderDto(orderInfo);

        List<RestaurantDto> restaurantDtos = webClient.get()
                .uri("http://localhost:9097/menu/" + orderInfo.getMenuItemId())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<RestaurantDto>>() {
                })
                .block();

        responseDto.setOrderDto(driverDto);
        responseDto.setRestaurantDto(restaurantDtos);

        return responseDto;
    }
*/
   public OrderService(WebClient.Builder webClientBuilder, OrderRepo orderRepository) {
       this.webClient = webClientBuilder.baseUrl("http://localhost:9097").build();
       this.orderRepository = orderRepository;
   }

    public Mono<ResponseDto> getOrder(long menuid) {
        return orderRepository.findByMenuid(menuid)
                .map(orderInfo -> {
                    // Map orderInfo to OrderDto
                    OrderDto orderDto = mapToOrderDto(orderInfo);

                    // Call the other microservice to get restaurant data
                    return webClient.get()
                            .uri("/menu/{menuid}" + orderInfo.getMenuItemId())  // Adjust URI as per your API
                            .retrieve()
                            .bodyToMono(new ParameterizedTypeReference<List<RestaurantDto>>() {})
                            .onErrorResume(WebClientResponseException.class, e -> {
                                // Handle WebClient errors like 404 or 500
                                return Mono.error(new RuntimeException("Error fetching restaurant data", e));
                            })
                            .map(restaurantDtos -> {
                                // Create and populate the ResponseDto
                                ResponseDto responseDto = new ResponseDto();
                                responseDto.setOrderDto(orderDto);
                                responseDto.setRestaurantDto(restaurantDtos);
                                return responseDto;
                            });
                })
                .orElse(Mono.error(new RuntimeException("Order not found")));  // Handle order not found
    }
    private OrderDto mapToOrderDto(OrderInfo order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setMenuItemId(order.getMenuItemId());
        orderDto.setQuantity(order.getQuantity());
        return orderDto;
    }

    public Optional<OrderInfo> getOrderById(int id) {
        return orderRepository.findById((long) id);
    }
}
