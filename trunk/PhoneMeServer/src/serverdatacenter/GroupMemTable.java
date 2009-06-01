package serverdatacenter;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GroupMemTable {
	private Connection connection;
	
	public GroupMemTable(Connection connection) throws SQLException{
		this.connection = connection;
		
		//判断是否存在表，不存在则建表。
		Statement statement = (Statement) this.connection.createStatement();
		
		boolean tableExist = true;
		String sql = "DESCRIBE GroupMem";
		try{
			statement.execute(sql);
		}
		catch (Exception e) {
			tableExist = false;
		}
		
		if (!tableExist){
			sql = "CREATE TABLE GroupMem(gid BIGINT NOT NULL, uid BIGINT NOT NULL, INDEX(gid, uid));";
			statement.execute(sql);
		}
	}

}
