package connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String USER = "root";
	private static final String PASS = "";
	private static final String DBURL = "jdbc:mysql://localhost:3306/warehousedb";
	private static Connection singleInstance;

	private ConnectionFactory() {
		if (singleInstance == null) {
			try {
				singleInstance = DriverManager.getConnection(DBURL, USER, PASS);
			} catch (SQLException e) {
				System.out.println("Nu s-a reusit conexiunea cu baza de date");
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {
		new ConnectionFactory();
		return singleInstance;

	}
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
			}
		}
	}

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
			}
		}
	}}
