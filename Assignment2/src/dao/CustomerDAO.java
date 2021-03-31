package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.ConnectionFactory;
import model.Customer;

public class CustomerDAO {
	protected static final Logger LOGGER = Logger.getLogger(CustomerDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO customer (name,address,email)"
			+ " VALUES (?,?,?)";
	private final static String findStatementString = "SELECT * FROM customer where idCustomer = ?;";
	private static final String removeStatementString = "DELETE FROM customer  WHERE idCustomer = ?";
    private static final String selectStatementString = "SELECT * FROM customer";
   private final static String updateStatementString = "UPDATE customer SET name = ?,address=?, email = ? WHERE idCustomer = ?;";
	
    
    
    public static Customer findById(int CustomerId) {
		Customer toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, CustomerId);
			rs = findStatement.executeQuery();
			rs.next();
			//int CustomerId = rs.getInt("idCustomer");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String email = rs.getString("email");
			
			toReturn = new Customer( CustomerId ,name, address, email);
		} catch (SQLException e) {
			
			LOGGER.log(Level.WARNING,"CustomerDAO:findById " + e.getMessage());
		} finally {
			//ConnectionFactory.close(rs);
			//ConnectionFactory.close(findStatement);
			//ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	public static int  addCustomer(Customer customer) throws SQLException {
		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = ConnectionFactory.getConnection().prepareStatement(insertStatementString);
			
			insertStatement.setString(1, customer.getName());
			insertStatement.setString(2, customer.getAddress());
			insertStatement.setString(3, customer.getEmail());
			//insertStatement.setLong(4, customer.getIdCustomer());		
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CustomerDAO:insert " + e.getMessage());
			e.printStackTrace();
		} finally {
			//insertStatement.close();
			//ConnectionFactory.close(insertStatement);
			//ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	
	public static void removeCustomer(int i) {
		
		PreparedStatement removeStatement = null;
		try {
			removeStatement = ConnectionFactory.getConnection().prepareStatement(removeStatementString);
			removeStatement.setLong(1,i);
			removeStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		public static void update(Customer client) {
			Connection dbConnection = ConnectionFactory.getConnection();
			PreparedStatement updateStatement = null;
			
			try {
				updateStatement = dbConnection.prepareStatement(updateStatementString);
				updateStatement.setInt(1, client.getIdCustomer());
				updateStatement.setString(2, client.getName());
				updateStatement.setString(3, client.getEmail());
				updateStatement.setString(4, client.getAddress());
				
				updateStatement.executeUpdate();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING,"ClientDAO:update " + e.getMessage());
			} finally {
				ConnectionFactory.close(updateStatement);
				ConnectionFactory.close(dbConnection);
			}
		}
	
	public static List<Customer> listCustomers() throws SQLException {
		List<Customer> customers = new ArrayList<Customer>();

		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = ConnectionFactory.getConnection().prepareStatement(selectStatementString);
			rs = findStatement.executeQuery();
			
			while (rs.next())
			customers.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		
		} finally {
			findStatement.close();
		}
		return customers;
		
	}
	}

