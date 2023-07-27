package com.SpringDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class StudentDAO {

	private String driver;
	private String url;
	private String UserName;
	private String passWord;

	Connection con;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		System.out.println("this is driver setter method");
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		System.out.println("this is url setter method");

		this.url = url;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		System.out.println("this is Username setter method");

		UserName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		System.out.println("this is password setter method");
		this.passWord = passWord;
	}

	public void init() throws ClassNotFoundException, SQLException {
		createJdbcConnection();
	}

//	@PostConstruct
	public void createJdbcConnection() throws ClassNotFoundException, SQLException {
		System.out.println("post constructor called after creating the object ");
		// load the driver
		Class.forName(driver);

		// get Connections
		con = DriverManager.getConnection(url, UserName, passWord);

	}

	public void selectAllRows() throws ClassNotFoundException, SQLException {

		// execute Query
		Statement stmt = con.createStatement();
		ResultSet rst = stmt.executeQuery("SELECT * FROM jdbcdb.student;");

		while (rst.next()) {
			int studentid = rst.getInt(1);
			String studentName = rst.getString(2);
			String studentAddress = rst.getString(3);
			int StudentPh_Number = rst.getInt(4);
			System.out.println(studentid + "  " + studentName + "  " + studentAddress + "  " + StudentPh_Number);
		}

	}

	public void deleteSelectRecord(int id) throws ClassNotFoundException, SQLException {

		Statement stmt = con.createStatement();
		stmt.executeUpdate("delete from jdbcdb.student where id=" + id);
		System.out.println("this record was deleted by id" + id);

	}

	public void closeDBConnection() throws SQLException {
		con.close();
	}

//	@PreDestroy
	public void destroy() throws SQLException {
//	clean upOperation
		System.out.println("this is pre-destroyed method is use to close the constructor");
 
		closeDBConnection();
	}

}
