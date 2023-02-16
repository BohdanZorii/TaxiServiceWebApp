package com.zorii.epam.taxi.app.dao.mysql;

import com.zorii.epam.taxi.app.dao.OrderDAO;
import com.zorii.epam.taxi.app.entity.order.Order;
import com.zorii.epam.taxi.app.exception.DAOException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.zorii.epam.taxi.app.dao.constant.SQLQueries.*;

public class MySQLOrderDAO implements OrderDAO {
    private DataSource dataSource;
    public MySQLOrderDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public void add(Order order) throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_ORDER)) {

            statement.setString(1, order.getDepartureAddress());
            statement.setString(2, order.getDestinationAddress());
            statement.setInt(3, order.getNumOfPassengers());
            statement.setInt(4, order.getCost());
            statement.setDate(5, order.getDateOfOrder());
            statement.setInt(6, order.getCabId());
            statement.setString(7, order.getClientLogin());
            statement.setInt(8, order.getDistance());

            statement.execute();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Order get(int id) throws DAOException {
        Order order = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ORDER)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    order = parseResultSet(rs);
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByConditions(String postfixQuery) throws DAOException {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDERS + postfixQuery)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    orders.add(parseResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return orders;
    }

    @Override
    public int calculateTotalRecordsNum() throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(CALCULATE_ORDERS_NUM)) {

            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);


        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private Order parseResultSet(ResultSet rs) throws SQLException {
        return Order.builder().
                id(rs.getInt("id"))
                .departureAddress(rs.getString("departure_address"))
                .destinationAddress(rs.getString("destination_address"))
                .numOfPassengers(rs.getInt("num_of_passengers"))
                .cost(rs.getInt("cost_of_order"))
                .dateOfOrder(rs.getDate("date_of_order"))
                .cabId(rs.getInt("cab_id"))
                .clientLogin(rs.getString("client_login"))
                .distance(rs.getInt("distance"))
                .build();
    }
}
