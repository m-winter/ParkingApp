package Training.Exercise2;

import Training.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingDAOImpl implements ParkingDAO {

    static final String connectionString = "jdbc:mysql://localhost:3306/classicmodels";
    static final String rootString = "root";
    static final String passwordString = "Pa$$word";

    @Override
    public void crateParking() {
        try (Connection conn = DriverManager.getConnection(connectionString, rootString, passwordString)) {
            String createQuery = "CREATE TABLE IF NOT exists parking (" +
                    "id INTEGER serial default value,\n" +
                    "isFree bit," +
                    "isNormal bit" +
                    ");";
            Statement statement = conn.createStatement();

            statement.executeUpdate(createQuery);
            System.out.println("Table created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteParking() {
        try (Connection conn = DriverManager.getConnection(connectionString, rootString, passwordString)) {
            String dropQuery = "DROP TABLE parking";
            Statement statement = conn.createStatement();

            statement.executeUpdate(dropQuery);
            System.out.println("Table removed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createEmptySpot(ParkingSpot parkingSpot) {
        try (Connection conn = DriverManager.getConnection(connectionString, rootString, passwordString)) {
            String parkingAddQuery = "insert into parking ( isFree, isNormal) values (?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(parkingAddQuery);

            preparedStatement.setBoolean(1, parkingSpot.isFree);
            preparedStatement.setBoolean(2, parkingSpot.isNormal);

            preparedStatement.executeUpdate();
            System.out.println("Inserted element");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSpot(int id) {
        try (Connection conn = DriverManager.getConnection(connectionString, rootString, passwordString)) {
            String parkingDeleteQuery = "DELETE FROM parking WHERE id = " + id;

            Statement statement = conn.createStatement();

            statement.executeUpdate(parkingDeleteQuery);
            System.out.println(id + "-element removed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeSpotStatus(int id, boolean isTrue) {
        try (Connection conn = DriverManager.getConnection(connectionString, rootString, passwordString)) {
            String parkingUpdateQuery = "UPDATE parking SET isFree = " + isTrue + " WHERE id =" + id;

            Statement statement = conn.createStatement();

            statement.executeUpdate(parkingUpdateQuery);
            System.out.println("Parking spot" + id + " updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void changeSpotType(int id, boolean isTrue) {
        try (Connection conn = DriverManager.getConnection(connectionString, rootString, passwordString)) {
            String parkingUpdateQuery = "UPDATE parking SET isNormal = " + isTrue + " WHERE id =" + id;

            Statement statement = conn.createStatement();

            statement.executeUpdate(parkingUpdateQuery);
            System.out.println("Parking spot " + id + " updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ParkingSpot> findById(int id) {
        ParkingSpot parkingSpot = new ParkingSpot();
        try (Connection conn = DriverManager.getConnection(connectionString, rootString, passwordString)) {
            String parkingSpotUpdateQuery = "SELECT * from parking WHERE id=" + id;

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(parkingSpotUpdateQuery);

            while (resultSet.next()) {
                parkingSpot.setId(resultSet.getInt(1));
                parkingSpot.setFree(resultSet.getBoolean(2));
                parkingSpot.setNormal(resultSet.getBoolean(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.of(parkingSpot);
    }

    @Override
    public List<ParkingSpot> findAll() {
        List<ParkingSpot> parkingSpotsList = new ArrayList<>();
        ResultSet resultSet;
        try (Connection conn = DriverManager.getConnection(connectionString, rootString, passwordString)) {
            String parkingUpdateQuery = "SELECT * from parking";

            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(parkingUpdateQuery);

            while (resultSet.next()) {
                ParkingSpot parkingSpot = new ParkingSpot();

                parkingSpot.setId(resultSet.getInt(1));
                parkingSpot.setFree(resultSet.getBoolean(2));
                parkingSpot.setNormal(resultSet.getBoolean(3));

                parkingSpotsList.add(parkingSpot);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkingSpotsList;
    }
}
