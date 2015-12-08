package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IdGeneration {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		Connection conn = DriverManager.getConnection(url,"system","system");
		CallableStatement callStmtObj = null;
		String getOrderIdQuery = "{call GET_ORDER_ID(?)}";
		callStmtObj = conn.prepareCall(getOrderIdQuery);
		callStmtObj.registerOutParameter(1, java.sql.Types.VARCHAR);
		callStmtObj.executeUpdate();
		String order_id = (String) callStmtObj.getString(1);
		System.out.println("Order ID obtained from database is : "+order_id);
			}
}
