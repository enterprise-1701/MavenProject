package automationFramework.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import automationFramework.Utilities.Constant;

public class DbConnect {

	private static Connection connection;
	private static String IPADDRESS = "0x46A77964";
	private static String QUERY1 = "select top 10 [Guid] from [Logging].[dbo].[LogCampaign] where Ipaddress = ";

	public static void connect(String IpAddress) throws SQLException {

		try {
			connection = DriverManager.getConnection(Constant.DB_DEV);

			if (connection == null) {
				System.out.println("DB Connection Failed");
			} else {
				System.out.println("DB Connection Success!");
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY1 + IpAddress);
				while (rs.next()) {
					System.out.println("GUID is: " + rs.getString("Guid"));
				}

				connection.close();
				System.out.println("DB Connection Closed");
			}

		} catch (

		SQLException e)

		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		DbConnect dbConnect = new DbConnect();
		DbConnect.connect(IPADDRESS);
	}
}

