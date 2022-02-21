package jdbcpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * 
 * tomcat jdbc pool 连接池  DEMO
 * @author jangle
 * @email jangle@jangle.xyz
 * @time 2022年2月17日 下午2:35:47
 * 
 */
public class M {

	public static void main(String[] args) {
		DataSource dataSource = new DataSource();
		dataSource.setUrl("jdbc:mysql://mysql.jangle.xyz:10071/demo?characterEncoding=UTF8");
		dataSource.setUsername("jangle");
		dataSource.setPassword("2");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from bs_demo");
			while(result.next()) {
				int i = result.getInt(1);
				System.out.println(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
