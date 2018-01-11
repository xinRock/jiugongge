package com.wgh.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @author 孟国庆 e-mail:mengguoqing@mail01.huawei.com
* @version 创建时间：2017年11月24日 上午10:06:40
* 类说明
*/
public class Test {

	public static void main(String[] args) {
		Connection connection = ConnDB.getConnection();
		try {
			Statement createStatement = connection.createStatement();
			
			String sql="SELECT * FROM `tb_user`";
			
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while(executeQuery.next()){
				
				System.out.println(executeQuery.getString("username"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date();
		String newTime = new SimpleDateFormat("yyyy年M月d日 EEEE")
				.format(date);
		System.out.println(newTime+"yyyy年M月d日 Eyyyy年M月d日 Eyyyy年M月d日 E");
	}
	
	
}
