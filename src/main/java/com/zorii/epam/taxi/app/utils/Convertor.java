package com.zorii.epam.taxi.app.utils;

import com.zorii.epam.taxi.app.entity.cab.Cab;
import com.zorii.epam.taxi.app.entity.cab.Category;
import com.zorii.epam.taxi.app.entity.order.Order;
import com.zorii.epam.taxi.app.entity.user.User;
import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.web.dto.CabDTO;
import com.zorii.epam.taxi.app.web.dto.CategoryDTO;
import com.zorii.epam.taxi.app.web.dto.OrderDTO;
import com.zorii.epam.taxi.app.web.dto.UserDTO;

import static com.zorii.epam.taxi.app.service.UserService.getByLogin;
import static com.zorii.epam.taxi.app.service.UserService.getRole;
import static com.zorii.epam.taxi.app.service.CabService.*;
import static com.zorii.epam.taxi.app.web.controller.constant.Params.EN;

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

    public static UserDTO convertUserToDTO(User user) {
        return UserDTO.builder()
                .login(user.getLogin())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole().getName())
                .build();
    }

    public static Order convertDTOtoOrder(OrderDTO orderDTO) {
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

    public static OrderDTO convertOrderToDTO(Order order, String locale) throws ServiceException {
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
                .cabCategory(convertCategoryToDTO(cab.getCategory(), locale))
                .date(order.getDateOfOrder())
                .build();
    }

    public static Cab convertDTOtoCab(CabDTO cabDTO) throws ServiceException {
        return Cab.builder()
                .id(cabDTO.getId())
                .capacity(cabDTO.getCapacity())
                .category(getCategory(cabDTO.getCategory().getName()))
                .status(getStatus(cabDTO.getStatus()))
                .build();

    }

    public static CabDTO convertCabToDTO(Cab cab, String locale) {
        return CabDTO.builder()
                .id(cab.getId())
                .capacity(cab.getCapacity())
                .category(convertCategoryToDTO(cab.getCategory(), locale))
                .status(cab.getStatus().getName())
                .build();
    }

    public static CategoryDTO convertCategoryToDTO(Category category, String locale) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(locale.equals(EN) ? category.getNameOnEN() : category.getNameOnUA())
                .build();
    }

}
