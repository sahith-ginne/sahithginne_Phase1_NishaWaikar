package Flyawaydao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import Flyawaydto.Flyaway;
import Databaseconnection.ConnectionManager;
import Databaseconnection.ConnectionManagerImpl;

public class FlyawayDaoImpl implements FlyawayDao{
	private Connection connection;
	
	public FlyawayDaoImpl() {
		connection = new ConnectionManagerImpl().getConnection();
	}

	@Override
	public boolean addFlyaway(Flyaway flyaway) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFlyaway(String Airlines, String Arival, String Departure) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFlyaway(String Airlines, String Arival, String Departure) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchFlyaway(Flyaway flyaway) {
		boolean IsFlyawayInserted= false;
		String Airlines = flyaway.getAirlines();
		String Arival = flyaway.getArival();
		String Departure = flyaway.getDeparture();
		String Economy = flyaway.getEconomy();
		int Price = flyaway.getPrice();
		return IsFlyawayInserted;
		
	}

	@Override
	public Set<Flyaway> getAllFlyaway() {
		Set<Flyaway> flyaway = new HashSet<>();
		String sql = "select * from flights";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				
				String Airlines = resultSet.getString(1);
				String Arival = resultSet.getString(2);
				String Departure = resultSet.getString(3);
				String Economy = resultSet.getString(4);
				int Price = resultSet.getInt(5);
				Flyaway flyaway2 = new Flyaway(Airlines, Arival, Departure, Economy, Price);
				flyaway.add(flyaway2);
			}
	
	
	} catch (SQLException e) {
		e.printStackTrace();
		 
		}
		System.out.println(flyaway.toString());
		return flyaway;
	}

	@Override
	public Flyaway searchFlyaway() {
		return null;
		// TODO Auto-generated method stub
		
	}


	
	 public static void main(String[] args) {
		FlyawayDaoImpl obj = new FlyawayDaoImpl();
	obj.getAllFlyaway();
	}
	    }
