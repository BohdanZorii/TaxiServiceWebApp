package com.zorii.epam.taxi.app.utils;

import com.zorii.epam.taxi.app.entity.cab.Cab;
import com.zorii.epam.taxi.app.entity.order.Order;
import com.zorii.epam.taxi.app.entity.user.User;
import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.web.dto.CabDTO;
import com.zorii.epam.taxi.app.web.dto.OrderDTO;
import com.zorii.epam.taxi.app.web.dto.UserDTO;

import static com.zorii.epam.taxi.app.service.UserService.getByLogin;
import static com.zorii.epam.taxi.app.service.UserService.getRole;
import static com.zorii.epam.taxi.app.service.CabService.*;

public class Convertor {


    public static User convertDTOtoUser(UserDTO userDTO) throws ServiceException {
        return User.builder()
                .login(userDTO.getLogin())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .role(getRole(userDTO.getRole()))
                .build();
    }
    public static UserDTO convertUserToDTO(User user){
        return UserDTO.builder()
                .login(user.getLogin())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole().getName())
                .build();
    }

    public static Order convertDTOtoOrder(OrderDTO orderDTO){
        return Order.builder()
                .id(orderDTO.getId())
                .departureAddress(orderDTO.getDepartureAddress())
                .destinationAddress(orderDTO.getDestinationAddress())
                .numOfPassengers(Integer.valueOf(orderDTO.getNumOfPassengers()))
                .clientLogin(orderDTO.getClient().getLogin())
                .distance(Integer.valueOf(orderDTO.getDistance()))
                .cost(orderDTO.getCost())
                .build();
    }
    public static OrderDTO convertOrderToDTO(Order order) throws ServiceException{
        User client = getByLogin(order.getClientLogin());
        Cab cab = getById(order.getCabId());
        return OrderDTO.builder()
                .id(order.getId())
                .departureAddress(order.getDepartureAddress())
                .destinationAddress(order.getDestinationAddress())
                .numOfPassengers(String.valueOf(order.getNumOfPassengers()))
                .distance(String.valueOf(order.getDistance()))
                .cost(order.getCost())
                .client(convertUserToDTO(client))
                .cabCategory(cab.getCategory().getName())
                .build();
    }

    public static Cab convertDTOtoCab(CabDTO cabDTO) throws ServiceException{
        return Cab.builder()
                .id(cabDTO.getId())
                .capacity(cabDTO.getCapacity())
                .category(getCategory(cabDTO.getCategory()))
                .status(getStatus(cabDTO.getStatus()))
                .build();

    }
    public static CabDTO convertCabToDTO(Cab cab){
       return CabDTO.builder()
               .id(cab.getId())
               .capacity(cab.getCapacity())
               .category(cab.getCategory().getName())
               .status(cab.getStatus().getName())
               .build();
    }

}
