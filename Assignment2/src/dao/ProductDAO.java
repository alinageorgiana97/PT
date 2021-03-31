package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Products;

public class ProductDAO {
	protected static final Logger LOGGER = Logger.getLogger(CustomerDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO products(name, price, quantity) VALUES (?, ?, ?); ";
	private final static String deleteStatementString = "DELETE FROM products WHERE idProduct = ?";
	private static final String selectAllStatementString = "SELECT * FROM products";
	private final static String findStatementString = "SELECT * FROM products where idProduct = ?;";
	private final static String updateStatementString = "UPDATE product SET name = ?, price = ?, quantity = ? WHERE idProduct = ?;";

	public static Products findById(int productId) {
		Products toReturn = null;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;

		try {
			
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, productId);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			int price = rs.getInt("price");
			int quantity = rs.getInt("quantity");
			toReturn = new Products( name, price, quantity);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:findById " + e.getMessage());
		} finally {
			// ConnectionFactory.close(rs);
			// ConnectionFactory.close(findStatement);
			// ConnectionFactory.close(dbConnection);
		}

		return toReturn;
	}

	public static int addProduct(Products product) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		int insertedId = -1;

		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, product.getName());
			insertStatement.setInt(2, product.getPrice());
			insertStatement.setInt(3, product.getQuantity());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
		} finally {
			// ConnectionFactory.close(insertStatement);
			// ConnectionFactory.close(dbConnection);
		}

		return insertedId;
	}
	public static void update(Products product) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;

		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setString(1, product.getName());
			updateStatement.setInt(2, product.getPrice());
			updateStatement.setInt(3, product.getQuantity());
			//updateStatement.setInt(4, product.getIdProduct());
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:update " + e.getMessage());
		} finally {
			// ConnectionFactory.close(updateStatement);
			// ConnectionFactory.close(dbConnection);
		}
	}

	public static void delete(int productId) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;

		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, productId);
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:delete " + e.getMessage());
		} finally {
			// ConnectionFactory.close(deleteStatement);
			// ConnectionFactory.close(dbConnection);
		}
	}

	

	

}
