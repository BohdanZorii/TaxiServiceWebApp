package com.zorii.epam.taxi.app.service;

import com.zorii.epam.taxi.app.dao.UserDAO;
import com.zorii.epam.taxi.app.dao.utils.DAOFactory;
import com.zorii.epam.taxi.app.dao.utils.DataSourceManager;
import com.zorii.epam.taxi.app.entity.user.Role;
import com.zorii.epam.taxi.app.exception.DAOException;
import com.zorii.epam.taxi.app.exception.ServiceException;
import com.zorii.epam.taxi.app.exception.UserSigningInException;
import com.zorii.epam.taxi.app.web.dto.UserDTO;
import com.zorii.epam.taxi.app.entity.user.User;

import java.util.List;

import static com.zorii.epam.taxi.app.utils.Convertor.convertDTOtoUser;
import static com.zorii.epam.taxi.app.utils.Convertor.convertUserToDTO;
import static com.zorii.epam.taxi.app.utils.PasswordHasher.encrypt;
import static com.zorii.epam.taxi.app.utils.PasswordHasher.verify;
import static com.zorii.epam.taxi.app.utils.Validator.*;
import static com.zorii.epam.taxi.app.utils.Validator.validatePasswordRepeating;

public class UserService {
    private static final UserDAO userDAO;

    static {
        userDAO = DAOFactory.getInstance(DataSourceManager.getDataSource()).getUserDAO();
    }

    public static void addUser(UserDTO userDTO, String password, String repeatedPassword) throws ServiceException {

        validateLogin(userDTO.getLogin());
        validateName(userDTO.getFirstName());
        validateName(userDTO.getLastName());
        validateEmail(userDTO.getEmail());
        validatePasswordRepeating(password, repeatedPassword);

        User user = convertDTOtoUser(userDTO);
        user.setPassword(encrypt(password));
        user.setAmountSpent(0);
        user.setBalance(1000);
        user.setRole(getRole("CLIENT"));

        try {
            if (userDAO.isRegistered(user.getLogin())) {
                throw new UserSigningInException();
            }
            userDAO.add(user);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static User getByLogin(String login) throws ServiceException{
        User user;
        try {
            return userDAO.get(login);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    public static UserDTO signUserIn(String login, String password) throws ServiceException {
        UserDTO userDTO;
        try {
            if (!userDAO.isRegistered(login)) {
                System.out.println("ne zareestrovaniy");
                throw new UserSigningInException("not registered");
            }
            System.out.println("true");
            User user = userDAO.get(login);
            verify(password, user.getPassword());
            userDTO = convertUserToDTO(user);


        } catch (DAOException e) {
            throw new UserSigningInException(e);
        }
        return userDTO;
    }

    public static void updateInfo(UserDTO userDTO) throws ServiceException {
        validateName(userDTO.getFirstName());
        validateName(userDTO.getLastName());
        validateEmail(userDTO.getEmail());

        User user = convertDTOtoUser(userDTO);

        try {
            userDAO.updateUserInfo(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static void addAmountSpent(String userLogin, int amountToAdd)throws ServiceException{
        try {
            userDAO.addAmountSpent(userLogin, amountToAdd);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static Role getRole(String name) throws ServiceException {
        try {
        List<Role> roles = userDAO.getRoles();
        Role result = roles.get(0);
            for (Role role : roles) {
                if (role.getName().equals(name)) {
                    result = role;
                }
            }
            return result;

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
