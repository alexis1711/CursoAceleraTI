package com.enyoi.ms_orders.service;

import com.enyoi.ms_orders.config.EnvsFacade;
import com.enyoi.ms_orders.dto.*;
import com.enyoi.ms_orders.model.Order;
import com.enyoi.ms_orders.model.ProductOrder;
import com.enyoi.ms_orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    private final EnvsFacade envsFacade;

    public Order createNewOrder(GenerateNewOrderDto dto){

        String clientId = getClientId(dto.getClientEmail());
        Order order = new Order();
        order.setClientId(clientId);

        List<ProductOrder> productOrderList = new ArrayList<>();
        for (ProductShop productShop: dto.getProductShopList()){
            ProductOrder productOrder = new ProductOrder();
            String productId = getProductId(productShop.getName());
            productOrder.setOrder(order);
            productOrder.setProductId(productId);
            productOrderList.add(productOrder);
        }

        order.setProductOrderList(productOrderList);
        return orderRepository.save(order);


        /*String url = envsFacade.getClientHostEnv() + "/api/v1/client/" + dto.getClientEmail();
        ResponseEntity<ClientResponseDto> responseEntityDto = restTemplate.exchange(
                url, HttpMethod.GET, null, ClientResponseDto.class);
        if(responseEntityDto.getStatusCode().is2xxSuccessful()){
            ClientResponseDto bodyResponse = responseEntityDto.getBody();
            Order order = new Order();
            order.setClientId(bodyResponse.getId());
            return orderRepository.save(order);
        }*/

        //throw new RuntimeException("Error en el consumo de client");
    }

    private String getClientId(String clientEmail){
        String url = envsFacade.getClientHostEnv() + "/api/v1/client/" + clientEmail;
        ResponseEntity<ClientResponseDto> responseEntityDto = restTemplate.exchange(
                url, HttpMethod.GET, null, ClientResponseDto.class);
        return responseEntityDto.getBody().getId();
    }

    private String getProductId(String productName){
        String url = "http://localhost:8082/api/v1/product/" + productName;
        ResponseEntity<ProductResponseDto> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, null, ProductResponseDto.class
        );
        return responseEntity.getBody().getId();
    }

    public Order createNewOrderCreatingNewClient(CreateNewOrderNewClientDto dto){
        String url =  "http://localhost:8081/api/v1/client";


        HttpEntity<CreateNewOrderNewClientDto> request = new HttpEntity<>(dto);

        //LLAMO A MICROSERVICIO CLIENTES con la url, el verbo post, el contenido request, y esperando una respuesta ClientResponseDto
        ResponseEntity<ClientResponseDto> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, request, ClientResponseDto.class);

        ClientResponseDto bodyResponse = responseEntity.getBody();
        Order order = new Order();
        order.setClientId(bodyResponse.getId());
        return orderRepository.save(order);


    }

}
