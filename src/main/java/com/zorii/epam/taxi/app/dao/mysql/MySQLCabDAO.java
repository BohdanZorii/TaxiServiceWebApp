package com.zorii.epam.taxi.app.dao.mysql;

import com.zorii.epam.taxi.app.dao.CabDAO;
import com.zorii.epam.taxi.app.entity.cab.Cab;
import com.zorii.epam.taxi.app.entity.cab.Category;
import com.zorii.epam.taxi.app.entity.cab.Status;
import com.zorii.epam.taxi.app.exception.DAOException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.zorii.epam.taxi.app.dao.constant.SQLQueries.*;

public class MySQLCabDAO implements CabDAO {
    private DataSource dataSource;

    public MySQLCabDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Cab get(int id) throws DAOException {
        Cab cab = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CAB)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    cab = parseCab(rs);
                }
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return cab;
    }

    @Override
    public List<Cab> getSuitableCabs(int numOfPassengers, int categoryId) throws DAOException {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CABS)) {
            statement.setInt(1, numOfPassengers);
            statement.setInt(2, categoryId);

            ResultSet rs = statement.executeQuery();

            List<Cab> cabs = new ArrayList<>();
            while (rs.next()) {
                Cab cab = parseCab(rs);
                cabs.add(cab);
            }
            return cabs;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void updateStatus(int id, int statusId) throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CAB_STATUS)) {

            statement.setInt(1, id);
            statement.setInt(2, statusId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public int calculateTotalRecordsNum() throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(CALCULATE_CABS_NUM)) {

            ResultSet rs = statement.executeQuery();

            return rs.getInt(1);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Status> getStatuses() throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_STATUSES)) {
            ResultSet rs = statement.executeQuery();

            List<Status> statuses = new ArrayList<>();
            while (rs.next()) {
                Status status = parseStatus(rs);
                statuses.add(status);
            }

            return statuses;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Category> getCategories() throws DAOException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CATEGORIES)) {
            ResultSet rs = statement.executeQuery();

            List<Category> categories = new ArrayList<>();
            while (rs.next()) {
                Category category = parseCategory(rs);
                categories.add(category);
            }

            return categories;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private Cab parseCab(ResultSet rs) throws SQLException {
        return Cab.builder()
                .id(rs.getInt("id"))
                .capacity(rs.getInt("capacity"))
                .category(parseCategory(rs))
                .status(parseStatus(rs))
                .build();
    }

    private Category parseCategory(ResultSet rs) throws SQLException {
        return Category.builder()
                .id(rs.getInt("category_id"))
                .name(rs.getString("category_name"))
                .tariff(rs.getInt("tariff"))
                .build();
    }

    private Status parseStatus(ResultSet rs) throws SQLException {
        return Status.builder()
                .id(rs.getInt("status_id"))
                .name(rs.getString("status_name"))
                .build();
    }



}
