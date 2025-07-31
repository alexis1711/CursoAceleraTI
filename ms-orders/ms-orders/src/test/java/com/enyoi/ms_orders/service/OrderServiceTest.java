package com.enyoi.ms_orders.service;

import com.enyoi.ms_orders.config.EnvsFacade;
import com.enyoi.ms_orders.dto.ClientResponseDto;
import com.enyoi.ms_orders.dto.GenerateNewOrderDto;
import com.enyoi.ms_orders.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    RestTemplate restTemplate;

    @Mock
    EnvsFacade envsFacade;

    @InjectMocks
    OrderService orderService;

    @Test
    void shouldCreateNewOrder(){
        //Arrange
        when(envsFacade.getClientHostEnv()).thenReturn("localhost:8081");
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), eq(null),
                eq(ClientResponseDto.class))).thenReturn(getInstanceOfResponse()
        );

        //Act
        orderService.createNewOrder(getDtoInstance());

        //Assert
        verify(orderRepository).save(any());
    }

    @Test
    void shouldThrownAnException(){
        //Arrange
        when(envsFacade.getClientHostEnv()).thenThrow(new RuntimeException("Error"));

        //Act
        assertThrows(RuntimeException.class, () -> orderService.createNewOrder(getDtoInstance()));

        //Assert
        verify(orderRepository, never()).save(any());

    }

    private GenerateNewOrderDto getDtoInstance(){
        GenerateNewOrderDto dto = new GenerateNewOrderDto();
        dto.setClientEmail("prueba@mail.com");
        return dto;
    }

    private ResponseEntity<ClientResponseDto> getInstanceOfResponse(){
        ClientResponseDto dto = new ClientResponseDto();
        dto.setId("123");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
