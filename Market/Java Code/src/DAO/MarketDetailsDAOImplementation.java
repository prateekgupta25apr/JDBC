package DAO;

import DTO.MarketDetailsDTO;

import java.sql.*;
import java.util.Scanner;

public class MarketDetailsDAOImplementation implements MarketDetailsDAO {
    @Override
    public boolean save(MarketDetailsDTO dto) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Market", "root", "root");
            statement = connection.prepareStatement(
                    "insert into market_details values(?,?,?,?)");
            statement.setInt(1, dto.getId());
            statement.setString(2, dto.getName());
            statement.setString(3, dto.getLocation());
            statement.setInt(4, dto.getNumberOfShops());
            result = !statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    @Override
    public void getAll() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Market", "root", "root");
            statement = connection.createStatement();
            ResultSet data = statement.executeQuery("select * from market_details;");
            while (data.next()) {
                System.out.println(data.getInt(1) + " : "
                        + data.getString(2) + "\t"
                        + data.getString(3) + "\t"
                        + data.getInt(4)
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    @Override
    public boolean updateNumberOfShops(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Market", "root", "root");
            statement = connection.prepareStatement(
                    "update market_details set numberOfShop=? where name=?;");
            System.out.println("Enter the updated number of shops");
            Scanner scanner = new Scanner(System.in);
            int updatedNumberOfShop = scanner.nextInt();
            scanner.nextLine();
            statement.setInt(1, updatedNumberOfShop);
            statement.setString(2, name);
            result = !statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    @Override
    public void getByLocation(String location) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Market", "root", "root");
            statement = connection.prepareStatement(
                    "select * from market_details where location=?;");
            statement.setString(1, location);
            ResultSet data = statement.executeQuery();
            System.out.println("Details of the shop in " + location);
            while (data.next()) {
                System.out.println(data.getInt(1) + " : "
                        + data.getString(2) + "\t"
                        + data.getString(3) + "\t"
                        + data.getInt(4)
                );
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public boolean deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result=false;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Market", "root", "root");
            statement = connection.prepareStatement(
                    "delete from market_details where id=?");
            statement.setInt(1,id);
            result= !statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return result;
    }


}
