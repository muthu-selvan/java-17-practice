package com.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.util.*;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 07-06-2024, Friday
 **/

public class ConnectionExample {

    private static Connection connection;
    private static String INSERT_ARTIST =
            "INSERT INTO music.artists (artist_name) VALUES (?)";

    private static String INSERT_ALBUM =
            "INSERT INTO music.albums (artist_id, album_name) VALUES (? , ?) ";

    private static String INSERT_SONG =
            "INSERT INTO music.songs (album_id, track_number, song_title) VALUES (? , ? , ?) ";

    private static Connection getConnection() {

        if (connection == null) {
            final Properties properties = new Properties();

            try {
                properties.load(Files.newInputStream(Path.of("music.properties"), StandardOpenOption.READ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            final var dataSource = new MysqlDataSource();
            final String userName = properties.getProperty("user");
            final String password = properties.getProperty("password");

            dataSource.setServerName(properties.getProperty("serverName"));
            dataSource.setPort(Integer.parseInt(properties.getProperty("port")));
            dataSource.setDatabaseName(properties.getProperty("databaseName"));
            try {
                connection = dataSource.getConnection(userName, String.valueOf(password));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }

    private static boolean insertRecord(Statement statement, String tableName, String[] columnNames, String[] columnValues)
            throws SQLException {
        String colNames = String.join(",", columnNames);
        String colValues = String.join(",", columnValues);

        String query = "INSERT INTO %s (%s) VALUES ('%s')"
                .formatted(tableName, colNames, colValues);
        System.out.println("query = " + query);
        boolean insertResult = statement.execute(query);
        System.out.println("insertResult = " + insertResult);

        return insertResult;
    }

    private static void preparedStatementExample() {
        try {
            var connection = getConnection();
            final String query = "SELECT * FROM music.albumview where artist_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Elf");
            ResultSet resultSet = preparedStatement.executeQuery();
            printRecords(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void selectExample() {
        final String albumName = "Tapestry";
        final String selectQuery = "SELECT * FROM music.albumview WHERE album_name='%s'"
                .formatted(albumName);

        try {
            var connection = getConnection();
            var statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(selectQuery);
            printRecords(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int addArtist(final PreparedStatement preparedStatement, Connection connection, String artistName) throws SQLException {
        int artistId = -1;
        preparedStatement.setString(1, artistName);
        int insertedCount = preparedStatement.executeUpdate();

        if(insertedCount > 0) {
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if(generatedKeys.next()) {
                artistId = generatedKeys.getInt(1);
                System.out.println("Auto Incremented ID : "+artistId);
            }
        }

        return artistId;
    }

    private static void printRecords(final ResultSet resultSet) {
        try {
            final var metaData = resultSet.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.printf("%-15s",
                        metaData.getColumnName(i).toUpperCase());
            }
            System.out.println();
            while (resultSet.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.printf("%-15s", resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public static void main (String[]args){
            selectExample();
            System.out.println("++++++++++++++++");
            preparedStatementExample();
        }
    }
