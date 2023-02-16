package com.zorii.epam.taxi.app.dao.mysql;

import com.zorii.epam.taxi.app.dao.UserDAO;
import com.zorii.epam.taxi.app.entity.cab.Status;
import com.zorii.epam.taxi.app.entity.user.Role;
import com.zorii.epam.taxi.app.entity.user.User;
import com.zorii.epam.taxi.app.exception.DAOException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.zorii.epam.taxi.app.dao.constant.SQLQueries.*;

public class MySQLUserDAO implements UserDAO {
    private DataSource dataSource;

    public MySQLUserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(User user) throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_USER)) {

            fillCreateStatement(user, statement);
            statement.execute();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public User get(String login) throws DAOException {
        User user = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USER)) {
            statement.setString(1, login);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    user = parseUser(rs);
                }
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return user;
    }

    @Override
    public void updateUserInfo(User user) throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_INFO)) {

            fillUpdateStatement(user, statement);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean isRegistered(String login) throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(LOGIN_CHECK)) {

            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getBoolean(1);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean isPasswordCorrect(String password, String login) throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(PASSWORD_CHECK)) {

            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            return rs.getInt(1) == 0 ? true : false;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public int calculateAmountSpent(String login) throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(CALCULATE_SUM)) {

            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();

            return rs.getInt(1);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    @Override
    public List<Role> getRoles() throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ROLES)) {
            ResultSet rs = statement.executeQuery();

            List<Role> roles = new ArrayList<>();
            while (rs.next()) {
                Role role = parseRole(rs);
                roles.add(role);
            }

            return roles;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private void fillCreateStatement(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getLogin());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getFirstName());
        statement.setString(4, user.getLastName());
        statement.setString(5, user.getEmail());
        statement.setInt(6, user.getBalance());
        statement.setInt(7, user.getAmountSpent());
        statement.setInt(8, user.getRole().getId());
    }

    private void fillUpdateStatement(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getLogin());
    }

    private Role parseRole(ResultSet rs) throws SQLException{
        return Role.builder().
                id(rs.getInt("role_id"))
                .name(rs.getString("role_name"))
                .build();
    }
    private User parseUser(ResultSet rs) throws SQLException {
        return User.builder()
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .email(rs.getString("email"))
                .balance(rs.getInt("balance"))
                .amountSpent(rs.getInt("amount_spent"))
                .role(parseRole(rs))
                .build();
    }
}
