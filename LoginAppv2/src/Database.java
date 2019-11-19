//*******Help with MySQL*********//
//show databases;				//show all the available databases
//use <name-of-database>;		//select which one to use
//create table <name-of-table>	//create table
//	(id int primary key not null,
//	username varchar(25) not null
//	primary key, ...);			
//show tables;					//what tables it has
//describe <name-of-table>;		//show the info of the table
//select * from <name-of-table>;//show the values of the table
//insert into <name-of-table>	//insert values to the table
//	(username,password) 
//	values("","");				
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	static String username="kostas";
	static String password="12345";
	//static String connUrl="jdbc:mysql://83.212.111.123:8000/accounts";
	static String connUrl="jdbc:mysql://localhost:8000/accounts";
	static Connection con=null;
	public Database() {
		con = getCon();
	}
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(connUrl,username,password);
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public boolean IsUserRegisteredWithPassword(String username, String password) {
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select USERNAME,PASSWORD from user where USERNAME=? and PASSWORD=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean IsUserRegistered(String username) {
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select USERNAME from user where USERNAME=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public void RegisterUser(String username, String password) {
		/*PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into user	(USERNAME,PASSWORD)	values(?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}*/
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into user (USERNAME,PASSWORD) values(?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
