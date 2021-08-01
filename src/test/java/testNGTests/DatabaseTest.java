package testNGTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DatabaseTest extends Test1 {
	WebDriver driver=null;
	
	public DatabaseTest(WebDriver driver){
		this.driver=driver;
	}

	public DatabaseTest() {
		
	}
	
	String host= "localhost";
	String port= "3306";

	@Test
	public void dataBaseTest1() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadb", "root", "password1");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select name, id, location, age from employeeinfo where age > 20");
		rs.next();
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString("id"));
		System.out.println(rs.getString("location"));
		System.out.println(rs.getString("age"));
	}
}
